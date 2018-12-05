package com.example.alex.schedulrguan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ScheduleActivity extends AppCompatActivity {
    public static Schedule sched = new Schedule();

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_course:
                    switchToCourse();
                    return true;
                case R.id.navigation_schedule:

                    return true;
                case R.id.navigation_setting:
                    switchToSettings();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    static void addCourse(Course C)
    {
        sched.addCourse(C);
    }

    public void testGenerate(View V)
    {
        ArrayList<Course> courseList = sched.getArrayList();

        TextView schedTextView = (TextView) findViewById(R.id.message);
        TextView courseOneOutputTextView = (TextView)findViewById(R.id.courseOneOutputText);
        TextView courseTwoOutputTextView = (TextView)findViewById(R.id.courseTwoOutputText);
        TextView courseThreeOutputTextView = (TextView)findViewById(R.id.courseThreeOutputText);
        TextView courseFourOutputTextView = (TextView)findViewById(R.id.courseFourOutputText);
        TextView courseFiveOutputTextView = (TextView)findViewById(R.id.courseFiveOutputText);
        TextView courseSixOutputTextView = (TextView)findViewById(R.id.courseSixOutputText);

        String output = "";

        int timeWanted = SettingsActivity.timeOfStudy;

        /*for(int i = 0; i < courseList.size(); i++)
        {
            output = output.concat(courseList.get(i).get_courseName() + courseList.get(i).getPriority());
        }

        schedTextView.setText(output);*/

        sched.orderCourses();

        String[] outputs = sched.generateOutput(timeWanted);

        if(outputs.length == 6)
        {
            courseOneOutputTextView.setText(outputs[0]);
            courseTwoOutputTextView.setText(outputs[1]);
            courseThreeOutputTextView.setText(outputs[2]);
            courseFourOutputTextView.setText(outputs[3]);
            courseFiveOutputTextView.setText(outputs[4]);
            courseSixOutputTextView.setText(outputs[5]);
        }
        else if(outputs.length == 5)
        {
            courseOneOutputTextView.setText(outputs[0]);
            courseTwoOutputTextView.setText(outputs[1]);
            courseThreeOutputTextView.setText(outputs[2]);
            courseFourOutputTextView.setText(outputs[3]);
            courseFiveOutputTextView.setText(outputs[4]);
        }
        else if(outputs.length == 4)
        {
            courseOneOutputTextView.setText(outputs[0]);
            courseTwoOutputTextView.setText(outputs[1]);
            courseThreeOutputTextView.setText(outputs[2]);
            courseFourOutputTextView.setText(outputs[3]);
        }
        else if(outputs.length == 3)
        {
            courseOneOutputTextView.setText(outputs[0]);
            courseTwoOutputTextView.setText(outputs[1]);
            courseThreeOutputTextView.setText(outputs[2]);
        }
        else if (outputs.length == 2)
        {
            courseOneOutputTextView.setText(outputs[0]);
            courseTwoOutputTextView.setText(outputs[1]);
        }
        else
            courseOneOutputTextView.setText(outputs[0]);
    }

    private void switchToCourse() {
        Intent intentSchedActivity = new Intent(ScheduleActivity.this, CourseActivity.class);
        startActivity(intentSchedActivity);
    }

    private void switchToSettings()
    {
        Intent intentSchedActivity = new Intent(ScheduleActivity.this, SettingsActivity.class);
        startActivity(intentSchedActivity);
    }
}
