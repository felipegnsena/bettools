package com.example.resource;

import com.example.model.dto.VariableMartingale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@Validated
public class BetTolsResource {

    @PostMapping("/lose")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> variableMartingaleLoseMaximum(@RequestBody VariableMartingale request) {

        return new ResponseEntity<>(String.format("%s brl", request.loseMaximum()), HttpStatus.OK);
    }


}
