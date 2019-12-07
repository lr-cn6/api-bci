package cl.globallogic.recruiting.apibci.api.controller.validator;

import cl.globallogic.recruiting.apibci.model.User;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.0.0 - 03-12-2019
 * @since 1.0.0 - 03-12-2019
 */
public class UserValidator extends AbstractValidator<User> {


    public static UserValidator build() {
        return new UserValidator();
    }

    @Override
    public List<String> validate(User user) {
        List<String> validations = new ArrayList<>();

        Set<ConstraintViolation<User>> violations = buildValidator().validate(user);
        for (ConstraintViolation<User> violation : violations) {
            validations.add(String.format("%s : %s",violation.getPropertyPath().toString(),violation.getMessage()));
        }

        return validations;
    }
}
