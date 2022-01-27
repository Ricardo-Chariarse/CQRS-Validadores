package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command;


import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;


@Getter
@Setter
public class EliminarCompraCommand implements Serializable {
    @TargetAggregateIdentifier
    private String compraId;
}
