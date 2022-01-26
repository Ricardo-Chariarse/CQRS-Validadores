package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command;

import an.awesome.pipelinr.Command;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.model.StatusResponse;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class AgregarUsuarioCommand implements Command<StatusResponse> {
    @TargetAggregateIdentifier
    private String usuarioId;
    private String dni;
    private String nombre;
    private String apellidos;
    private String codigoTarjeta;
}
