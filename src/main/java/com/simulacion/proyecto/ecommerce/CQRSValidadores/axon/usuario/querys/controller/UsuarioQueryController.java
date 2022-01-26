package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.controller;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.query.ObtenerUsuariosQuery;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.viewmodels.UsuarioResponseModel;
import org.axonframework.messaging.responsetypes.ResponseType;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/usuario")
public class UsuarioQueryController {

    @Resource
    private QueryGateway queryGateway;

    @GetMapping("/obtenerUsuarios")
    public List<UsuarioResponseModel> obtenerUsuarios(){
        ObtenerUsuariosQuery obtenerUsuariosQuery = new ObtenerUsuariosQuery();
        List<UsuarioResponseModel> usuarioResponseModels =
                queryGateway.query(obtenerUsuariosQuery,
                        ResponseTypes.multipleInstancesOf(UsuarioResponseModel.class))
                        .join();
        return usuarioResponseModels;
    }

}
