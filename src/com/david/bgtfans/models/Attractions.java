package com.david.bgtfans.models;

/**
 * Created by david.hodge on 2/6/14.
 */
public class Attractions {

    private String name;
    private int image;

    public Attractions(String name, int image){
        this.name = name;
        this.image = image;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setImage(int image){
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }
}
