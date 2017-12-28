package com.example.hp.hologreality;

import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class OptionActivity extends AppCompatActivity {

    Button mOnline;
    Button mOffline;
    MediaPlayer mMediaPlayer;
    MediaController mMediaController;
    VideoView mVideoView;
    private final int SELECT_MUSIC = 1;
    public String pathFromUri;


    Button button1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);

        mOnline = (Button) findViewById(R.id.bOnline);
        mOffline = (Button) findViewById(R.id.bOffline);
        //Creating MediaController


        mOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, SELECT_MUSIC);
                Log.d("showdata1", intent.toString());
            }
        });
        mOnline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OptionActivity.this, ActivityOnline.class);
                startActivity(intent);

            }
        });

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_MUSIC) {
                Uri selectedMusicUri = data.getData();
                if (selectedMusicUri != null) {
                    pathFromUri = getRealPathFromURI(this, selectedMusicUri);
                    Intent intent = new Intent(OptionActivity.this, ActivityOffline.class);
                    intent.putExtra("path",pathFromUri);
                    startActivity(intent);
//
//                    if(mMediaController== null) {
//                        mMediaController = new MediaController(OptionActivity.this);
//                        mMediaController.setAnchorView(mVideoView);
//                        mVideoView.setMediaController(mMediaController);
//                        mVideoView.setVideoPath(pathFromUri);
//                        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                            @Override
//                            public void onPrepared(MediaPlayer mp) {
//                                mp.setLooping(true);
//                                mVideoView.start();
//                            }
//                        });
//                    }
//                    MediaPlayer mp = new MediaPlayer();
//                    try {
//                        mp.setDataSource(this, Uri.parse(pathFromUri));
//                        mp.prepare();
//                        mp.start();
//
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        }
    }

    private String getRealPathFromURI(Context context, Uri contentUri) {
        String[] projection = {MediaStore.Audio.Media.DATA};
        CursorLoader loader = new CursorLoader(context, contentUri, projection, null, null, null);
        Cursor cursor = loader.loadInBackground();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }


}
