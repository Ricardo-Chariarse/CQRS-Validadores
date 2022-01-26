package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.aggregate;


import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.events.AgregarProductoEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.util.UUID;

@Aggregate
public class ProductoAggregate {
    @AggregateIdentifier
    private String _productoId= UUID.randomUUID().toString();

    private String productoId;
    private String nombre;
    private Integer cantidad;
    private BigDecimal precio;

    @CommandHandler
    public ProductoAggregate(AgregarProductoCommand command){
        AgregarProductoEvent event = new AgregarProductoEvent();
        BeanUtils.copyProperties(command,event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(AgregarProductoCommand command){
        this.productoId = command.getProductoId();
        this.nombre = command.getNombre();
        this.cantidad = command.getCantidad();
        this.precio = command.getPrecio();
    }
}
