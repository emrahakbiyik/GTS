package com.emrahakbiyik.gts.Activities;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.emrahakbiyik.gts.R;

public class AracEkle extends AppCompatActivity {
    boolean isImageFitToScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_ekle);


        LinearLayout layout = (LinearLayout) findViewById(R.id.linear_photo_layout);
        for (int i = 0; i < 10; i++) {
            final ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(6, 2, 6, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.car));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            layout.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    if(isImageFitToScreen) {
                        isImageFitToScreen=false;
                        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        imageView.setAdjustViewBounds(true);

                    }else{
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                        isImageFitToScreen=true;
                        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                        imageView.setPadding(6, 2, 6, 2);
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                }
            });
        }

    }
}
