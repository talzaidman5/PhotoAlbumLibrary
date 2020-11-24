package com.example.mylibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityLibrary {
    public static View view;
    public static Button activity_main_BTN_back;
    public static ArrayList<Image> arrayOfImages;
    public static AlertDialog dialog= null;
    public static LinearLayout linearLayout1;
    public static LinearLayout linearLayout;

    public static void initImages(Activity activity) {

        final LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.activity_main1, null);
        linearLayout1 = view.findViewById(R.id.lin);
        activity_main_BTN_back = view.findViewById(R.id.activity_main_BTN_back);
        linearLayout1.setGravity(Gravity.CENTER);
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

    public static void addPhoto(String urlToAdd, ArrayList<String>arrayList){
        arrayList.add(urlToAdd);
    }
    public static void openAlbum(Activity activity, ArrayList<String> allImages) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.setGravity(Gravity.CENTER);

        int count = 0;
        for (int i = 0; i < allImages.size(); i++, count++) {
            String url = allImages.get(i);
            if (count % 3 == 0) {
                linearLayout = new LinearLayout(activity);
                linearLayout1.addView(linearLayout);
                linearLayout.setGravity(Gravity.RIGHT);
                linearLayout1.setGravity(Gravity.RIGHT);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.setPadding(3, 3, 3, 3);
            }
            if (url.isEmpty()) {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
            } else {
                if (allImages.get(i) != "") {
                    ImageView image = new ImageView(activity);
                    LoadImage loadImage = new LoadImage(image);
                    image.setBackgroundDrawable(Drawable.createFromPath(url));
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(270, 270);
                    image.setLayoutParams(layoutParams);
                    linearLayout.addView(image);
                    loadImage.execute(url);
                }
            }
        }
        activity_main_BTN_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        builder.setView(view);
        dialog = builder.create();
        dialog.show();
        openD(allImages.size());
    }

    public static void deletePhoto(String urlToDelete, ArrayList<String>arrayListURL){
        for (String url:arrayListURL) {
            if(url.equals(urlToDelete)) {
                arrayListURL.remove(urlToDelete);
                return;
            }
        }
    }
}
