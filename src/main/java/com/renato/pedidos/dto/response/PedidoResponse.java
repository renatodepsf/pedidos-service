package com.renato.pedidos.dto.response;

import com.renato.pedidos.domain.StatusPedido;

import java.math.BigDecimal;

public class PedidoResponse {

    private Long id;
    private BigDecimal vlTotal;
    private StatusPedido status;

    public PedidoResponse(Long id, BigDecimal vlTotal, StatusPedido status) {
        this.id = id;
        this.vlTotal = vlTotal;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getVlTotal() {
        return vlTotal;
    }

    public void setVlTotal(BigDecimal vlTotal) {
        this.vlTotal = vlTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
