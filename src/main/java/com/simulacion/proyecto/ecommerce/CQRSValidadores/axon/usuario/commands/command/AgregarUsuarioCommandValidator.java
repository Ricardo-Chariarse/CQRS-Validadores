package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command;

import br.com.fluentvalidator.AbstractValidator;
import br.com.fluentvalidator.predicate.StringPredicate;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;

public class AgregarUsuarioCommandValidator extends AbstractValidator<AgregarUsuarioCommand> {

    @Override
    public void rules() {
        setPropertyOnContext("AgregarUsuarioCommandValidator");

        ruleFor(AgregarUsuarioCommand::getNombre)
                .must(not(StringPredicate.stringEmptyOrNull()))
                .withMessage("El nombre no debe estar vacio")
                .withFieldName("nombre");

    }
}
