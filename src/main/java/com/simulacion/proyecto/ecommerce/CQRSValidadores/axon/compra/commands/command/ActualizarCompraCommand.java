package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.AgregarUsuarioCommand;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ActualizarCompraCommand {
    @TargetAggregateIdentifier
    private String compraId;
    private AgregarUsuarioCommand usuarioCommand;
    private List<AgregarProductoCommand> productoCommands;
}
