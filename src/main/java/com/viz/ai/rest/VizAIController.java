package com.viz.ai.rest;

import com.viz.ai.Controller;
import com.viz.ai.annotation.Header;
import com.viz.ai.model.HeaderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class VizAIController {
    @Autowired Controller controller;

    @Header
    @GetMapping("/")
    @CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200", "https://fierce-brook-75675.herokuapp.com"})
    public HeaderData getData(){
        return controller.getData();
    }
}
