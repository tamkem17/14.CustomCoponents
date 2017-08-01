package com.example.tam.a14customcoponents;

/**
 * Created by tam on 8/1/2017.
 */

public class Rectagle {
    public float sizeWidth;
    public float sizeHeight;

    public Rectagle(){}

    public Rectagle(float sizeWidth, float sizeHeight) {
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
    }

    public float getSizeWidth() {
        return sizeWidth;
    }

    public void setSizeWidth(float sizeWidth) {
        this.sizeWidth = sizeWidth;
    }

    public float getSizeHeight() {
        return sizeHeight;
    }

    public void setSizeHeight(float sizeHeight) {
        this.sizeHeight = sizeHeight;
    }
}
