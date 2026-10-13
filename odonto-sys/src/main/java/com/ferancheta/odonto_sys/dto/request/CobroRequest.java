package com.ferancheta.odonto_sys.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record CobroRequest(
        @NotNull(message = "El paciente es obligatorio")
        Integer idPaciente,

        @NotNull(message = "El doctor es obligatorio")
        Integer idDoctor,

        Integer idCita,

        @NotEmpty(message = "Debe agregar al menos un servicio")
        @Valid
        List<ServicioCobroRequest> servicios,

        BigDecimal costoLaboratorio,

        Integer idMetodoPago,

        BigDecimal montoEfectivo,

        BigDecimal montoTarjeta,

        BigDecimal montoTransferencia
) {
}
