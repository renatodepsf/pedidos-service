package com.renato.pedidos.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public class PedidoRequest {

    @Positive(message = "O valor deve ser positivo")
    @NotNull(message = "O valor é obrigatório")
    private BigDecimal vlTotal;

    public BigDecimal getVlTotal() {
        return vlTotal;
    }
}
