package com.viz.ai.model.footer;

import java.util.ArrayList;
import java.util.List;

public class FooterData {
    private String message;
    private List<Social> socialList;
    private List<PrivateLink> privateLinks;

    public FooterData(){}

    public FooterData(String message, List<Social> socialList, List<PrivateLink> privateLinks) {
        this.message = message;
        this.socialList = socialList;
        this.privateLinks = privateLinks;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Social> getSocialList() {
        return socialList;
    }

    public void setSocialList(List<Social> socialList) {
        this.socialList = socialList;
    }

    public List<PrivateLink> getPrivateLinks() {
        return privateLinks;
    }

    public void setPrivateLinks(List<PrivateLink> privateLinks) {
        this.privateLinks = privateLinks;
    }
}
