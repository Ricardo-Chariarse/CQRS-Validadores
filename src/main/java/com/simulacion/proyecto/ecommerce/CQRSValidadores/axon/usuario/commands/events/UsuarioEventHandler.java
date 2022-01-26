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

}
