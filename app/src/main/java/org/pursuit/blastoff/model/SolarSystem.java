package org.pursuit.blastoff.model;

public class SolarSystem {

    private String name;
    private String fact1;
    private String fact2;
    private String text;
    private String image;

    public SolarSystem(String name, String fact1, String fact2, String text, String image) {
        this.name = name;
        this.fact1 = fact1;
        this.fact2 = fact2;
        this.text = text;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getFact1() {
        return fact1;
    }

    public String getFact2() {
        return fact2;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }
}
