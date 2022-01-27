package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.querys.projection;


import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.data.Compra;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.data.CompraRepository;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.querys.query.ObtenerComprasQuery;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.querys.viewmodels.ComprasResponseModel;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.Data.Usuario;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.query.ObtenerUsuariosQuery;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.querys.viewmodels.UsuarioResponseModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CompraProjection {

    @Resource
    private CompraRepository compraRepository;

    @QueryHandler
    public List<ComprasResponseModel> handle(ObtenerComprasQuery query){
        List<Compra> compras = compraRepository.findAll();
        List<ComprasResponseModel> comprasResponseModels =
                compras.stream().map(compra -> ComprasResponseModel.builder()
                        .compraId(compra.getCompraId())
                        .usuarioId(compra.getUsuarioId())
                        .nombre(compra.getNombre())
                        .productoId(compra.getProductoId())
                        .cantidad(compra.getCantidad())
                        .precio(compra.getPrecio())
                        .build()
                ).collect(Collectors.toList());
        return comprasResponseModels;
    }

}
