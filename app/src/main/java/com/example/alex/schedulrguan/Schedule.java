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
            temp = Math.round(temp);
            message[i]= "" + courseList.get(i).get_courseName() + " ||| " + temp + " minutes";
        }
        return message;
    }


    public ArrayList<Course> getArrayList()
    {
        return courseList;
    }


}

