package com.example.mylibrary;

import android.widget.ImageView;



public class Image {
    private ImageView imageView;
    private String URL;

    public Image(ImageView imageView, String URL) {
        this.imageView = imageView;
        this.URL = URL;
    }





    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
