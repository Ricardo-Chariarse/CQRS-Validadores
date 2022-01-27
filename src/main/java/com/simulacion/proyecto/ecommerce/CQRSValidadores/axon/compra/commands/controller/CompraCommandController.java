package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.controller;

import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command.AgregarCompraCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command.EliminarCompraCommand;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.model.StatusResponse;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@RequestMapping("/compra")
public class CompraCommandController {

    @Resource
    private CommandGateway commandGateway;

    @PostMapping("/addCompra")
    public ResponseEntity<StatusResponse> addCompra(@RequestBody AgregarCompraCommand command){
        String id = UUID.randomUUID().toString();
        command.setCompraId(id);
        var result = commandGateway.sendAndWait(command);
        var r = new StatusResponse(true, "Compra agregada",id);
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
    @PutMapping("/updateCompra")
    public ResponseEntity<StatusResponse> updateCompra(@RequestBody AgregarCompraCommand command){
        var result = commandGateway.sendAndWait(command);
        var r = new StatusResponse(true, "Compra actualizada",command.getCompraId());
        return new ResponseEntity<>(r, HttpStatus.OK);
    }
    @DeleteMapping("/deleteCompra")
    public ResponseEntity<StatusResponse> deleteCompra(@RequestBody EliminarCompraCommand command){
        var result = commandGateway.sendAndWait(command);
        var r = new StatusResponse(true, "Compra eliminada",command.getCompraId());
        return new ResponseEntity<>(r, HttpStatus.OK);
    }

}
