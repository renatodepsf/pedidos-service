package com.renato.pedidos.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Pedido {

    private Long id;
    private BigDecimal vlTotal;
    private StatusPedido status;
    private LocalDateTime dtInclusao;
    private LocalDateTime dtCancelamento;

    public Pedido(BigDecimal vlTotal) {
        this.vlTotal = vlTotal;
        this.status = StatusPedido.PAGO; //pedido inicia como pago
        this.dtInclusao = LocalDateTime.now();
    }

    public Pedido(Long id, BigDecimal vlTotal, StatusPedido status, LocalDateTime dtInclusao, LocalDateTime dtCancelamento) {
        this.id = id;
        this.vlTotal = vlTotal;
        this.status = status;
        this.dtInclusao = dtInclusao;
        this.dtCancelamento = dtCancelamento;
    }

    public void enviar() {
        if (this.status != StatusPedido.PAGO) {
            throw new IllegalStateException("Pedido não pode ser enviado");
        }
        this.status = StatusPedido.ENVIADO;
    }

    public void entregar() {
        if (this.status != StatusPedido.ENVIADO) {
            throw new IllegalStateException("Pedido não pode ser entregue");
        }
        this.status = StatusPedido.ENTREGUE;
    }

    public void cancelar() {
        if (this.status == StatusPedido.ENVIADO || this.status == StatusPedido.ENTREGUE) {
            throw new IllegalStateException("Pedido não pode ser cancelado");
        }
        this.status = StatusPedido.CANCELADO;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getVlTotal() {
        return vlTotal;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public LocalDateTime getDtInclusao() {
        return dtInclusao;
    }

    public LocalDateTime getDtCancelamento() {
        return dtCancelamento;
    }
}
