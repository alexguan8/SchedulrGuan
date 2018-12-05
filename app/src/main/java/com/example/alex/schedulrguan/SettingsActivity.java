package com.example.alex.schedulrguan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jshen on 12/18/2017.
 */

public class SettingsActivity extends AppCompatActivity{
    static int timeOfStudy;

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

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void updateInfo(View V)
    {
        EditText minutesStudiedEditText =(EditText)findViewById(R.id.timeEdit);
        int timeWanted = Integer.parseInt(minutesStudiedEditText.getText().toString());
        timeOfStudy = timeWanted;
    }

    private void switchToCourse()
    {
        Intent intentSchedActivity = new Intent(SettingsActivity.this, CourseActivity.class);
        startActivity(intentSchedActivity);
    }

    private void switchToSched()
    {
        Intent intentSchedActivity = new Intent(SettingsActivity.this, ScheduleActivity.class);
        startActivity(intentSchedActivity);
    }
}
