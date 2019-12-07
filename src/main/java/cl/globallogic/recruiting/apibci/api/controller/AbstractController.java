package cl.globallogic.recruiting.apibci.api.controller;

import cl.globallogic.recruiting.apibci.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luis Riveros - lc.riverosd@gmail.com
 * @version 1.y.z - 03-12-2019
 * @since 1.y.z - 03-12-2019
 */
public abstract class AbstractController {

    public ResponseEntity<Object> errorRequest(List<String> errors) {
        List<Response> response = new ArrayList<>();
        for (String s : errors) {
            response.add(new Response(s));
        }
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
