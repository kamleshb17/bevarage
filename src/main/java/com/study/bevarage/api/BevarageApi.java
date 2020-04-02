package com.study.bevarage.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/")
public interface BevarageApi {

    @RequestMapping(value = "orderprice", method = RequestMethod.GET)
    public ResponseEntity getTotalOrderPrice(@RequestBody String[] orders);
}
