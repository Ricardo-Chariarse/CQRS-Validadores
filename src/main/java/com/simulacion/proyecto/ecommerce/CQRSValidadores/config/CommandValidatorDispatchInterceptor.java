package com.simulacion.proyecto.ecommerce.CQRSValidadores.config;

import br.com.fluentvalidator.context.Error;
import br.com.fluentvalidator.context.ValidationResult;
import com.simulacion.proyecto.ecommerce.CQRSValidadores.exception.CustomErrorException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.springframework.http.HttpStatus;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

@Slf4j
public class CommandValidatorDispatchInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {

    @Override
    @SneakyThrows
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<? extends CommandMessage<?>> messages) {

        return (index, command) -> {
            ValidationResult result = null;
            log.info("Dispatching a command {}.", command);

            try {

                String className = command.getPayload().getClass().getSimpleName();
                String packageName = command.getPayload().getClass().getPackageName();
                String fullNameValidator = String.format("%1$s.%2$s", packageName, className + "Validator");
                Class<?> classValidator = Class.forName(fullNameValidator);
                Object objValidator = classValidator.getDeclaredConstructor().newInstance();

                final br.com.fluentvalidator.Validator<Object> validator = (br.com.fluentvalidator.Validator<Object>) objValidator;

                result = validator.validate(command.getPayload());

            } catch (CustomErrorException e) {
                e.printStackTrace();
            } catch (RuntimeException
                    | ClassNotFoundException
                    | NoSuchMethodException
                    | InvocationTargetException
                    | InstantiationException
                    | IllegalAccessException e) {
                //e.printStackTrace();
            }

            if (result == null || result.isValid()) {
                //R response = next.invoke();
                return command;
            }

            Map<String, String> errors = parseErrors(result);
            throw new CustomErrorException(HttpStatus.BAD_REQUEST, "Una o mas fallas de validacion han ocurrido", errors);

        };
    }

    private Map<String, String> parseErrors(ValidationResult result) {
        Map<String, String> errors = new HashMap<String, String>();
        for (Error detail : result.getErrors()) {
            errors.put(detail.getField(), detail.getMessage());
        }
        return errors;
    }
}