package com.example.alex.schedulrguan;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import java.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class CourseOneActivity extends AppCompatActivity {

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
                    switchToSched();
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
        setContentView(R.layout.activity_course_one);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void updateInfo(View V)
    {
        EditText courseNameEditText = (EditText)findViewById(R.id.classEdit);
        EditText courseGradeEditText = (EditText)findViewById(R.id.gradeEdit);
        SeekBar diffBar = (SeekBar)findViewById(R.id.difficultySlider);

        String courseName = courseNameEditText.getText().toString();

        String courseGradeValue = courseGradeEditText.getText().toString();

        if(!courseName.equals("") && !courseGradeValue.equals("")) {

            int courseGrade = Integer.parseInt(courseGradeValue);

            int difficulty = diffBar.getProgress();

            CalendarView dateTestCalendarView = (CalendarView)findViewById(R.id.testDateCalendar);
            long testDate = dateTestCalendarView.getDate();
            int daysLeft = convertDays(testDate);


            Course courseOne = new Course(courseName, courseGrade, difficulty, daysLeft);
            ScheduleActivity.addCourse(courseOne);

            switchToCourse();
        }
        else
        {
            AlertDialog alertDialog = new AlertDialog.Builder(CourseOneActivity.this).create();
            alertDialog.setTitle("FIELD(S) NULL");
            alertDialog.setMessage("MAKE SURE ALL THE FIELDS ARE INPUT CORRECTLY");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    public int convertDays(long testDate)
    {
        Calendar c = Calendar.getInstance();
        long current = c.getTime().getTime();
        long difference = testDate - current;

        int secondsInDay = 8640000;

        int daysLeft = (int)difference/secondsInDay;

        return daysLeft;
    }


    private void switchToCourse()
    {
        Intent intentSchedActivity = new Intent(CourseOneActivity.this, CourseActivity.class);
        startActivity(intentSchedActivity);
    }

    private void switchToSched()
    {
        Intent intentSchedActivity = new Intent(CourseOneActivity.this, ScheduleActivity.class);
        startActivity(intentSchedActivity);
    }

    private void switchToSettings()
    {
        Intent intentSchedActivity = new Intent(CourseOneActivity.this, SettingsActivity.class);
        startActivity(intentSchedActivity);
    }
}
