package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.events;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.Data.Usuario;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.Data.UsuarioRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@ProcessingGroup("usuario")
public class UsuarioEventHandler {

    @Resource
    private UsuarioRepository usuarioRepository;

    @EventHandler
    public void on(UsuarioAgregarEvento evento){
        Usuario usuario = new Usuario();
        if(evento.getUsuarioId() != null){
            BeanUtils.copyProperties(evento,usuario);
            usuarioRepository.save(usuario);
        }
    }
    @EventHandler
    public void on(UsuarioActualizarEvento evento){
        boolean existe = usuarioRepository.existsById(evento.getUsuarioId());
        if(evento.getUsuarioId() != null && existe){
            var usuario = usuarioRepository.getById(evento.getUsuarioId());
            usuario.setNombre(evento.getNombre());
            usuario.setApellidos(evento.getApellidos());
            usuario.setCodigoTarjeta(evento.getCodigoTarjeta());
            usuario.setDni(evento.getDni());
            usuarioRepository.save(usuario);
        }
    }
    @EventHandler
    public void on(UsuarioEliminarEvento evento){
        boolean existe = usuarioRepository.existsById(evento.getUsuarioId());
        if(existe){
            usuarioRepository.deleteById(evento.getUsuarioId());
        }
    }

}
