package com.example.mobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mobileapp.dao.HikeDAO;
import com.example.mobileapp.model.Hike;

public class EditActivity extends AppCompatActivity {

    private EditText edtName, edtLocation,edtDate, edtLength,edtLevel,edtDescription, edtRisk,edtVehicle,edtEstimatedTime;
    private RadioGroup rgParking;
    private RadioButton rbYes, rbNo;
    private Button btnSave, btnCancel;
    private HikeDAO hikeDAO;
    private String parking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        hikeDAO = new HikeDAO(EditActivity.this);
        //Lay du lieu tu main
        Intent intent = getIntent();
        Hike hike = (Hike) intent.getSerializableExtra("DATA"); //chuoi nhan lai gia tri tu main gui sang
        //anh xa du lieu
        AnhXa();

        //lay du lieu day len view
        edtName.setText(hike.getName());
        edtLocation.setText(hike.getLocation());
        edtDate.setText(hike.getDate_of_hike());
        edtLength.setText(hike.getLength_the_hike());
        edtLevel.setText(hike.getLevel_of_difficulty());
        edtDescription.setText(hike.getDescription());
        edtRisk.setText(hike.getRisk_assessment());
        edtVehicle.setText(hike.getVehicle());
        edtEstimatedTime.setText(hike.getEstimated_time());



        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hike.setName(edtName.getText().toString());
                hike.setLocation(edtLocation.getText().toString());
                hike.setDate_of_hike(edtDate.getText().toString());
                hike.setLength_the_hike(edtLength.getText().toString());
                hike.setLevel_of_difficulty(edtLevel.getText().toString());
                hike.setDescription(edtDescription.getText().toString());
                hike.setRisk_assessment(edtRisk.getText().toString());
                hike.setVehicle(edtVehicle.getText().toString());
                hike.setEstimated_time(edtEstimatedTime.getText().toString());
                hike.setParking_available(parking);
                hikeDAO.EditHike(hike);
                Toast.makeText(getApplicationContext(),"Save Successfull",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(EditActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rgParking.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.rb_yes){
                    parking = "Yes";
                }else {
                    parking = "No";
                }
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
        btnSave = (Button) findViewById(R.id.btn_save);
        btnCancel = (Button) findViewById(R.id.btn_cancel);
    }
}