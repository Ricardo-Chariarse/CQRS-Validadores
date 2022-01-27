package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command;

import an.awesome.pipelinr.Command;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.model.StatusResponse;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Builder
@Data
public class AgregarProductoCommand implements Command<StatusResponse> {
    @TargetAggregateIdentifier
    private String productoId;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;
}
