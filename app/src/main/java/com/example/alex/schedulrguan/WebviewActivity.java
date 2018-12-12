package com.example.alex.schedulrguan;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.TextView;

public class WebviewActivity extends AppCompatActivity{

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
        setContentView(R.layout.activity_webview);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_schedule);

        WebView webView = findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://calendar.google.com/calendar/r");
    }

    private void switchToCourse()
    {
        Intent intentSchedActivity = new Intent(WebviewActivity.this, CourseActivity.class);
        startActivity(intentSchedActivity);
    }

    private void switchToSched()
    {
        Intent intentSchedActivity = new Intent(WebviewActivity.this, ScheduleActivity.class);
        startActivity(intentSchedActivity);
    }

    private void switchToSettings()
    {
        Intent intentSchedActivity = new Intent(WebviewActivity.this, SettingsActivity.class);
        startActivity(intentSchedActivity);
    }
}
