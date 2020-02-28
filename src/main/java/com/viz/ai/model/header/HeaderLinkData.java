package com.viz.ai.model.header;

public class HeaderLinkData {
    private String type;
    private String href;
    private String color;
    private String target;
    private String value;

    public HeaderLinkData() {
    }

    public HeaderLinkData(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public HeaderLinkData(String type, String href, String color, String target, String value) {
        this.type = type;
        this.href = href;
        this.color = color;
        this.target = target;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "HeaderLinkData{" +
                "type='" + type + '\'' +
                ", href='" + href + '\'' +
                ", color='" + color + '\'' +
                ", target='" + target + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
