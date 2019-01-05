package com.activetrackapp.sqlitelogin.activities;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.activetrackapp.sqlitelogin.R;
import com.activetrackapp.sqlitelogin.helper.InputValidation;
import com.activetrackapp.sqlitelogin.model.RoadBike;
import com.activetrackapp.sqlitelogin.model.User;
import com.activetrackapp.sqlitelogin.sql.DatabaseHelper;


/**
 * Created by sirjohnnypaul on 25/01/2018.
 */




public class MyActivities extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activities);
        TextView tv = (TextView)findViewById(R.id.textView1);

        DatabaseHelper db = new DatabaseHelper(this);
        Cursor k = db.getRoadBike();

        while(k.moveToNext()) {
            int roadride_id = k.getInt(0);
            int distance = k.getInt(1);
            String time = k.getString(2);
            String date = k.getString(3);
            int calories = k.getInt(4);
            tv.setText (tv.getText()+"\n"+"ID: "+roadride_id+" Distance: "+distance+" Time: "+time+" Date: "+date+" Calories: "+calories);

        }

    }

}






