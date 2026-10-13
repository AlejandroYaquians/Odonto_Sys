package com.ferancheta.odonto_sys.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.List;

public record HistorialClinicoCobroRequest(
        Integer idCita,

        @NotNull(message = "El paciente es obligatorio")
        Integer idPaciente,

        @NotNull(message = "El doctor es obligatorio")
        Integer idDoctor,

        String descripcion,

        String medicamento,

        String dosis,

        String frecuencia,

        String duracion,

        String indicaciones,

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
