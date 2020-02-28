package com.viz.ai;

import com.viz.ai.annotation.Footer;
import com.viz.ai.model.footer.FooterData;
import com.viz.ai.model.footer.PrivateLink;
import com.viz.ai.model.footer.Social;
import com.viz.ai.model.header.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @GetMapping("/header")
    public HeaderData getHeader() {

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

        ConcreteContent ccExample1 = new ConcreteContent("Landing", "landing Page", "/landing");
        ConcreteContent ccExample2 = new ConcreteContent("Profile", "Profile Page", "user-profile");
        ConcreteContent ccExample3 = new ConcreteContent("Log In", "Login Page", "login");
        ConcreteContent ccExample4 = new ConcreteContent("Register", "Registration Page", "register");
        List<Content> contentsx1 = new ArrayList<>();
        contentsx1.add(ccExample1);
        contentsx1.add(ccExample2);
        contentsx1.add(ccExample3);
        contentsx1.add(ccExample4);

        CompositeContent compositeContentx = new CompositeContent("Example", "title");
        compositeContentx.setContents(contentsx1);

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

        Content mainContents = new CompositeContent();
        mainContents.addContent(compositeContent1);
        mainContents.addContent(compositeContent2);
        mainContents.addContent(compositeContentx);

        return new HeaderData(logo, mainContents);
    }

    @GetMapping("/footer")
    public FooterData getFooter() {
        PrivateLink visualAi = new PrivateLink("Visual AI","https://www.viz-ai.com/");
        PrivateLink aboutUs = new PrivateLink("About Us","https://www.viz-ai.com/");
        PrivateLink blog = new PrivateLink("Blog","https://www.viz-ai.com/");
        PrivateLink mitLicense = new PrivateLink("MIT License","https://www.viz-ai.com/");
        List<PrivateLink> privateLinksList = new ArrayList<>();
        privateLinksList.add(visualAi);
        privateLinksList.add(aboutUs);
        privateLinksList.add(blog);
        privateLinksList.add(mitLicense);

        Social socialT = new Social("Twitter", "https://www.twitter.com/");
        Social socialF = new Social("Facebook", "https://www.facebook.com/");
        Social socialD = new Social("Dribbble", "https://www.dribbble.com/");
        Social socialG = new Social("Github", "https://www.github.com/");
        List<Social> socialList = new ArrayList<>();
        socialList.add(socialT);
        socialList.add(socialF);
        socialList.add(socialD);
        socialList.add(socialG);

        FooterData footer = new FooterData("Thank you for supporting us!", socialList, privateLinksList);
        return footer;
    }
}
