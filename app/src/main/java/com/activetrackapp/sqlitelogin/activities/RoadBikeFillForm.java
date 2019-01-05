package com.activetrackapp.sqlitelogin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

import com.activetrackapp.sqlitelogin.R;
import com.activetrackapp.sqlitelogin.helper.InputValidation;
import com.activetrackapp.sqlitelogin.model.RoadBike;

import com.activetrackapp.sqlitelogin.sql.DatabaseHelper;

/**
 * Created by sirjohnnypaul on 24/01/2018.
 */

public class RoadBikeFillForm extends AppCompatActivity implements View.OnClickListener {

    private final AppCompatActivity activity = RoadBikeFillForm.this;

    private NestedScrollView nestedScrollView;

    private TextInputLayout textInputLayoutDistance;
    private TextInputLayout textInputLayoutTime;
    private TextInputLayout textInputLayoutDate;
    private TextInputLayout textInputLayoutCalories;

    private TextInputEditText textInputEditTextDistance;
    private TextInputEditText textInputEditTextTime;
    private TextInputEditText textInputEditTextDate;
    private TextInputEditText textInputEditTextCalories;

    private AppCompatButton UploadButton;

    private DatabaseHelper databaseHelper;
    private RoadBike road_bike;

    public InputValidation inputValidation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.road_bike_form);
        Button UploadButton = (Button) findViewById(R.id.UploadButton);
        UploadButton.setOnClickListener(this);

        getSupportActionBar().hide();

        initViews();
        initListeners();
        initObjects();
    }

    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);

        textInputLayoutDistance = (TextInputLayout) findViewById(R.id.textInputLayoutDistance);
        textInputLayoutTime = (TextInputLayout) findViewById(R.id.textInputLayoutTime);
        textInputLayoutDate = (TextInputLayout) findViewById(R.id.textInputLayoutDate);
        textInputLayoutCalories = (TextInputLayout) findViewById(R.id.textInputLayoutCalories);

        textInputEditTextDistance = (TextInputEditText) findViewById(R.id.textInputEditTextDistance);
        textInputEditTextTime = (TextInputEditText) findViewById(R.id.textInputEditTextTime);
        textInputEditTextDate = (TextInputEditText) findViewById(R.id.textInputEditTextDate);
        textInputEditTextCalories = (TextInputEditText) findViewById(R.id.textInputEditTextCalories);

        UploadButton = (AppCompatButton) findViewById(R.id.UploadButton);


    }

    private void initListeners() {
        UploadButton.setOnClickListener(this);

    }

    private void initObjects() {
        databaseHelper = new DatabaseHelper(activity);
        road_bike = new RoadBike();
    }

    public void postDataToSQLite() {


        road_bike.setDistance(textInputEditTextDistance.getText().toString().trim());
        road_bike.setTime(textInputEditTextTime.getText().toString().trim());
        road_bike.setDate(textInputEditTextDate.getText().toString().trim());
        road_bike.setCalories(textInputEditTextCalories.getText().toString().trim());

        databaseHelper.addRoadRide(road_bike);


    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.UploadButton:

                postDataToSQLite();
                finish();
                break;
        }

    }

}
