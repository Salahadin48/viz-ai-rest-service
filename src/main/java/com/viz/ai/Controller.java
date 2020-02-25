package com.viz.ai;

import com.viz.ai.model.HeaderData;
import com.viz.ai.model.HeaderLinkData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @GetMapping("/data")
    public HeaderData getData() {
        HeaderLinkData headerLinkDataA = new HeaderLinkData("Button", "Contacts");
        HeaderLinkData headerLinkDataB = new HeaderLinkData("ToolTip", "Facebook");
        HeaderLinkData headerLinkDataC = new HeaderLinkData("ToolTip", "Twitter");
        HeaderLinkData headerLinkDataD = new HeaderLinkData("Input", "Instagram");

        List<HeaderLinkData> linkDataList = List.of(headerLinkDataA, headerLinkDataB, headerLinkDataC, headerLinkDataD);

        return new HeaderData("Visual AI", linkDataList);
    }
}
