package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class ActualizarUsuarioCommand {
    @TargetAggregateIdentifier
    private String usuarioId;
    private String dni;
    private String nombre;
    private String apellidos;
    private String codigoTarjeta;
}
