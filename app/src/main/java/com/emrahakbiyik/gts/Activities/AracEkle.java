package com.emrahakbiyik.gts.Activities;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.emrahakbiyik.gts.Models.Arac;
import com.emrahakbiyik.gts.Models.SharedPref;
import com.emrahakbiyik.gts.R;

import java.math.BigDecimal;

public class AracEkle extends AppCompatActivity {
    boolean isImageFitToScreen;

    EditText etRumuz, etMarka, etModel, etPlaka, etTramer, etAlisFiyati, etSatisFiyati, etFaturaAlisFiyati, etFaturaSatisFiyati;
    Arac mArac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_ekle);

        mArac = new Arac();

        etRumuz = (EditText) findViewById(R.id.rumuz);
        etMarka = (EditText) findViewById(R.id.marka);
        etModel = (EditText) findViewById(R.id.model);
        etPlaka = (EditText) findViewById(R.id.plaka);
        etTramer = (EditText) findViewById(R.id.tramer);
        etAlisFiyati = (EditText) findViewById(R.id.alisfiyati);
        etSatisFiyati = (EditText) findViewById(R.id.satisfiyati);
        etFaturaAlisFiyati = (EditText) findViewById(R.id.faturaalisfiyati);
        etFaturaSatisFiyati = (EditText) findViewById(R.id.faturasatisfiyati);

        LinearLayout layout = (LinearLayout) findViewById(R.id.linear_photo_layout);
        for (int i = 0; i < 3; i++) {
            final ImageView imageView = new ImageView(this);
            imageView.setId(i);
            imageView.setPadding(6, 2, 6, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), R.drawable.car));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            layout.addView(imageView);
            imageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (isImageFitToScreen) {
                        isImageFitToScreen = false;
                        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                        imageView.setAdjustViewBounds(true);

                    } else {
                        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                        isImageFitToScreen = true;
                        imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                        imageView.setPadding(6, 2, 6, 2);
                        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    }
                }
            });
        }




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent mIntent) {
        if (resultCode == RESULT_OK && requestCode == 1) { //Req Code Boya durumu=1
            if (mIntent.hasExtra("BoyaDurumu")) {
                mArac.setBoyaDurumu(mIntent.getExtras().getIntArray("BoyaDurumu"));
            } else {
                Toast.makeText(getApplicationContext(), "Boya Durumu kaydedilemedi", Toast.LENGTH_SHORT).show();
            }
        } //else if (resultCode==RESULT_OK && )

    }
    public void doWork (View v){
        if ((v.getId()==R.id.btnBoyaDurumu)){  //REQ CODE:1
            Intent mIntent = new Intent(this, BoyaDurumu.class);
            startActivityForResult(mIntent,1);
        } else if (v.getId()==R.id.btnKaydet){ //TODO: Alanlar boş olunca izin verilmeyecek.

            mArac.setAracID("Arac");
            mArac.setMarka(etMarka.getText().toString());
            mArac.setModel(etModel.getText().toString());
            mArac.setRumuz(etRumuz.getText().toString());
            mArac.setPlaka(etPlaka.getText().toString());
            mArac.setTramer(etTramer.getText().toString());
            mArac.setMarka(etMarka.getText().toString());
            try {
                BigDecimal mAlisfiyati = new BigDecimal(etAlisFiyati.getText().toString());
                mArac.setAlisFiyati(mAlisfiyati);
                BigDecimal mSatisfiyati = new BigDecimal(etSatisFiyati.getText().toString());
                mArac.setSatisFiyati(mSatisfiyati);
                BigDecimal mFaturalisfiyati = new BigDecimal(etFaturaAlisFiyati.getText().toString());
                mArac.setFaturaAlisFiyati(mFaturalisfiyati);
                BigDecimal mFaturaSatisfiyati = new BigDecimal(etFaturaSatisFiyati.getText().toString());
                mArac.setFaturaSatisFiyati(mFaturaSatisfiyati);
            } catch (Exception e){
                Toast.makeText(getApplicationContext(),"e",Toast.LENGTH_SHORT).show();
            }
            try {
                SharedPref.getInstance(getApplicationContext()).addArac(mArac);
                Toast.makeText(getApplicationContext(),"Arac Eklendi",Toast.LENGTH_SHORT).show();
            }catch (Exception e) {
                Toast.makeText(getApplicationContext(),"e",Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    }
}
