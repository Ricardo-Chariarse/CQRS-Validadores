package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.controller;

import an.awesome.pipelinr.Pipeline;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.EliminarUsuarioCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.model.StatusResponse;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.AgregarUsuarioCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update")
    public ResponseEntity<StatusResponse> updateUsuario(@RequestBody AgregarUsuarioCommand command){
        var result = commandGateway.sendAndWait(command);
        var r = new StatusResponse(true, "Usuario actualizado",command.getUsuarioId());
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<StatusResponse> deleteUsuario(@RequestBody EliminarUsuarioCommand command){
        var result = commandGateway.sendAndWait(command);
        var r = new StatusResponse(true, "Usuario eliminado",command.getUsuarioId());
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

}
