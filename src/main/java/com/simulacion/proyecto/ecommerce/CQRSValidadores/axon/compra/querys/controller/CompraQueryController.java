package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.querys.controller;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.querys.query.ObtenerComprasQuery;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.querys.viewmodels.ComprasResponseModel;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.query.ObtenerUsuariosQuery;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.viewmodels.UsuarioResponseModel;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraQueryController {

    @Resource
    private QueryGateway queryGateway;

    @GetMapping("/obtenerCompras")
    public List<ComprasResponseModel> obtenerCompras(){
        ObtenerComprasQuery obtenerComprasQuery = new ObtenerComprasQuery();
        List<ComprasResponseModel> comprasResponseModels =
                queryGateway.query(obtenerComprasQuery,
                                ResponseTypes.multipleInstancesOf(ComprasResponseModel.class))
                        .join();
        return comprasResponseModels;
    }

}
