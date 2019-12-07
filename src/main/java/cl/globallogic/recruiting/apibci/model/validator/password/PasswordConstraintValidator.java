package cl.globallogic.recruiting.apibci.model.validator.password;

import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.y.z - 03-12-2019
 * @since 1.y.z - 03-12-2019
 */
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                // Al menos un caracter mayuscula
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                // caracteres en minuscula
                new CharacterRule(EnglishCharacterData.LowerCase, 2),
                // al menos 2 digitos
                new CharacterRule(EnglishCharacterData.Digit, 2),
                // sin espacios en blanco
                new WhitespaceRule()
        ));

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid()) {
            return true;
        }

        List<String> messages = validator.getMessages(result);
        String messageTemplate = messages.stream().collect(Collectors.joining(","));
        context.buildConstraintViolationWithTemplate(messageTemplate)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
