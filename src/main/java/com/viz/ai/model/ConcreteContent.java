package com.viz.ai.model;

public class ConcreteContent implements Content {
    private String title;
    private String subTitle;
    private String href;

    public ConcreteContent() {
    }

    public ConcreteContent(String title, String subTitle, String href) {
        this.title = title;
        this.subTitle = subTitle;
        this.href = href;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Override
    public void addContent(Content content) {

    }
}
