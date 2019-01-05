package com.activetrackapp.sqlitelogin.model;

/**
 * Created by delaroy on 3/27/17.
 */
public class RoadBike {

    private int road_bike_id;
    private String distance;
    private String time;
    private String date;
    private String calories;

    public int getId(){ return road_bike_id;}

    public void setId(int id){
        this.road_bike_id = id;
    }

    public String getDistance(){
        return distance;
    }

    public void setDistance(String distance){
        this.distance = distance;
    }

    public String getTime(){
        return time;
    }

    public void setTime(String name){
        this.time = time;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getCalories(){
        return calories;
    }

    public void setCalories(String calories){
        this.calories = calories;
    }
}
