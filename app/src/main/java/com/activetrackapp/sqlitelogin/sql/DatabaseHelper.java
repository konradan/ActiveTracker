package com.activetrackapp.sqlitelogin.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.activetrackapp.sqlitelogin.model.User;
import com.activetrackapp.sqlitelogin.model.RoadBike;

public class DatabaseHelper  extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "UserManager.db";

 //USER
    private static final String TABLE_USER = "user";


    private static final String COLUMN_USER_ID = "user_id";
    private static final String COLUMN_USER_NAME = "user_name";
    private static final String COLUMN_USER_EMAIL = "user_email";
    private static final String COLUMN_USER_PASSWORD = "user_password";

    //ROADBIKE
    private static final String TABLE_RoadBike = "road_bike";

    private static final String COLUMN_RIDE_ID = "roadride_id";
    private static final String COLUMN_DISTANCE = "distance";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_CALORIES = "calories";

    //USER
    private String CREATE_USER_TABLE = "CREATE TABLE " + TABLE_USER + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USER_NAME + " TEXT,"
            + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT" + ")";


    //ROADBIKE

    private String CREATE_ROAD_BIKE_TABLE = "CREATE TABLE " + TABLE_RoadBike + "("
            + COLUMN_RIDE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_DISTANCE + " TEXT,"
            + COLUMN_TIME + " TEXT," + COLUMN_DATE + " TEXT," + COLUMN_CALORIES + " TEXT"+")";


    //USER
    private String DROP_USER_TABLE = "DROP TABLE IF EXISTS " + TABLE_USER;

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    //ROADBIKE & USER

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_ROAD_BIKE_TABLE);
    }

    @Override
    public  void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
    }

//USER

    public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
    }


    //ROADBIKE

    public void addRoadRide(RoadBike road_bike){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DISTANCE, road_bike.getDistance());
        values.put(COLUMN_TIME, road_bike.getTime());
        values.put(COLUMN_DATE, road_bike.getDate());
        values.put(COLUMN_CALORIES, road_bike.getCalories());

        db.insert(TABLE_RoadBike, null, values);
        db.close();
    }

    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_RoadBike;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }


    public boolean checkUser(String email){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public boolean checkUser(String email, String password){
        String[] columns = {
                COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(TABLE_USER,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0){
            return true;
        }
        return false;
    }

    public Cursor getRoadBike(){
        String[] kolumny = {"roadride_id", "distance", "time", "date", "calories"};
        SQLiteDatabase db = getWritableDatabase();
        Cursor kursor = db.query("road_bike", kolumny, null, null, null, null, null);
        return kursor;
    }
}
