package com.ferancheta.odonto_sys.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ServicioCobroRequest(
        @NotNull(message = "El servicio es obligatorio")
        Integer idServicio,

        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.00", message = "El precio no puede ser negativo")
        BigDecimal precioAplicado
) {
}
