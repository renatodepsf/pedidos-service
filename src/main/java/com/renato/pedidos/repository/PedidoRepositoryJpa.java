package com.renato.pedidos.repository;

import com.renato.pedidos.infra.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepositoryJpa extends JpaRepository<PedidoEntity, Long> {
}
