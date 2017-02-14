package com.szatmary.peter.controller;

import com.szatmary.peter.db.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.Map;

@Controller
public class HelloController {

    @Value("${application.message}")
    private String message;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        model.put("persons", personRepository.findAll());
        return "hello";
    }
}
