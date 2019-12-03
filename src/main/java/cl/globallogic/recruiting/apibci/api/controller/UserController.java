package cl.globallogic.recruiting.apibci.api.controller;

import cl.globallogic.recruiting.apibci.api.controller.validator.UserValidator;
import cl.globallogic.recruiting.apibci.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Luis Riveros - luis.riveros_ex@scotiabank.cl
 * @version 1.0.0 - 02-12-2019
 * @since 1.0.0 - 02-12-2019
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends AbstractController {

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addPeople(@RequestBody @Valid User people, Errors errors) {

        if (errors.hasErrors()) {
            return errorRequest(UserValidator.build().validate(people));
        }

        return new ResponseEntity<>(true, HttpStatus.CREATED);
    }
}
