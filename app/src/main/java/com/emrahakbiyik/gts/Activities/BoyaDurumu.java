package com.emrahakbiyik.gts.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.emrahakbiyik.gts.R;

public class BoyaDurumu extends AppCompatActivity {

    int AracId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boya_durumu);
        AracId=getIntent().getIntExtra("AracId",0);

    }
}
