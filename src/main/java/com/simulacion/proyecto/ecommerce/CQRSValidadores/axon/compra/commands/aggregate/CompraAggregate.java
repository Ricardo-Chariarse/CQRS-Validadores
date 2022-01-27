package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.aggregate;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command.ActualizarCompraCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command.AgregarCompraCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command.EliminarCompraCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.events.ActualizarCompraEvent;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.events.AgregarCompraEvent;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.events.EliminarCompraEvent;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.AgregarUsuarioCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.UUID;

@Aggregate
public class CompraAggregate {
    @AggregateIdentifier
    private String _compraId= UUID.randomUUID().toString();

    private String compraId;
    private AgregarUsuarioCommand usuarioCommand;
    private List<AgregarProductoCommand> productoCommands;

    @CommandHandler
    public CompraAggregate(AgregarCompraCommand command){
        AgregarCompraEvent event = new AgregarCompraEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public CompraAggregate(ActualizarCompraCommand command){
        ActualizarCompraEvent event = new ActualizarCompraEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }
    @CommandHandler
    public CompraAggregate(EliminarCompraCommand command){
        EliminarCompraEvent event = new EliminarCompraEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AgregarCompraCommand command){
        this.compraId = command.getCompraId();
        this.usuarioCommand = command.getUsuarioCommand();
        this.productoCommands = command.getProductoCommands();
    }
    @EventSourcingHandler
    public void on(ActualizarCompraCommand command){
        this.compraId = command.getCompraId();
        this.usuarioCommand = command.getUsuarioCommand();
        this.productoCommands = command.getProductoCommands();
    }
    @EventSourcingHandler
    public void on(EliminarCompraCommand command){
        this.compraId = command.getCompraId();
    }
}
