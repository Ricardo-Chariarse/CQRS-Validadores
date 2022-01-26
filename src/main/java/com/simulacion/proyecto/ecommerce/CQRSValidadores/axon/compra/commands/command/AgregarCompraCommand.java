package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command;


import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.AgregarUsuarioCommand;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;

@Data
@Builder
public class AgregarCompraCommand {
    @TargetAggregateIdentifier
    private String compraId;
    private AgregarUsuarioCommand usuarioCommand;
    private List<AgregarProductoCommand> productoCommands;
}
