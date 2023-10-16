package com.example.mobileapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context, "HikeManagement.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlHikeCreate = "CREATE TABLE IF NOT EXISTS " +
                "Hike(ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Name VARCHAR(200), " +
                "Location VARCHAR(200)," +
                "DateOfHike VARCHAR(200),"+
                "ParkingAvailable VARCHAR(200),"+
                "LengthTheHike VARCHAR(200),"+
                "LevelOfDifficulty VARCHAR(200),"+
                "Description VARCHAR(200)," +
                "RiskAssessment VARCHAR(200)," +
                "Vehicle VARCHAR(200)," +
                "EstimatedTime VARCHAR(200))";
        sqLiteDatabase.execSQL(sqlHikeCreate);
        String sqlInsert1 ="INSERT INTO Hike(Name,Location,DateOfHike, ParkingAvailable,LengthTheHike,LevelOfDifficulty,Description,RiskAssessment,Vehicle,EstimatedTime) " +
                " VALUES('Vui choi','Ha Long','Today','Yes','3km','Normal','asdhasdl','No','Bike','3Hours')";
        String sqlInsert2 ="INSERT INTO Hike(Name,Location,DateOfHike, ParkingAvailable,LengthTheHike,LevelOfDifficulty,Description,RiskAssessment,Vehicle,EstimatedTime) " +
                " VALUES('Di bo giai tri','Ha Giang','Tomorrow','Yes','5km','Hard','hay ho','No','Walk','5Hours')";
        sqLiteDatabase.execSQL(sqlInsert1);
        sqLiteDatabase.execSQL(sqlInsert2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
