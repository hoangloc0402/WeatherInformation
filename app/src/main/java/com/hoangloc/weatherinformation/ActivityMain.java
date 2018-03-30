package com.hoangloc.weatherinformation;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.Random;

public class ActivityMain extends AppCompatActivity {

    SharedPreferences weatherSharedPref;
    SharedPreferences.Editor weatherSharedPrefEditor;
    FragmentWeather fragmentWeather;
    FloatingActionButton fabSetting;
    int currentTheme = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        weatherSharedPref = getSharedPreferences("weatherSharedPref", Context.MODE_PRIVATE);
        fragmentWeather = new FragmentWeather();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.placeHolder, fragmentWeather ).commit();
        }

        fabSetting = findViewById(R.id.fabSetting);
        fabSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (currentTheme){
                    case 0:
                        fragmentWeather.setBackground(0);
                       // toolbar.setBackground();
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
                        currentTheme = 1;
                        break;

                    default:
                        fragmentWeather.setBackground(1);
                        //toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary5));
                        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary5)));
                        currentTheme =0;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
