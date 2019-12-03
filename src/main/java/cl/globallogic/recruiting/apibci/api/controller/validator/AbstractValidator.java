package cl.globallogic.recruiting.apibci.api.controller.validator;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;

/**
 * @author Luis Riveros - luis.riveros_ex@scotiabank.cl
 * @version 1.0.0 - 03-12-2019
 * @since 1.0.0 - 03-12-2019
 */
public abstract class AbstractValidator<R> {

    abstract List<String> validate(R r);

    Validator buildValidator(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator;
    }
}
