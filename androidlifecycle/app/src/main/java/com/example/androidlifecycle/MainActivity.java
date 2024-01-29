package com.example.androidlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

        Button goodLifecycleButton = findViewById(R.id.goodLifecycleButton);
        goodLifecycleButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, GoodLifecycleActivity.class);
            startActivity(intent);
        });
    }

    private void initializeBadLifecycleButton() {

        Button badLifecycleButton = findViewById(R.id.badLifecycleButton);
        badLifecycleButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, BadLifecycleActivity.class);
            startActivity(intent);
        });


    }
    //NOTE: This had goodLifeCycleButton id instead of badLifeCycleButton

    private void initializeUglyLifecycleButton() {

        Button uglyLifecycleButton = findViewById(R.id.uglyLifecycleButton);
        uglyLifecycleButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UglyLifecycleActivity.class);
            startActivity(intent);
        });

    }

    /**
     * Fires after the create. loads the visuals and gui. Happens when the activity is about
     * to be visible to the user
     */
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Lifecycle", "MainActivity: onStart()");
    }

    /**
     * Fires after a pause and the user returns to the activity and/or onStart
     * Makes the activity come to the foreground
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "MainActivity: onResume()");
    }

    /**
     * Occurs when the activity is no longer in the foreground
     * Suspends the activity. Can still be visible to the user.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "MainActivity: onPause()");
    }

    /**
     * Called when the activity is no longer visible.
     * Will either be followed by an onRestart or an onDestroy
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "MainActivity: onStop()");
    }

    /**
     * Destroys the activity
     * Happens when screen orientation changes (temporarily)
     * Happens when the user closes the app
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "MainActivity: onDestroy()");
    }

}