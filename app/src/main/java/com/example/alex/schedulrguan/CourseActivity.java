package com.example.alex.schedulrguan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CourseActivity extends AppCompatActivity {
    private TextView mTextMessage;
    DatabaseHelper myDb;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_course:

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
        setContentView(R.layout.activity_course);
        myDb = new DatabaseHelper(this);

        //code for the listview listener
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listview, View v, int position, long id) {
                if (position == 0) { // navigate user to EntreeCategoryActivity
                    // Need to create an Intent to allow us to switch activities
                    Intent intent = new Intent(CourseActivity.this, CourseOneActivity.class);
                    startActivity(intent);
                }
                else if (position == 1) { // navigate user to EntreeCategoryActivity
                    // Need to create an Intent to allow us to switch activities
                    Intent intent2 = new Intent(CourseActivity.this, CourseTwoActivity.class);
                    startActivity(intent2);
                }
                else if (position == 2) { // navigate user to EntreeCategoryActivity
                    // Need to create an Intent to allow us to switch activities
                    Intent intent3 = new Intent(CourseActivity.this, CourseThreeActivity.class);
                    startActivity(intent3);
                }
                else if (position == 3) { // navigate user to EntreeCategoryActivity
                    // Need to create an Intent to allow us to switch activities
                    Intent intent4 = new Intent(CourseActivity.this, CourseTwoActivity.class);
                    startActivity(intent4);
                }
                else if (position == 4) { // navigate user to EntreeCategoryActivity
                    // Need to create an Intent to allow us to switch activities
                    Intent intent5 = new Intent(CourseActivity.this, CourseTwoActivity.class);
                    startActivity(intent5);
                }
                else if (position == 5) { // navigate user to EntreeCategoryActivity
                    // Need to create an Intent to allow us to switch activities
                    Intent intent6 = new Intent(CourseActivity.this, CourseTwoActivity.class);
                    startActivity(intent6);
                }

            }
        };
        // These two lines attach the onItemClickListener to the ListView component
        ListView listVIew = (ListView) findViewById(R.id.menu_course_options);
        listVIew.setOnItemClickListener(itemClickListener);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onResume(){
        super.onResume();
        int i = ScheduleActivity.sched.getArrayList().size();
        TextView markerOneView = (TextView)findViewById(R.id.courseOneMarkerText);
        TextView markerTwoView = (TextView)findViewById(R.id.courseTwoMarkerText);
        TextView markerThreeView = (TextView)findViewById(R.id.courseThreeMarkerText);
        TextView markerFourView = (TextView)findViewById(R.id.courseFourMarkerText);
        TextView markerFiveView = (TextView)findViewById(R.id.courseFiveMarkerText);
        TextView markerSixView = (TextView)findViewById(R.id.courseSixMarkerText);

        if(i == 6)
        {
            markerOneView.setText("Course 1 Added");
            markerTwoView.setText("Course 2 Added");
            markerThreeView.setText("Course 3 Added");
            markerFourView.setText("Course 4 Added");
            markerFiveView.setText("Course 5 Added");
            markerSixView.setText("Course 6 Added");
        }
        else if (i == 5)
        {
            markerOneView.setText("Course 1 Added");
            markerTwoView.setText("Course 2 Added");
            markerThreeView.setText("Course 3 Added");
            markerFourView.setText("Course 4 Added");
            markerFiveView.setText("Course 5 Added");
        }
        else if (i == 4)
        {
            markerOneView.setText("Course 1 Added");
            markerTwoView.setText("Course 2 Added");
            markerThreeView.setText("Course 3 Added");
            markerFourView.setText("Course 4 Added");
        }
        else if (i == 3)
        {
            markerOneView.setText("Course 1 Added");
            markerTwoView.setText("Course 2 Added");
            markerThreeView.setText("Course 3 Added");
        }
        else if (i == 2)
        {
            markerOneView.setText("Course 1 Added");
            markerTwoView.setText("Course 2 Added");
        }
        else if (i == 1)
        {
            markerOneView.setText("Course 1 Added");
        }

    }


    private void switchToSched()
    {
        Intent intentSchedActivity = new Intent(CourseActivity.this, ScheduleActivity.class);
        startActivity(intentSchedActivity);
    }

    private void switchToSettings()
    {
        Intent intentSchedActivity = new Intent(CourseActivity.this, SettingsActivity.class);
        startActivity(intentSchedActivity);
    }

    void changeOneMarker()
    {
        TextView courseOneMarkerTextView = (TextView)findViewById(R.id.courseOneMarkerText);
        courseOneMarkerTextView.setText("Course One Added");
    }
}
