package com.viz.ai.rest;

import com.viz.ai.Controller;
import com.viz.ai.annotation.Header;
import com.viz.ai.model.HeaderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VizAIController {
    @Autowired
    Controller controller;

    @Header
    @GetMapping("/")
    @CrossOrigin(origins = {"http://localhost:4200", "https://enigmatic-springs-53845.herokuapp.com", "http://enigmatic-springs-53845.herokuapp.com",
            "http://www.viz-ai.com", "https://www.viz-ai.com", "https://viz-ai.com", "http://viz-ai.com"})
    public HeaderData getData() {
        return controller.getData();
    }
}
