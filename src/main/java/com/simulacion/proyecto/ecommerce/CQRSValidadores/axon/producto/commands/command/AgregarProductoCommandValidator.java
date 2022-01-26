package com.simulacion.proyecto.ecommerce.CQRSValidadores.axon.producto.commands.command;

import br.com.fluentvalidator.AbstractValidator;

import java.math.BigDecimal;

import static br.com.fluentvalidator.predicate.ComparablePredicate.greaterThanOrEqual;
import static br.com.fluentvalidator.predicate.LogicalPredicate.not;
import static br.com.fluentvalidator.predicate.StringPredicate.stringEmptyOrNull;

public class AgregarProductoCommandValidator extends AbstractValidator<AgregarProductoCommand> {
    @Override
    public void rules() {
        setPropertyOnContext("AgregarProductoCommandValidator");

        ruleFor(AgregarProductoCommand::getPrecio)
                .must(greaterThanOrEqual(BigDecimal.ONE))
                .withMessage("EL precio debe ser mayor que 1")
                .withFieldName("precio");

        ruleFor(AgregarProductoCommand::getNombre)
                .must(not(stringEmptyOrNull()))
                .withMessage("El nombre no debe estar vacio")
                .withFieldName("nombre");
        ruleFor(AgregarProductoCommand::getCantidad)
                .must(greaterThanOrEqual(1))
                .withMessage("La cantidad debe ser mayor o igual que 1")
                .withFieldName("cantidad");
    }
}
