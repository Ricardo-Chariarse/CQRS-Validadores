package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
public class EliminarUsuarioCommand implements Serializable {
    @TargetAggregateIdentifier
    private String usuarioId;
}
