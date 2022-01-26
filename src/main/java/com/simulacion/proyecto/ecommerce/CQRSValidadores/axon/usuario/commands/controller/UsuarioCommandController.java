package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.controller;

import an.awesome.pipelinr.Pipeline;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.model.StatusResponse;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.AgregarUsuarioCommand;
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
@RequestMapping("/usuario")
public class UsuarioCommandController {

    @Resource
    private CommandGateway commandGateway;

    @Resource
    private Pipeline pipeline;

    @Resource
    private ApplicationContext ctx;

    @PostMapping("/add")
    public ResponseEntity<StatusResponse> addUsuario(@RequestBody AgregarUsuarioCommand command){
        String id = UUID.randomUUID().toString();
        command.setUsuarioId(id);
        var result = commandGateway.sendAndWait(command);
        var r = new StatusResponse(true, "Usuario agregado",id);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

}
