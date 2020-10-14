package com.example.ambienteconfinato.model;

public class Model {
    private int imageId;
    private String Title;
    private String desc;

    public Model(int imageId, String title, String desc) {
        this.imageId = imageId;
        Title = title;
        this.desc = desc;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return Title;
    }

    public String getDesc() {
        return desc;
    }

}
