package com.example.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * This callback is absolutely necessary. It will trigger when the system first creates the activity.
     * onCreate() performs the basic application startup logic that happens only once for the entire life of the activity.
     * You might use it to bind some data to lists, associate the activity with the ViewModel, and instantiate some class-scope variables.
     *
     * @param savedInstanceState - is the Bundle object containing the activities previously saved state. If the activity never existed before,
     *                             the value of the Bundle object is null.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initializeGoodLifecycleButton();
        initializeBadLifecycleButton();
        initializeUglyLifecycleButton();
    }

    /**
     * The following 3 methods are private methods that help initialize buttons for navigating to our three other activities.
     * We must set an OnClickListener that creates an Intent to start the select the corresponding activity depending on what button is clicked.
     */
    private void initializeGoodLifecycleButton() {
        /*
        Button goodLifecycleButton = findViewById(R.id.goodLifecycleButton);
        goodLifecycleButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GoodLifecycleActivity.class);
            startActivity(intent);
        });*/
    }

    private void initializeBadLifecycleButton() {
        /*
        Button badLifecycleButton = findViewById(R.id.badLifecycleButton);
        badLifecycleButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BadLifecycleActivity.class);
            startActivity(intent);
        });

         */
    }

    private void initializeUglyLifecycleButton() {
        /*
        Button uglyLifecycleButton = findViewById(R.id.uglyLifecycleButton);
        uglyLifecycleButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UglyLifecycleActivity.class);
            startActivity(intent);
        });
         */
    }

    /**
     */
    @Override
    protected void onStart() {
        super.onStart();
    }

    /**
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     */
    @Override
    protected void onPause() {
        super.onPause();
        ///Log.d("Lifecycle", "MainActivity: onPause()");
    }

    /**
     */
    @Override
    protected void onStop() {
        super.onStop();
        ///Log.d("Lifecycle", "MainActivity: onStop()");
    }

    /**
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        ///Log.d("Lifecycle", "MainActivity: onDestroy()");
    }

}