package com.renato.pedidos.repository;

import com.renato.pedidos.domain.Pedido;

public interface PedidoRepository {

    Pedido salvar(Pedido pedido);
    Pedido buscarPedidoPorId(Long id);
}
