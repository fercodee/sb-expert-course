package github.com.fercodee.domain.repositories;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import github.com.fercodee.domain.entity.Cliente;
import github.com.fercodee.domain.entity.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{
    List<Pedido> findByCliente(Cliente cliente);
    Optional<Pedido> findByIdFetchItens(Integer id);
}