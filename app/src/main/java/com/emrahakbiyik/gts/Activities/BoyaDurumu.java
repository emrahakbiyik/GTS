package com.emrahakbiyik.gts.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.emrahakbiyik.gts.R;

public class BoyaDurumu extends AppCompatActivity {

    int[] boyaDurumu = new int[12];

    TextView tvSolOnCamurluk, tvSolOnKapi, tvSolArkaKapi, tvSolArkaCamurluk, tvOnTampon, tvOnKaput, tvTavan, tvArkaKaput,tvArkaTampon, tvSagonCamurluk, tvSagOnKapi, tvSagArkaKapi, tvSagArkaCamurluk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boya_durumu);

        tvSolOnCamurluk= (TextView)findViewById(R.id.tvSolOnCamurluk);
        tvSolOnKapi= (TextView)findViewById(R.id.tvSolOnKapi);
        tvSolArkaKapi= (TextView)findViewById(R.id.tvSolArkaKapi);
        tvSolArkaCamurluk= (TextView)findViewById(R.id.tvSolArkaCamurluk);
        tvOnKaput= (TextView)findViewById(R.id.tvOnKaput);
        tvTavan= (TextView)findViewById(R.id.tvTavan);
        tvArkaKaput= (TextView)findViewById(R.id.tvArkaKaput);
        tvArkaTampon= (TextView)findViewById(R.id.tvArkaTampon);
        tvSagonCamurluk= (TextView)findViewById(R.id.tvSagOnCamurluk);
        tvSagOnKapi= (TextView)findViewById(R.id.tvSagOnKapi);
        tvSagArkaKapi= (TextView)findViewById(R.id.tvSagArkaKapi);
        tvSagArkaCamurluk= (TextView)findViewById(R.id.tvSagArkaCamurluk);
        tvSagArkaCamurluk= (TextView)findViewById(R.id.tvSagArkaCamurluk);
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    public void boyaDurumuClick (View v){
        switch (v.getId()){
            case R.id.tvSolOnCamurluk:
                boyaDurumu[0]=durumDegistirInt(boyaDurumu[0]);
                tvSolOnCamurluk=durumDegistirView((TextView)v);
                break;
            case R.id.tvSolOnKapi:
                boyaDurumu[1]=durumDegistirInt(boyaDurumu[0]);
                tvSolOnKapi=durumDegistirView((TextView)v);
                break;
            case R.id.tvSolArkaKapi:
                boyaDurumu[2]=durumDegistirInt(boyaDurumu[0]);
                tvSolArkaKapi=durumDegistirView((TextView)v);
                break;
            case R.id.tvSolArkaCamurluk:
                boyaDurumu[3]=durumDegistirInt(boyaDurumu[0]);
                tvSolArkaCamurluk=durumDegistirView((TextView)v);
                break;
            case R.id.tvOnTampon:
                boyaDurumu[4]=durumDegistirInt(boyaDurumu[0]);
                tvOnTampon=durumDegistirView((TextView)v);
                break;
            case R.id.tvOnKaput:
                boyaDurumu[5]=durumDegistirInt(boyaDurumu[0]);
                tvOnKaput=durumDegistirView((TextView)v);
                break;
            case R.id.tvTavan:
                boyaDurumu[6]=durumDegistirInt(boyaDurumu[0]);
                tvTavan=durumDegistirView((TextView)v);
                break;
            case R.id.tvArkaKaput:
                boyaDurumu[7]=durumDegistirInt(boyaDurumu[0]);
                tvArkaKaput=durumDegistirView((TextView)v);
                break;
            case R.id.tvArkaTampon:
                boyaDurumu[8]=durumDegistirInt(boyaDurumu[0]);
                tvArkaTampon=durumDegistirView((TextView)v);
                break;
            case R.id.tvSagOnCamurluk:
                boyaDurumu[9]=durumDegistirInt(boyaDurumu[0]);
                tvSagonCamurluk=durumDegistirView((TextView)v);
                break;
            case R.id.tvSagOnKapi:
                boyaDurumu[10]=durumDegistirInt(boyaDurumu[0]);
                tvSagOnKapi=durumDegistirView((TextView)v);
                break;
            case R.id.tvSagArkaKapi:
                boyaDurumu[11]=durumDegistirInt(boyaDurumu[0]);
                tvSagArkaKapi=durumDegistirView((TextView)v);
                break;
            case R.id.tvSagArkaCamurluk:
                boyaDurumu[12]=durumDegistirInt(boyaDurumu[0]);
                tvSagArkaCamurluk=durumDegistirView((TextView)v);
                break;
        }
    }

    public int durumDegistirInt(int id){  //0 "O"rijinal, 1 "B"oyalı, 2 "D"eğişmiş
        if (id>1) {
            id =0;
        } else id++;
                return id;
    }

    public TextView durumDegistirView(TextView v){
        String comstr=v.getText().toString();
        if (comstr.equals("O")){
            v.setText("B");
            v.setTextColor(Color.RED);
        } else if (comstr.equals("B")){
            v.setText("D");
            v.setTextColor(Color.GREEN);
        } else if (comstr.equals("D")){
            v.setText("O");
            v.setTextColor(Color.BLACK);
        }
        return v;
    }

    public void doWork(View v){
        if (v.getId()==R.id.btnBoyaDurumuOK){
            Intent mIntent = new Intent();
            mIntent.putExtra("BoyaDurumu", boyaDurumu);
            setResult(RESULT_OK, mIntent);
            finish();
        }
    }



}
