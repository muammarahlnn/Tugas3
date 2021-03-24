package com.ardnn.tugas3;

public class ProgrammingLanguage {
    private String name, creator, desc;
    int image;

    public ProgrammingLanguage(){}

    public ProgrammingLanguage(String name, String creator, String desc, int image) {
        this.name = name;
        this.creator = creator;
        this.desc = desc;
        this.image = image;
    }

    public String getName() {
        return this.name;
    }

    public String getCreator() {
        return this.creator;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getImage() {
        return this.image;
    }



}
