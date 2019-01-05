package com.activetrackapp.sqlitelogin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.activetrackapp.sqlitelogin.R;


/**
 * Created by sirjohnnypaul on 23/01/2018.
 */

public class HomePad extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_pad);


        Button GoToFillForm;

        GoToFillForm = (Button) findViewById(R.id.buttonRoadBikeForm);

        GoToFillForm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Intent code for open new activity through intent.

                Intent intent = new Intent(HomePad.this, RoadBikeFillForm.class);
                startActivity(intent);

            }
        });


        Button GoToMyActivities;

        GoToMyActivities = (Button) findViewById(R.id.buttonMyActivities);

        GoToMyActivities.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Intent code for open new activity through intent.

                Intent intent = new Intent(HomePad.this, MyActivities.class);
                startActivity(intent);

            }
        });

    }
    }

