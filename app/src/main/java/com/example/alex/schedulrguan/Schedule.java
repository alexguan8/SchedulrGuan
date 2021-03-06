package com.example.alex.schedulrguan;

import java.util.ArrayList;

/**
 * Created by Alex on 12/18/2017.
 */

public class Schedule {
    private int _id; // the _ before id will distinguish the attribute defined in
    // the class from the attributes defined in the database
    private String name;
    private ArrayList<Course> courseList = new ArrayList<Course>();
    /*private Course courseOne = new Course("Math", 88, 9, 1);
    private Course courseTwo = new Course("English", 78, 9, 1);
    private Course courseThree = new Course("Science", 87, 5, 4);*/

    //for the pie chart
    static double[] threeTimes = new double[3];
    static String[] threeNames = new String[3];


    public Schedule() {
        this.name = "";

    }


    public int getID() {
        return _id;
    }

    public String get_courseName() {
        return name;
    }

    public void set_id(int id) {
        this._id = id;
    }

    public void addCourse(Course c)
    {
        courseList.add(c);
    }

    public void orderCourses()
    {
        int n = courseList.size();
        for(int i = 0; i < n; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                if (courseList.get(j-1).getPriority() < courseList.get(j).getPriority())
                {
                    Course temp = courseList.get(j-1);
                    courseList.set(j-1, courseList.get(j));
                    courseList.set(j,temp);
                }
            }
        }
    }


    public String[] generateOutput(int studyTime)
    {
        double[] times = new double[courseList.size()];
        double total = 0;
        String[] message = new String[courseList.size()];
        for(int i =0; i < courseList.size();i++)
        {
            total += courseList.get(i).getPriority();
        }

        for(int i = 0; i < courseList.size();i++)
        {
            times[i] = courseList.get(i).getPriority()/total;
            double temp = (double)studyTime * times[i];
            temp = Math.round(temp / 7);
            message[i]= "" + courseList.get(i).get_courseName() + " ||| " + temp + " minutes per day(" + courseList.get(i).getPriority() + " priority score)";
        }

        //for the pie chart
        threeTimes[0] = times[0];
        threeTimes[1] = times[1];
        threeTimes[2] = times[2];

        threeNames[0] = courseList.get(0).get_courseName();
        threeNames[1] = courseList.get(1).get_courseName();
        threeNames[2] = courseList.get(2).get_courseName();
        return message;
    }


    public ArrayList<Course> getArrayList()
    {
        return courseList;
    }


}

