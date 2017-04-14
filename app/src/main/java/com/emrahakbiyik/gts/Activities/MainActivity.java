package com.emrahakbiyik.gts.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.Toast;

import com.emrahakbiyik.gts.Objects.Arac;
import com.emrahakbiyik.gts.R;
import com.emrahakbiyik.gts.Triggers.RecyclerItemClickListener;
import com.emrahakbiyik.gts.Triggers.SimpleRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private List<Arac> AracList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = (RecyclerView)findViewById(R.id.arac_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(),AracEkle.class);
                startActivity(mIntent);
            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recycler_view.setLayoutManager(layoutManager);

        /*
        burası gidecek
         */
        AracList = new ArrayList<>();

        int[] photoID= new int[1];
        photoID[0]=R.drawable.car;


        AracList.add(new Arac("Deneme","34 ABC 123",photoID));
        AracList.add(new Arac("Deneme","34 ABC 123", photoID));
        AracList.add(new Arac("Deneme","34 ABC 123", photoID));
        AracList.add(new Arac("Deneme","34 ABC 123", photoID));

        //---------------------
        recycler_view.setHasFixedSize(true);
        recycler_view.setAdapter(new SimpleRecyclerAdapter(AracList));
        recycler_view.setItemAnimator(new DefaultItemAnimator());

        recycler_view.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(),position+"",Toast.LENGTH_SHORT).show();
                    }
                }));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.®
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
