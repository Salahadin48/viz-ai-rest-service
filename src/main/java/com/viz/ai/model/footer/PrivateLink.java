package com.viz.ai.model.footer;

public class PrivateLink {

    private String name;
    private String url;

    public PrivateLink() {
    }

    public PrivateLink(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
