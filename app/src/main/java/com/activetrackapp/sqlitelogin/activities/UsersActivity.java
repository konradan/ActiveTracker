package com.activetrackapp.sqlitelogin.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.activetrackapp.sqlitelogin.R;

/**
 * Created by delaroy on 3/27/17.
 */
public class UsersActivity extends AppCompatActivity {

    private TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        textViewName = (TextView) findViewById(R.id.text1);
        String nameFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText("Welcome in ActiveTrack " + nameFromIntent);

        Button GoToNewActivity;


            GoToNewActivity = (Button) findViewById(R.id.buttonClickToMenu);

            GoToNewActivity.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {

                    // Intent code for open new activity through intent.

                    Intent intent = new Intent(UsersActivity.this, HomePad.class);
                    startActivity(intent);

                }
            });
        }
    }


