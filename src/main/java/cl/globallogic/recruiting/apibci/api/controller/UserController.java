package cl.globallogic.recruiting.apibci.api.controller;

import cl.globallogic.recruiting.apibci.api.controller.validator.UserValidator;
import cl.globallogic.recruiting.apibci.exception.ApiBciException;
import cl.globallogic.recruiting.apibci.model.User;
import cl.globallogic.recruiting.apibci.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.0.0 - 02-12-2019
 * @since 1.0.0 - 02-12-2019
 */
@RestController
@RequestMapping(value = "/user")
public class UserController extends AbstractController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> addPeople(@RequestBody @Valid User people, Errors errors) throws ApiBciException {

        if (errors.hasErrors()) {
            return errorRequest(UserValidator.build().validate(people));
        }

        return new ResponseEntity<>(userService.addUser(people), HttpStatus.CREATED);
    }
}
