package com.example.androidlifecycle;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;


public class BadLifecycleActivity extends AppCompatActivity {


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
        Log.d("Lifecycle", "BadLifeCycleActivity: onStart");
        super.onStart();
        videoView.start(); // Start the video when the activity starts
    }

    @Override
    protected void onDestroy() {
        Log.d("Lifecycle", "BadLifeCycleActivity: onDestroy");
        super.onDestroy();
        videoView.stopPlayback(); // Stop the video playback and release resources
    }

}



/*
Problems:
- No implementation for pausing/resuming the video
- need to suspend the video onStop since the view is in the background
- need to be able to pause/resume the video
- Also causes the video to restart when the phone orientation changes since the bundle
will not contain the video timestamp
 */