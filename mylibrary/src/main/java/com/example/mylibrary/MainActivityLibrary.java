package com.example.mylibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivityLibrary {
    public static ImageView activity_main_IMG_1,activity_main_IMG_2,activity_main_IMG_3,activity_main_IMG_4,activity_main_IMG_5
            ,activity_main_IMG_6,activity_main_IMG_7,activity_main_IMG_8,activity_main_IMG_9,activity_main_IMG_10,activity_main_IMG_11,activity_main_IMG_12,
                activity_main_IMG_13,activity_main_IMG_14,activity_main_IMG_15;
    public static TextView title;
    public static View view;
    public static Button activity_main_BTN_back;
    public static ArrayList<Image> arrayOfImages;
    public static AlertDialog dialog= null;
    public static final int NUM_OF_IMAGES=15;
    public static ArrayList<ImageView>allImageView;

    public static void initImages(Activity activity,ArrayList<String>allImages)  {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        final LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.activity_main1, null);
        builder.setView(view);
        dialog = builder.create();
        dialog.show();
        title = view.findViewById(R.id.title);
        arrayOfImages = new ArrayList<>();
        init(allImages);
        activity_main_BTN_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

//    openAlbum(activity,allImages);
       openD(allImages.size());
    }


    public static void openD(int numberOfImage ) {

           final Handler handler = new Handler();
        final int[] count = {0};

           final Runnable runnable = new Runnable() {
               public void run() {
                   count[0]++;
                   MySignal.animation(arrayOfImages.get(count[0]).getImageView());
                   if (count[0] < numberOfImage) {
                       handler.postDelayed(this, 700);
                   }
               }
           };


    }
    public static void addImage(String urlToAdd,Activity activity,ArrayList<String>arrayList){
            if (urlToAdd.isEmpty()) {
            Toast.makeText( activity,"Error", Toast.LENGTH_SHORT).show();
            } else {
                if (arrayList.size()<allImageView.size()) {
                    arrayList.add(urlToAdd);
                    init(arrayList);
                }
                else{
                    Toast.makeText( activity,"Delete images before add new", Toast.LENGTH_SHORT).show();
                }
        }
    }
    public static void openAlbum(Activity activity, ArrayList<String> allImages){
        resrsh();
        for (int i = 0; i < arrayOfImages.size(); i++) {
            String url = allImages.get(i);
            if (url.isEmpty()) {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
            } else {
                if(arrayOfImages.get(i).getURL()!="") {
                    LoadImage loadImage = new LoadImage(arrayOfImages.get(i).getImageView());
                        arrayOfImages.get(i).getImageView().setBackgroundDrawable(Drawable.createFromPath(url));
                        loadImage.execute(url);
                }
            }
        }
    }

    private static void resrsh() {
        for (int i = 0; i < arrayOfImages.size(); i++)
            arrayOfImages.get(i).getImageView().setBackgroundResource(R.drawable.rectangle);

    }

    public static void deleteImage(String urlToDelete,ArrayList<String>arrayListURL){
        for (Image image:arrayOfImages) {
            if(image.getURL().equals(urlToDelete)) {
                arrayListURL.remove(urlToDelete);
                init(arrayListURL);
                return;
            }
        }
    }

    private static void removeImage(ArrayList<Image> arrayOfImages, Image imageToDelete) {
        for (int i = 0; i < arrayOfImages.size(); i++) {
            if(arrayOfImages.get(i).equals(imageToDelete)) {
                for (int j = i; j < arrayOfImages.size()-1; j++)
                    arrayOfImages.get(j).setImageView(arrayOfImages.get(j + 1).getImageView());
                return;
            }
        }
    }

    private static void init(ArrayList<String>arrayList) {
        findView(view);
        if(allImageView!=null) {
            allImageView.clear();
            arrayOfImages.clear();
        }
        allImageView = new ArrayList<ImageView>();
        allImageView.add(activity_main_IMG_1);
        allImageView.add(activity_main_IMG_2);
        allImageView.add(activity_main_IMG_3);
        allImageView.add(activity_main_IMG_4);
        allImageView.add(activity_main_IMG_5);
        allImageView.add(activity_main_IMG_6);
        allImageView.add(activity_main_IMG_7);
        allImageView.add(activity_main_IMG_8);
        allImageView.add(activity_main_IMG_9);
        allImageView.add(activity_main_IMG_10);
        allImageView.add(activity_main_IMG_11);
        allImageView.add(activity_main_IMG_12);
        allImageView.add(activity_main_IMG_13);
        allImageView.add(activity_main_IMG_14);
        allImageView.add(activity_main_IMG_15);

        for (int j = 0; j < arrayList.size(); j++) {
                arrayOfImages.add(new Image(allImageView.get(j), arrayList.get(j)));
        }
    }

    private static void findView(View view) {
        activity_main_IMG_1 = view.findViewById(R.id.activity_main_IMG_1);
        activity_main_IMG_2 = view.findViewById(R.id.activity_main_IMG_2);
        activity_main_IMG_3 = view.findViewById(R.id.activity_main_IMG_3);
        activity_main_IMG_4 = view.findViewById(R.id.activity_main_IMG_4);
        activity_main_IMG_5 = view.findViewById(R.id.activity_main_IMG_5);
        activity_main_IMG_6 = view.findViewById(R.id.activity_main_IMG_6);
        activity_main_IMG_7 = view.findViewById(R.id.activity_main_IMG_7);
        activity_main_IMG_8 = view.findViewById(R.id.activity_main_IMG_8);
        activity_main_IMG_9 = view.findViewById(R.id.activity_main_IMG_9);
        activity_main_IMG_10 = view.findViewById(R.id.activity_main_IMG_10);
        activity_main_IMG_11 = view.findViewById(R.id.activity_main_IMG_11);
        activity_main_IMG_12 = view.findViewById(R.id.activity_main_IMG_12);
        activity_main_IMG_13 = view.findViewById(R.id.activity_main_IMG_13);
        activity_main_IMG_14 = view.findViewById(R.id.activity_main_IMG_14);
        activity_main_IMG_15 = view.findViewById(R.id.activity_main_IMG_15);
        activity_main_BTN_back= view.findViewById(R.id.activity_main_BTN_back);
    }

}
