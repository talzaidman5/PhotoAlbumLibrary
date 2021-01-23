package com.example.mylibrary;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MainActivityLibrary {
    public static View view;
    public static Button activity_main_BTN_back;
    public static ArrayList<Image> arrayOfImages;
    public static AlertDialog dialog = null;
    public static LinearLayout linearLayout1;
    public static LinearLayout linearprogressBar;
    public static ProgressBar progressBar;
    public static LinearLayout linearLayout;
    public static TextView title;
    public static int[] allChoosen;
    public static int numberOfImageInRow = 3, WIDTH = 270, LENGTH = 270;
    public static ImageView currentChooserImage;

    public static void initImages(Activity activity) {

        final LayoutInflater inflater = activity.getLayoutInflater();
        view = inflater.inflate(R.layout.activity_main1, null);
        linearLayout1 = view.findViewById(R.id.lin);
        activity_main_BTN_back = view.findViewById(R.id.activity_main_BTN_back);
        title = view.findViewById(R.id.title);
        linearLayout1.setGravity(Gravity.CENTER);
    }

    public static void openD(int numberOfImage) {

        final Handler handler = new Handler();
        final int[] count = {0};

        final Runnable runnable = new Runnable() {
            public void run() {
                count[0]++;
                MySignal.animation(arrayOfImages.get(count[0]).getImageView());
                if (count[0] < numberOfImage)
                    handler.postDelayed(this, 700);
            }
        };
    }

    public static void changeTitle(String titleToChange) {
        title.setText(titleToChange);
    }

    public static void changeButtonText(String textButton) {
        activity_main_BTN_back.setText(textButton);
    }

    public static void changeButtonColor(int colorButton) {
        activity_main_BTN_back.setBackgroundColor(colorButton);
    }

    public static void numberOfImageInRow(int number, int length, int width) {
        numberOfImageInRow = number;
        LENGTH = length;
        WIDTH = width;
    }

    public static void addPhoto(String urlToAdd, ArrayList<String> arrayList) {
        arrayList.add(urlToAdd);
    }

    public interface OnImageClickedCallBack {
        void onImageClicked(ImageView image, String imageUrl);
    }

    public static void openAlbum(Activity activity, ArrayList<String> allImages, @Nullable OnImageClickedCallBack callBack) {
        allChoosen = new int[allImages.size()];
        final AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.setGravity(Gravity.CENTER);

        int count = 0;
        for (int i = 0; i < allImages.size(); i++, count++) {
            String url = allImages.get(i);
            if (count % numberOfImageInRow == 0) {
                linearLayout = new LinearLayout(activity);
                linearLayout1.addView(linearLayout);
                linearLayout.setGravity(Gravity.CENTER);
                linearLayout1.setGravity(Gravity.CENTER);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.setPadding(3, 1, 3, 3);
            }
            if (url.isEmpty()) {
                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
            } else {
                if (allImages.get(i) != "") {
                    ImageView image = new ImageView(activity);
                    LoadImage loadImage = new LoadImage(image);
                    image.setBackgroundDrawable(Drawable.createFromPath(url));
                    TableRow.LayoutParams layoutParams = new TableRow.LayoutParams(WIDTH, LENGTH);
                    image.setLayoutParams(layoutParams);
                    int finalI = i;
                    image.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            allChoosen[finalI] = 1;
                            currentChooserImage = image;
                            Toast.makeText(activity, "Image Chosen", Toast.LENGTH_SHORT).show();
                            if (callBack != null)
                                callBack.onImageClicked(image, url);
                        }
                    });
                    linearLayout.addView(image);
                    image.setPadding(8, 8, 8, 8);
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

    public static void deletePhoto(String urlToDelete, ArrayList<String> arrayListURL) {
        for (String url : arrayListURL) {
            if (url.equals(urlToDelete)) {
                arrayListURL.remove(urlToDelete);
                return;
            }
        }
    }
}
