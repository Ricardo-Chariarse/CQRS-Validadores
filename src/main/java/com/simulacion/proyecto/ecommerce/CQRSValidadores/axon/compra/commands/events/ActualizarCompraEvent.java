package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.events;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.AgregarUsuarioCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarCompraEvent {
    private String compraId;
    private AgregarUsuarioCommand usuarioCommand;
    private List<AgregarProductoCommand> productoCommands;
}
