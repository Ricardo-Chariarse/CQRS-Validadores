package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.events;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.data.Compra;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.data.CompraRepository;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.Data.ProductoRepositorio;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.events.AgregarProductoEvent;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.Data.UsuarioRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
@ProcessingGroup("compra")
public class CompraEventHandler {

    @Resource
    private CompraRepository compraRepository;

    @Resource
    private ProductoRepositorio productoRepositorio;

    @Resource
    private UsuarioRepository usuarioRepository;

    @EventHandler
    private void on(AgregarCompraEvent event){
        Compra compra = new Compra();
        if(event.getCompraId() != null){
            List<AgregarProductoCommand> productoCommands = new ArrayList<AgregarProductoCommand>();
            boolean existUser = usuarioRepository.existsById(event.getUsuarioCommand().getUsuarioId());
            if(existUser){
                compra.setCompraId(event.getCompraId());
                compra.setUsuarioId(event.getUsuarioCommand().getUsuarioId());
                for (AgregarProductoCommand item: event.getProductoCommands()) {
                    if(item.getProductoId() != null){
                        boolean exist = productoRepositorio.existsById(item.getProductoId());
                        if(exist){
                            compra.setProductoId(item.getProductoId());
                            compra.setCantidad(item.getCantidad());
                            compra.setNombre(item.getNombre());
                            compra.setPrecio(item.getPrecio());
                            compraRepository.save(compra);
                        }
                    }
                }
            }

        }
    }

}
