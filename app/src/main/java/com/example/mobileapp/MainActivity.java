package com.example.mobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobileapp.adapter.HikeAdapter;
import com.example.mobileapp.dao.HikeDAO;
import com.example.mobileapp.model.Hike;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvHike;
    private List<Hike> hikeList;
    private HikeAdapter adapter;
    private HikeDAO hikeDAO;
    private Toolbar mToolbar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Home");


        // Ánh xạ
        lvHike = (ListView) findViewById(R.id.lv_hikes);
        hikeList = new ArrayList<Hike>();
        hikeDAO = new HikeDAO(MainActivity.this);
        hikeList = hikeDAO.AllHikes();

        adapter = new HikeAdapter(getApplicationContext(),hikeList);
        lvHike.setAdapter(adapter);
        CRUD_Listview();


    }

    private void CRUD_Listview() {
        lvHike.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Hike hike = hikeList.get(i);
                Intent intent = new Intent(MainActivity.this, EditActivity.class); // main la man hinh 1 edit la man hinh 2
                intent.putExtra("DATA",hike);   //putExtra dung de truyen du lieu sang
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_add){
            Intent intent = new Intent(MainActivity.this,AddActivity.class);
            startActivity(intent);
        }
        if (id == R.id.menu_exit){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onResume() {
        super.onResume();
        hikeList.clear();
        hikeList.addAll(hikeDAO.AllHikes());
        adapter.notifyDataSetChanged();

    }
}