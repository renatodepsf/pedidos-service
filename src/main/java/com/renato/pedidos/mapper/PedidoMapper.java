package com.renato.pedidos.mapper;

import com.renato.pedidos.domain.Pedido;
import com.renato.pedidos.dto.request.PedidoRequest;
import com.renato.pedidos.dto.response.PedidoResponse;
import com.renato.pedidos.infra.entity.PedidoEntity;

public class PedidoMapper {

    public static PedidoEntity domainToEntity(Pedido domain) {
        PedidoEntity entity = new PedidoEntity();
        entity.setVlTotal(domain.getVlTotal());
        entity.setStatus(domain.getStatus());
        entity.setDtInclusao(domain.getDtInclusao());
        entity.setDtCancelamento(domain.getDtCancelamento());
        return entity;
    }

    public static Pedido entityToDomain(PedidoEntity entity) {
        return new Pedido(
                (long) entity.getId(),
                entity.getVlTotal(),
                entity.getStatus(),
                entity.getDtInclusao(),
                entity.getDtCancelamento()
        );
    }

    public static PedidoResponse toResponse(Pedido domain) {
        return new PedidoResponse(
                domain.getId(),
                domain.getVlTotal(),
                domain.getStatus()
        );
    }

    public static Pedido toDomain(PedidoRequest request) {
        return new Pedido(request.getVlTotal());
    }
}
