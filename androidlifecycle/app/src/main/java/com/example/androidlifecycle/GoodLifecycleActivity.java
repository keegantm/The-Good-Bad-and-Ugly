package com.example.androidlifecycle;


import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.VideoView;
import android.os.Bundle;
import android.os.BaseBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class GoodLifecycleActivity extends AppCompatActivity {

    private VideoView videoView;
    private int currentPosition = 0; // To save the current position of video playback

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer);

        videoView = findViewById(R.id.videoView);
        String path = "android.resource://" + getPackageName() + "/" + R.raw.trailer;
        videoView.setVideoURI(Uri.parse(path));

        if (savedInstanceState != null) {
            // Restore last state for checked position.
            currentPosition = savedInstanceState.getInt("currentPosition", 0);
        }
        videoView.seekTo(currentPosition);
    }

    @Override
    protected void onStart() {
        Log.d("Lifecycle", "GoodLifeCycleActivity: onStart");
        super.onStart();
        Log.d("Lifecycle", String.valueOf(currentPosition));

        videoView.start(); // Start the video when the activity starts


    }

    @Override
    protected void onDestroy() {
        Log.d("Lifecycle", "GoodLifeCycleActivity: onDestroy");
        //added next line. Want to continue video on orientation change. May want to use bundle instead
        //currentPosition = videoView.getCurrentPosition();
        super.onDestroy();
        videoView.stopPlayback(); // Stop the video playback and release resources
    }

    //I added all bellow this

    @Override
    protected void onStop() {
        Log.d("Lifecycle", "GoodLifeCycleActivity: onStop");
        super.onStop();

        //pause and suspend the video
        videoView.suspend();

    }

    @Override
    protected void onPause() {
        Log.d("Lifecycle", "GoodLifeCycleActivity: onPause");
        super.onPause();

        currentPosition = videoView.getCurrentPosition();
        videoView.pause();

    }

    @Override
    protected void onResume() {
        Log.d("Lifecycle", "GoodLifeCycleActivity: onResume");
        super.onResume();

        //allow the video to return from the background and resume at the same spot
        if (currentPosition != 0) {
            Log.d("Lifecycle", "CURRENT POS NOT ZERO");
            videoView.seekTo(currentPosition);
        }
        videoView.resume();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Log.d("Lifecycle", "GoodLifeCycleActivity: onSaveInstanceState");
        super.onSaveInstanceState(outState);
        //save the current position of the video
        outState.putInt("currentPosition", videoView.getCurrentPosition());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d("Lifecycle", "GoodLifeCycleActivity: onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        //reload the video at the last saved position
        videoView.seekTo(savedInstanceState.getInt("currentPosition", 0 ));
    }

}




