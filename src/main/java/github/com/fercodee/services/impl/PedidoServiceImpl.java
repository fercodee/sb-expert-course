package github.com.fercodee.services.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import github.com.fercodee.domain.entity.Cliente;
import github.com.fercodee.domain.entity.ItemPedido;
import github.com.fercodee.domain.entity.Pedido;
import github.com.fercodee.domain.entity.Produto;
import github.com.fercodee.domain.enums.StatusPedido;
import github.com.fercodee.domain.repositories.Clientes;
import github.com.fercodee.domain.repositories.ItemsPedidos;
import github.com.fercodee.domain.repositories.Pedidos;
import github.com.fercodee.domain.repositories.Produtos;
import github.com.fercodee.exception.RegraNegocioException;
import github.com.fercodee.rest.dto.ItemPedidoDTO;
import github.com.fercodee.rest.dto.PedidoDTO;
import github.com.fercodee.services.PedidoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Lombok annotation to generate constructor with required arguments
public class PedidoServiceImpl implements PedidoService {
    private final Pedidos pedidosRepository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItemsPedidos itemsPedidosRepository;

    @Override
    @Transactional // Spring annotation to manage transaction
    public Pedido save(PedidoDTO pedidoDTO) {
        Integer idCliente = pedidoDTO.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de Cliente inválido"));

        Pedido pedido = new Pedido();
        pedido.setTotal(pedidoDTO.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itemsPedidos = converterItems(pedido, pedidoDTO.getItems());
        pedidosRepository.save(pedido);
        itemsPedidosRepository.saveAll(itemsPedidos);
        pedido.setItens(itemsPedidos);
        return pedido;
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items) {
        if (items.isEmpty()) {
            throw new RegraNegocioException("Não é possível realizar um pedido sem items.");
        }

        return items
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(() -> new RegraNegocioException("Código de Produto inválido: " + idProduto));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                })
                .collect(Collectors.toList());

    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidosRepository
                .findByIdFetchItens(id);        
    }

}
