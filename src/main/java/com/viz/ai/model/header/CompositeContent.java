package com.viz.ai.model.header;

import java.util.ArrayList;
import java.util.List;

public class CompositeContent implements Content {
    private String title, routerLink;

    private List<Content> contents;

    public CompositeContent() {
        this("", "");
    }

    public CompositeContent(String titleOrrouterLink, String argType) {
        if (argType.equalsIgnoreCase("title")) {
            title = titleOrrouterLink;
        } else {
            routerLink = titleOrrouterLink;
        }
        this.contents = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRouterLink() {
        return routerLink;
    }

    public void setRouterLink(String routerLink) {
        this.routerLink = routerLink;
    }

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    @Override
    public void addContent(Content content) {
        this.contents.add(content);
    }
}
