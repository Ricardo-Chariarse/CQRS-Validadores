package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command;

import br.com.fluentvalidator.AbstractValidator;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommandValidator;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.AgregarUsuarioCommandValidator;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;

public class ActualizarCompraCommandValidator extends AbstractValidator<ActualizarCompraCommand> {
    @Override
    public void rules() {
        setPropertyOnContext("ActualizarCompraCommandValidator");
        ruleFor(ActualizarCompraCommand::getUsuarioCommand)
                .whenever(not(nullValue()))
                .withValidator(new AgregarUsuarioCommandValidator())
                .critical();
        ruleForEach(ActualizarCompraCommand::getProductoCommands)
                .whenever(not(nullValue()))
                .withValidator(new AgregarProductoCommandValidator())
                .critical();
    }
}
