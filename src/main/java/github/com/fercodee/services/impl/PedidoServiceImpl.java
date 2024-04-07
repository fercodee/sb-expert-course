package github.com.fercodee.services.impl;

import org.springframework.stereotype.Service;

import github.com.fercodee.domain.repositories.Pedidos;
import github.com.fercodee.services.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {
    private Pedidos pedidos;

    public PedidoServiceImpl(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

}
