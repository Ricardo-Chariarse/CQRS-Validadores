package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command;

import br.com.fluentvalidator.AbstractValidator;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command.AgregarProductoCommandValidator;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.AgregarUsuarioCommandValidator;

import static br.com.fluentvalidator.predicate.ObjectPredicate.nullValue;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;

public class AgregarCompraCommandValidator extends AbstractValidator<AgregarCompraCommand> {
    @Override
    public void rules() {
        setPropertyOnContext("AgregarCompraCommandValidator");
        ruleFor(AgregarCompraCommand::getUsuarioCommand)
                .whenever(not(nullValue()))
                .withValidator(new AgregarUsuarioCommandValidator())
                .critical();
        ruleForEach(AgregarCompraCommand::getProductoCommands)
                .whenever(not(nullValue()))
                .withValidator(new AgregarProductoCommandValidator())
                .critical();
    }
}
