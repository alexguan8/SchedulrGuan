package com.example.alex.schedulrguan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.razerdp.widget.animatedpieview.AnimatedPieView;
import com.razerdp.widget.animatedpieview.AnimatedPieViewConfig;
import com.razerdp.widget.animatedpieview.data.SimplePieInfo;

public class PieActivity extends AppCompatActivity{

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
        setContentView(R.layout.activity_pie);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        AnimatedPieView animatedPieView = findViewById(R.id.pieView1);
        AnimatedPieViewConfig config = new AnimatedPieViewConfig();

        config.addData(new SimplePieInfo(Schedule.threeTimes[0], Color.parseColor("#AAFF0000"), Schedule.threeNames[0]));
        config.addData(new SimplePieInfo(Schedule.threeTimes[1], Color.parseColor("#AA00FF00"), Schedule.threeNames[1]));
        config.addData(new SimplePieInfo(Schedule.threeTimes[2], Color.parseColor("#AA0000FF"), Schedule.threeNames[2]));
        config.strokeMode(false);
        config.duration(200);
        config.drawText(true);
        config.textSize(52);

        animatedPieView.applyConfig(config);
        animatedPieView.start();
    }

    private void switchToCourse()
    {
        Intent intentSchedActivity = new Intent(PieActivity.this, CourseActivity.class);
        startActivity(intentSchedActivity);
    }

    private void switchToSched()
    {
        Intent intentSchedActivity = new Intent(PieActivity.this, ScheduleActivity.class);
        startActivity(intentSchedActivity);
    }

    private void switchToSettings()
    {
        Intent intentSchedActivity = new Intent(PieActivity.this, SettingsActivity.class);
        startActivity(intentSchedActivity);
    }
}
