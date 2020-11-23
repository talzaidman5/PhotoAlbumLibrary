package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mylibrary.MainActivityLibrary;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String>a = new ArrayList<>();
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKmJpelOZfVhNJN9Q86jPcFKTogPLytfKEug&usqp=CAU");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKmJpelOZfVhNJN9Q86jPcFKTogPLytfKEug&usqp=CAU");
        a.add("https://www.travelanddestinations.com/wp-content/uploads/2019/10/Ban-Gioc-Detian-Waterfalls-Vietnam-1.jpg");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJFh0J4U_hIVCAelRvwTEDdjZEPibbffFBzA&usqp=CAU");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJFh0J4U_hIVCAelRvwTEDdjZEPibbffFBzA&usqp=CAU");
        a.add("https://q-xx.bstatic.com/xdata/images/hotel/840x460/78809294.jpg?k=cf850d507a9671cf7ff85d598435ea329a28cd4f1b1abc25c1892c91156d36ad&o=");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRJFh0J4U_hIVCAelRvwTEDdjZEPibbffFBzA&usqp=CAU");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ722TbS-z3Yf3Eel0FVfa31C-IH6qBcIuI8w&usqp=CAU");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8IrJPigxJGRwCJhrQ8I_AGrekKouB51RL6A&usqp=CAU");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8IrJPigxJGRwCJhrQ8I_AGrekKouB51RL6A&usqp=CAU");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8IrJPigxJGRwCJhrQ8I_AGrekKouB51RL6A&usqp=CAU");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8IrJPigxJGRwCJhrQ8I_AGrekKouB51RL6A&usqp=CAU");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKmJpelOZfVhNJN9Q86jPcFKTogPLytfKEug&usqp=CAU");
        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKmJpelOZfVhNJN9Q86jPcFKTogPLytfKEug&usqp=CAU");
//        a.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKmJpelOZfVhNJN9Q86jPcFKTogPLytfKEug&usqp=CAU");


        MainActivityLibrary.initImages(MainActivity.this,a);
//      MainActivityLibrary.deleteImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKmJpelOZfVhNJN9Q86jPcFKTogPLytfKEug&usqp=CAU",a);
        MainActivityLibrary.addPhoto("https://www.travelanddestinations.com/wp-content/uploads/2019/10/Ban-Gioc-Detian-Waterfalls-Vietnam-1.jpg",MainActivity.this,a);
      MainActivityLibrary.deletePhoto("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSKmJpelOZfVhNJN9Q86jPcFKTogPLytfKEug&usqp=CAU",a);
        MainActivityLibrary.openAlbum(MainActivity.this,a);

    }
}