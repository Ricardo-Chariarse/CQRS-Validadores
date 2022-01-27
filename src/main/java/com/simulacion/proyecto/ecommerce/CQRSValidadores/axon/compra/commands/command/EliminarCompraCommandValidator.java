package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.compra.commands.command;

import br.com.fluentvalidator.AbstractValidator;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command.EliminarUsuarioCommand;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

public class EliminarCompraCommandValidator extends AbstractValidator<EliminarCompraCommand> {
    @Override
    public void rules() {
        ruleFor(EliminarCompraCommand::getCompraId)
                .must(not(stringEmptyOrNull()))
                .withMessage("El id no debe estar vacio")
                .withFieldName("compraId");
    }
}