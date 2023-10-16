package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mobileapp.dao.HikeDAO;
import com.example.mobileapp.model.Hike;

public class AddActivity extends AppCompatActivity {
    //khai bao
    private EditText edtName, edtLocation,edtDate, edtLength,edtLevel,edtDescription, edtRisk,edtVehicle,edtEstimatedTime;
    private RadioGroup rgParking;
    private Button btnAdd, btnCancel;
    private String parking;
    HikeDAO hikeDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //anh xa
        AnhXa();
        hikeDAO = new HikeDAO(AddActivity.this);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rgParking.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_yes){
                    parking = "Yes";
                }else{
                    parking = "No";
                }
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String location = edtLocation.getText().toString();
                String date = edtDate.getText().toString();
                String length = edtLength.getText().toString();
                String level = edtLevel.getText().toString();
                String description = edtDescription.getText().toString();
                String risk = edtRisk.getText().toString();
                String vehicle = edtVehicle.getText().toString();
                String estiamtedTime = edtEstimatedTime.getText().toString();
                Hike hike = new Hike(name, location, date, parking, length, level, description, risk, vehicle, estiamtedTime);
                hikeDAO.AddHike(hike);
                Toast.makeText(getApplicationContext(),"Add Hike Successfull",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        edtName = (EditText) findViewById(R.id.edt_name);
        edtLocation = (EditText) findViewById(R.id.edt_location);
        edtDate = (EditText) findViewById(R.id.edt_date);
        edtLength = (EditText) findViewById(R.id.edt_length);
        edtLevel = (EditText) findViewById(R.id.edt_level);
        edtDescription = (EditText) findViewById(R.id.edt_description);
        edtRisk = (EditText) findViewById(R.id.edt_risk);
        edtVehicle = (EditText) findViewById(R.id.edt_vehicle);
        edtEstimatedTime= (EditText) findViewById(R.id.edt_estimated_time);
        rgParking = (RadioGroup) findViewById(R.id.rg_parking);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
    }
}