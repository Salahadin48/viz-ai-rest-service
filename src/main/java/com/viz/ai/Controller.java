package com.viz.ai;

import com.viz.ai.model.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @GetMapping("/data")
    public HeaderData getData() {
//        HeaderLinkData headerLinkDataA = new HeaderLinkData("Button", "Contacts");
//        HeaderLinkData headerLinkDataB = new HeaderLinkData("ToolTip", "Facebook");
//        HeaderLinkData headerLinkDataC = new HeaderLinkData("ToolTip", "Twitter");
//        HeaderLinkData headerLinkDataD = new HeaderLinkData("Input", "Instagram");
//
//        List<HeaderLinkData> linkDataList = new ArrayList<>();
//        linkDataList.add(headerLinkDataA);
//        linkDataList.add(headerLinkDataB);
//        linkDataList.add(headerLinkDataC);
//        linkDataList.add(headerLinkDataD);

        Logo logo = new Logo("/home", "./assets/img/brand/blue.png");


        ConcreteContent cc1 = new ConcreteContent("Getting started", "Learn how to use Argon\n" +
                " compiling Scss, change brand colors and more.", "/getting_started");
        ConcreteContent cc2 = new ConcreteContent("Foundation", "Learn more about colors,\n" +
                " typography, icons and the grid system we used for Argon.", "/foundation");
        ConcreteContent cc3 = new ConcreteContent("Components", "Browse our 50 beautiful\n" +
                " handcrafted components offered in the Free version.", "/components");
        List<Content> contents1 = new ArrayList<>();
        contents1.add(cc1);
        contents1.add(cc2);
        contents1.add(cc3);
        CompositeContent compositeContent1 = new CompositeContent("Components", "title");
        compositeContent1.setContents(contents1);

        ConcreteContent cc12 = new ConcreteContent("Facebook", null, "https://www.facebook.com");
        ConcreteContent cc22 = new ConcreteContent("Instagram", null, "https://www.instagram.com");
        ConcreteContent cc32 = new ConcreteContent("Twitter", null, "https://www.twitter.com");
        ConcreteContent cc34 = new ConcreteContent("Github", null, "https://www.github.com");

        List<Content> contents2 = new ArrayList<>();
        contents2.add(cc12);
        contents2.add(cc22);
        contents2.add(cc32);
        contents2.add(cc34);

        CompositeContent compositeContent2 = new CompositeContent("/components", "links");
        compositeContent2.setContents(contents2);

        List<Content> mainContents = new ArrayList<>();
        mainContents.add(compositeContent1);
        mainContents.add(compositeContent2);

        return new HeaderData(logo, mainContents);
    }
}
