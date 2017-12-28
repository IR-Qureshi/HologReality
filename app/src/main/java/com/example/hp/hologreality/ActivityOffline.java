package com.example.hp.hologreality;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class ActivityOffline extends AppCompatActivity {

    VideoView video1;
    VideoView video2;
    VideoView video3;
    VideoView video4;
    Button mOnline;
    Button mOffline;
    MediaPlayer mMediaPlayer;
    MediaController mMediaController;
    VideoView mVideoView;
    private final int SELECT_MUSIC = 1;
    public String mPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offline);

        video1 = (VideoView) findViewById(R.id.vp1);
        video2 = (VideoView) findViewById(R.id.vp2);
        video3 = (VideoView) findViewById(R.id.vp3);
        video4 = (VideoView) findViewById(R.id.vp4);
        mPath = getIntent().getStringExtra("path");


        if(mMediaController== null) {
            mMediaController = new MediaController(ActivityOffline.this);
            mMediaController.setAnchorView(video1);
            mMediaController.setAnchorView(video2);
            mMediaController.setAnchorView(video3);
            mMediaController.setAnchorView(video4);

            video1.setMediaController(mMediaController);
            video2.setMediaController(mMediaController);
            video3.setMediaController(mMediaController);
            video4.setMediaController(mMediaController);


            video1.setVideoPath(mPath);
            video2.setVideoPath(mPath);
            video3.setVideoPath(mPath);
            video4.setVideoPath(mPath);

            video1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                    video1.start();
                }
            });
            video2.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                    video2.start();
                }
            });
            video3.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                    video3.start();
                }
            });
            video4.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                    video4.start();
                }
            });
        }



    }
}
