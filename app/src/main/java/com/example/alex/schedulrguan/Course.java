package com.example.alex.schedulrguan;

/**
 * Created by Alex on 12/18/2017.
 */

public class Course {
    private int _id; // the _ before id will distinguish the attribute defined in
    // the class from the attributes defined in the database
    private String name;
    private double difficulty;
    private int days;
    private double borderlineDifference;
    private double grade;
    private double priority;
    private final double BASE_SCORE = 70;

    public Course(){
        this.name = "";
        this.difficulty = 0;
        this.days = 0;
        determinePriority();
    }
    public Course(String courseName, double courseGrade, int difficulty, int daysLeft){
        this.name = courseName;
        this.grade = courseGrade;
        this.difficulty = difficulty;
        this.days = daysLeft;
        determinePriority();
    }
    public int getID(){
        return _id;
    }
    public String get_courseName(){
        return name;
    }
    public void set_id(int id){
        this._id = id;
    }
    private void determinePriority(){
        priority  = 0;
        priority = (BASE_SCORE - days*5);
        borderlineDifference = grade%10;
        if(borderlineDifference > 7 || borderlineDifference < 3)
        {
            if(borderlineDifference > 7)
            {
                priority += (BASE_SCORE - ((10-borderlineDifference) * 10));
            }
            else {
                priority += (BASE_SCORE - (borderlineDifference * 10));
            }
        }
        priority += difficulty * 2;
        priority -= grade/10;
    }
    public double getPriority()
    {
        return priority;
    }
}

