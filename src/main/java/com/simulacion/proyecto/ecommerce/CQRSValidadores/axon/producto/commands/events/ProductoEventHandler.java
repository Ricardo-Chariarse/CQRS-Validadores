package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.events;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.Data.Producto;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.Data.ProductoRepositorio;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@ProcessingGroup("producto")
public class ProductoEventHandler {

    @Resource
    private ProductoRepositorio repositorio;

    @EventHandler
    public void on(AgregarProductoEvent event){
        Producto producto = new Producto();
        if(event.getProductoId() != null){
            BeanUtils.copyProperties(event,producto);
            repositorio.save(producto);
        }
    }
}
