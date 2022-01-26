package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.projection;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.Data.Usuario;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.Data.UsuarioRepository;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.query.ObtenerUsuariosQuery;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.viewmodels.UsuarioResponseModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UsuarioProjection {

    @Resource
    private UsuarioRepository usuarioRepository;

    @QueryHandler
    public List<UsuarioResponseModel> handle(ObtenerUsuariosQuery query){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseModel> usuarioResponseModels =
                usuarios.stream().map(usuario -> UsuarioResponseModel.builder()
                        .usuarioId(usuario.getUsuarioId())
                        .nombre(usuario.getNombre())
                        .apellidos(usuario.getApellidos())
                        .dni(usuario.getDni())
                        .codigoTarjeta(usuario.getCodigoTarjeta())
                        .build()
                ).collect(Collectors.toList());
        return usuarioResponseModels;
    }

}
