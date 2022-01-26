package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.aggregate;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.ActualizarUsuarioCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.AgregarUsuarioCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.EliminarUsuarioCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.events.UsuarioActualizarEvento;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.events.UsuarioAgregarEvento;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.events.UsuarioEliminarEvento;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Aggregate()
public class UsuarioAggregate {

    @AggregateIdentifier
    private String _usuarioId = UUID.randomUUID().toString();

    private String usuarioId;
    private String dni;
    private String nombre;
    private String apellidos;
    private String codigoTarjeta;

    @CommandHandler
    public UsuarioAggregate(AgregarUsuarioCommand command){
        UsuarioAgregarEvento usuarioAgregarEvento = new UsuarioAgregarEvento();
        BeanUtils.copyProperties(command,usuarioAgregarEvento);
        AggregateLifecycle.apply(usuarioAgregarEvento);
    }
    @CommandHandler
    public UsuarioAggregate(ActualizarUsuarioCommand command){
        UsuarioActualizarEvento usuarioActualizarEvento = new UsuarioActualizarEvento();
        BeanUtils.copyProperties(command,usuarioActualizarEvento);
        AggregateLifecycle.apply(usuarioActualizarEvento);
    }
    @CommandHandler
    public UsuarioAggregate(EliminarUsuarioCommand command){
        UsuarioEliminarEvento usuarioEliminarEvento = new UsuarioEliminarEvento();
        BeanUtils.copyProperties(command,usuarioEliminarEvento);
        AggregateLifecycle.apply(usuarioEliminarEvento);
    }
    @EventSourcingHandler
    public void on(AgregarUsuarioCommand command){
       this.usuarioId = command.getUsuarioId();
       this.apellidos = command.getApellidos();
       this.nombre = command.getNombre();
       this.codigoTarjeta = command.getCodigoTarjeta();
       this.dni = command.getDni();
    }
    @EventSourcingHandler
    public void on(ActualizarUsuarioCommand command){
        this.usuarioId = command.getUsuarioId();
        this.apellidos = command.getApellidos();
        this.nombre = command.getNombre();
        this.codigoTarjeta = command.getCodigoTarjeta();
        this.dni = command.getDni();
    }
    @EventSourcingHandler
    public void on(EliminarUsuarioCommand command){
        this.usuarioId = command.getUsuarioId();
    }

}
