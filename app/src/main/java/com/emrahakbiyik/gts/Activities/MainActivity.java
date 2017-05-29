package com.emrahakbiyik.gts.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.emrahakbiyik.gts.Models.Arac;
import com.emrahakbiyik.gts.Models.SharedPref;
import com.emrahakbiyik.gts.R;
import com.emrahakbiyik.gts.Triggers.RecyclerItemClickListener;
import com.emrahakbiyik.gts.Triggers.SimpleRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private List<Arac> AracList;
    private SimpleRecyclerAdapter mSimRecAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler_view = (RecyclerView) findViewById(R.id.arac_recycler_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = new Intent(getApplicationContext(), AracEkle.class);
                startActivity(mIntent);

            }
        });


        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setHasFixedSize(true);
        recycler_view.setItemAnimator(new DefaultItemAnimator());
        recycler_view.addOnItemTouchListener(new RecyclerItemClickListener(MainActivity.this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), position + "", Toast.LENGTH_SHORT).show();
            }
        }));

        AracList = new ArrayList<>();
        AracList = SharedPref.getInstance(getApplicationContext()).getAraclist();
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
        switch (id){
            case R.id.action_settings:
                return true;

            case R.string.action_settings:
                SharedPref.getInstance(getApplicationContext()).clear();
                onResume();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        AracList = SharedPref.getInstance(getApplicationContext()).getAraclist();
        mSimRecAdapter = new SimpleRecyclerAdapter(AracList);
        recycler_view.setAdapter(mSimRecAdapter);
    }

}
