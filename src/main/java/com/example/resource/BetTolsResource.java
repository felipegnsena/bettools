package com.example.resource;

import com.example.model.dto.CombinacaoLinear;
import com.example.model.dto.VariableMartingale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api")
@RestController
@Validated
public class BetTolsResource {

    @PostMapping("/losemaximum")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> variableMartingaleLoseMaximum(@RequestBody VariableMartingale request) {
        return new ResponseEntity<>(String.format("%s brl", request.loseMaximum()), HttpStatus.OK);
    }

    @PostMapping("/combinations")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> combinations(@RequestBody CombinacaoLinear request) {
        return new ResponseEntity<>(String.format("COMBINATIONS : %s", request.getcombinations()), HttpStatus.OK);
    }

    @PostMapping("/numberofcombinations")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> numberOfCombinations(@RequestBody CombinacaoLinear request) {
        return new ResponseEntity<>(String.format("%s", request.getNumberOfcombinations()), HttpStatus.OK);
    }

}
