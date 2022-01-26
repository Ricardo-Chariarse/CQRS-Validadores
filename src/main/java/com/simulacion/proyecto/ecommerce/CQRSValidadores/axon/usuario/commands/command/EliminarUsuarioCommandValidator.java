package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.StringPredicate;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

public class EliminarUsuarioCommandValidator extends AbstractValidator<EliminarUsuarioCommand> {
    @Override
    public void rules() {
        ruleFor(EliminarUsuarioCommand::getUsuarioId)
                .must(not(stringEmptyOrNull()))
                .withMessage("El id no debe estar vacio")
                .withFieldName("usuarioId");
    }
}
