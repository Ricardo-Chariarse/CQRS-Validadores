package com.simulacion.proyecto.ecommerce.CQRSValidadores.usuario.commands.aggregate;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.usuario.commands.command.AgregarUsuarioCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.usuario.commands.events.UsuarioAgregarEvento;
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

    @EventSourcingHandler
    public void on(AgregarUsuarioCommand command){
       this.usuarioId = command.getUsuarioId();
       this.apellidos = command.getApellidos();
       this.nombre = command.getNombre();
       this.codigoTarjeta = command.getCodigoTarjeta();
       this.dni = command.getDni();
    }

}
