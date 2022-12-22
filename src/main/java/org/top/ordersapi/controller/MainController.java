package org.top.ordersapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//главный контроллер
@RestController
public class MainController {
    @GetMapping("/ping")
    public String toString(){
        return "pong";
    }
}
