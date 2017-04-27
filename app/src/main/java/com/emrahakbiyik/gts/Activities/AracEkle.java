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

import com.emrahakbiyik.gts.Objects.Arac;
import com.emrahakbiyik.gts.Objects.SharedPref;
import com.emrahakbiyik.gts.R;

import java.math.BigDecimal;

public class AracEkle extends AppCompatActivity {
    boolean isImageFitToScreen;

    EditText etRumuz, etMarka, etModel, etPlaka, etTramer, etAlisFiyati, etSatisFiyati, etFaturaAlisFiyati, etFaturaSatisFiyati;
    SharedPref msP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_ekle);

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
    protected void onStop() {
        super.onStop();
    }

    public void doWork (View v){
        if ((v.getId()==R.id.btnBoyaDurumu)){
            Intent mIntent = new Intent(this, AracEkle.class);
            mIntent.putExtra("AracId","Arac"); //TODO: burası dinamik olacak
            startActivity(mIntent);
        } else if (v.getId()==R.id.btnKaydet){ //TODO: Alanlar boş olunca izin verilmeyecek.
            Arac mArac = new Arac();
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
                mArac.setAlisFiyati(mSatisfiyati);
                BigDecimal mFaturalisfiyati = new BigDecimal(etFaturaAlisFiyati.getText().toString());
                mArac.setAlisFiyati(mFaturalisfiyati);
                BigDecimal mFaturaSatisfiyati = new BigDecimal(etFaturaSatisFiyati.getText().toString());
                mArac.setAlisFiyati(mFaturaSatisfiyati);
            } catch (Exception e){
                Toast.makeText(getApplicationContext(),"e",Toast.LENGTH_SHORT);
            }
            try {
                msP.getInstance(getApplicationContext()).addArac(mArac);
                Toast.makeText(getApplicationContext(),"Arac Eklendi",Toast.LENGTH_SHORT);
            }catch (Exception e) {
                Toast.makeText(getApplicationContext(),"e",Toast.LENGTH_SHORT);
            }
            finish();
        }
    }
}
