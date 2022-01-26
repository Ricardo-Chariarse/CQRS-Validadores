package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.usuario.commands.command;

import br.com.fluentvalidator.AbstractValidator;

import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

public class ActualizarUsuarioCommandValidator extends AbstractValidator<ActualizarUsuarioCommand> {
    @Override
    public void rules() {
        ruleFor(ActualizarUsuarioCommand::getNombre)
                .must(not(stringEmptyOrNull()))
                .withMessage("El nombre no debe estar vacio")
                .withFieldName("nombre");
        ruleFor(ActualizarUsuarioCommand::getApellidos)
                .must(not(stringEmptyOrNull()))
                .withMessage("El apellido no debe estar vacio")
                .withFieldName("apellido");
        ruleFor(ActualizarUsuarioCommand::getDni)
                .must(not(stringEmptyOrNull()))
                .withMessage("El dni no debe estar vacio")
                .withFieldName("dni");
    }
}
