package com.viz.ai.model.header;

public class Logo {
    private String href;
    private String imageUrl;

    public Logo() {
    }

    public Logo(String href, String imageUrl) {
        this.href = href;
        this.imageUrl = imageUrl;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
