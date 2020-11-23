package com.example.mylibrary;

import android.animation.Animator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

public class MySignal {

    public static void animation(ImageView image){
        image.animate().setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                image.setScaleX(0);
                image.setScaleY(0);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                image.setScaleX(1);
                image.setScaleY(1);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        })
                .setDuration(1000).start();
    }

}
