package com.aj.springbootmysql.controller;

import com.aj.springbootmysql.domain.PingRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/")
public class PingController {

    private static final Logger logger = LoggerFactory.getLogger(PingController.class);

    @GetMapping("ping")
    public ResponseEntity<Map<String, String>> ping() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "pong");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //GET API with path variable
    @GetMapping("ping/{message}")
    public ResponseEntity<Map<String, String>> pingPath(@PathVariable String message) {
        Map<String, String> response = new HashMap<>();
        response.put(message, "pong");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("ping")
    public ResponseEntity<Map<String, String>> send(@RequestBody PingRequest pingRequest) {
        logger.info("Request received is: {}" , pingRequest );
        Map<String, String> response = new HashMap<>();
        response.put("message", "");
        if("ping".equalsIgnoreCase(pingRequest.getInput())) {
            response.put("message", "pong");
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}