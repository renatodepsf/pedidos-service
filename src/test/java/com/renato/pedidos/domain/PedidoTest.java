package com.renato.pedidos.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PedidoTest {

    // testar se o pedido nasce pago
    // testar se o pedido após ser enviado fica com status enviado
    // testar cancelamento: status deve ser cancelado se pedido foi enviado
    // testar cancelamento: se pedido foi entregue, gerar excecao

    @Test
    void testPedidoNasceComStatusPago() {
        Pedido pedido = new Pedido(new BigDecimal("100.0"));
        assertEquals(StatusPedido.PAGO, pedido.getStatus());
    }

    @Test
    void testPedidoStatusEnviado() {
        Pedido pedido = new Pedido(new BigDecimal("100.0"));
        pedido.enviar();
        assertEquals(StatusPedido.ENVIADO, pedido.getStatus());
    }
 }
