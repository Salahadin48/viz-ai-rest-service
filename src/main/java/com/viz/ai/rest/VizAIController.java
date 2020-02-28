package com.viz.ai.rest;

import com.viz.ai.Controller;
import com.viz.ai.annotation.Footer;
import com.viz.ai.annotation.Header;
import com.viz.ai.model.footer.FooterData;
import com.viz.ai.model.header.HeaderData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VizAIController {
    @Autowired
    Controller controller;

    @Header
    @GetMapping("/get/header")
    @CrossOrigin(origins = {"http://localhost:4200", "https://enigmatic-springs-53845.herokuapp.com", "http://enigmatic-springs-53845.herokuapp.com",
            "http://www.viz-ai.com", "https://www.viz-ai.com", "https://viz-ai.com", "http://viz-ai.com"})
    public HeaderData getHeader() {
        return controller.getHeader();
    }

    @Footer
    @GetMapping("/get/footer")
    @CrossOrigin(origins = {"http://localhost:4200", "https://enigmatic-springs-53845.herokuapp.com", "http://enigmatic-springs-53845.herokuapp.com",
            "http://www.viz-ai.com", "https://www.viz-ai.com", "https://viz-ai.com", "http://viz-ai.com"})
    public FooterData getFooter() {
        return controller.getFooter();
    }
}
