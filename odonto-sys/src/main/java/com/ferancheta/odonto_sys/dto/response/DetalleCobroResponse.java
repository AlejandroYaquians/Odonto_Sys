package com.ferancheta.odonto_sys.dto.response;

import java.math.BigDecimal;

public record DetalleCobroResponse(
        Integer idServicio,
        BigDecimal precioAplicado
) {
}
