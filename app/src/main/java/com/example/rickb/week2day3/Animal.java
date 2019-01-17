package com.example.rickb.week2day3;


public class Animal {
    private String Type;
    private String Name;
    private String sound;
    private String image;

    public Animal () {
    }

    public Animal(String type, String name, String sound, String image) {

        Type = type;
        Name = name;
        this.sound = sound;
        this.image = image;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
