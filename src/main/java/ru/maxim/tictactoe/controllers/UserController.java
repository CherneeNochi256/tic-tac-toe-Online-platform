package ru.maxim.tictactoe.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("http://localhost:8081/")
@RequestMapping("users")
@RestController
public class UserController {
    @GetMapping("1")
    public String test(){
        return "test";
    }
}
