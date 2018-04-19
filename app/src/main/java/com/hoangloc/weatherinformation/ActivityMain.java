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
import android.support.v7.widget.RecyclerView;
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

    static SharedPreferences weatherSharedPref;
    static SharedPreferences.Editor weatherSharedPrefEditor;
    FragmentWeather fragmentWeather;
    FloatingActionButton fabSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        weatherSharedPref = getSharedPreferences("weatherSharedPref", Context.MODE_PRIVATE);
        fragmentWeather = new FragmentWeather();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.placeHolder, fragmentWeather ).commit();
        }

        //fabSetting = findViewById(R.id.fabSetting);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }


}
