package com.renato.pedidos.repository.impl;

import com.renato.pedidos.domain.Pedido;
import com.renato.pedidos.infra.entity.PedidoEntity;
import com.renato.pedidos.mapper.PedidoMapper;
import com.renato.pedidos.repository.PedidoRepository;
import com.renato.pedidos.repository.PedidoRepositoryJpa;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoRepositoryJpa repository;

    public PedidoRepositoryImpl(PedidoRepositoryJpa repository) {
        this.repository = repository;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        PedidoEntity entity = PedidoMapper.domainToEntity(pedido);
        PedidoEntity entitySalva = repository.save(entity);
        return PedidoMapper.entityToDomain(entitySalva);
    }

    @Override
    public Pedido buscarPedidoPorId(Long id) {
        Optional<PedidoEntity> entity = repository.findById(id);
        if (!entity.isEmpty()) return PedidoMapper.entityToDomain(entity.get());
        return null;
    }
}
