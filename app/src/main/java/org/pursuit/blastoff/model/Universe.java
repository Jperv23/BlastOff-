package org.pursuit.blastoff.model;

public class Universe {

    private String name;
    private String fact1;
    private String text;
    private String image;

    public Universe(String name, String fact1, String text, String image) {
        this.name = name;
        this.fact1 = fact1;
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

    public String getFact1() {
        return fact1;
    }
}
