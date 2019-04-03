package org.pursuit.blastoff.model;

public class Universe {

    private String name;
    private String text;
    private String image;

    public Universe(String name, String text, String image) {
        this.name = name;
        this.text = text;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }
}
