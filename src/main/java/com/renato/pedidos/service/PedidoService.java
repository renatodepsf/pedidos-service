package com.renato.pedidos.service;

import com.renato.pedidos.domain.Pedido;
import com.renato.pedidos.dto.request.PedidoRequest;
import com.renato.pedidos.dto.response.PedidoResponse;
import com.renato.pedidos.mapper.PedidoMapper;
import com.renato.pedidos.repository.impl.PedidoRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private final PedidoRepositoryImpl repository;

    public PedidoService(PedidoRepositoryImpl pedidoRepository) {
        this.repository = pedidoRepository;
    }

    @Transactional
    public PedidoResponse criarPedido(PedidoRequest request) {
        Pedido pedido = PedidoMapper.toDomain(request);
        Pedido pedidoSalvo = repository.salvar(pedido);
        pedidoSalvo.enviar();
        return PedidoMapper.toResponse(pedidoSalvo);
    }

    public PedidoResponse buscarPedidoPorId(Long id) {
        Pedido pedido = repository.buscarPedidoPorId(id);
        return PedidoMapper.toResponse(pedido);
    }
}
