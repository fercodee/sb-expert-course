package github.com.fercodee.services;

import github.com.fercodee.domain.entity.Pedido;
import github.com.fercodee.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido save(PedidoDTO pedidoDTO);    
}
