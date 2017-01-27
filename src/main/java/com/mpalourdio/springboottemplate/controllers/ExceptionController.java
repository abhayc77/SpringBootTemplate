package com.mpalourdio.springboottemplate.controllers;

import com.mpalourdio.springboottemplate.exception.CustomException;
import com.mpalourdio.springboottemplate.exception.ResponseObject;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    @GetMapping(value = "nok", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String throwException() throws CustomException {
        if (1 == 1) {
            throw new CustomException("bad");
        }

        return "all is ok if here";
    }

    @GetMapping(value = "ok", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseObject ok() throws CustomException {

        final ResponseObject responseObject = new ResponseObject();
        responseObject.property = "toto";

        return responseObject;
    }


    private ResponseEntity callException(final String param) {
        final RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<ResponseObject> exchange;

        final HttpHeaders httpHeaders = new HttpHeaders();
        final HttpEntity httpEntity = new HttpEntity<>(httpHeaders);
        try {
            exchange = restTemplate.exchange(
                    "http://localhost:8080/exception/" + param,
                    HttpMethod.GET,
                    httpEntity,
                    ResponseObject.class
            );
        } catch (final HttpClientErrorException e) {
            return ResponseEntity.status(e.getRawStatusCode()).body(e.getResponseBodyAsString());
        }

        return exchange;
    }

    @GetMapping(value = "/callok")
    public ResponseEntity getCallOk() {
        final ResponseEntity call = callException("ok");

        if (call.getStatusCode() != HttpStatus.OK) {
            final ResponseObject responseObject = (ResponseObject) call.getBody();
            //do things here
        }

        return call;
    }

    @GetMapping(value = "/callnok")
    public ResponseEntity getCallNok() {
        return callException("nok");
    }
}
