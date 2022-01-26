package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.controller;

import an.awesome.pipelinr.Pipeline;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.model.StatusResponse;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/producto")
public class ProductoCommandController {

    @Resource
    private CommandGateway commandGateway;

    @Resource
    private Pipeline pipeline;

    @Resource
    private ApplicationContext ctx;

    @PostMapping("/add")
    public ResponseEntity<StatusResponse> addProducto(@RequestBody AgregarProductoCommand command){
        String id = UUID.randomUUID().toString();
        command.setProductoId(id);
        var result = commandGateway.sendAndWait(command);
        var r = new StatusResponse(true, "Producto agregado",id);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

}
