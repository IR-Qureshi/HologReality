package com.example.hp.hologreality;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.teamviewer.sdk.screensharing.api.TVConfigurationID;
import com.teamviewer.sdk.screensharing.api.TVCreationError;
import com.teamviewer.sdk.screensharing.api.TVSession;
import com.teamviewer.sdk.screensharing.api.TVSessionCallback;
import com.teamviewer.sdk.screensharing.api.TVSessionCode;
import com.teamviewer.sdk.screensharing.api.TVSessionConfiguration;
import com.teamviewer.sdk.screensharing.api.TVSessionCreationCallback;
import com.teamviewer.sdk.screensharing.api.TVSessionError;
import com.teamviewer.sdk.screensharing.api.TVSessionFactory;

public class MainActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final TVSessionConfiguration config =
//                new TVSessionConfiguration.Builder(
//                        new TVConfigurationID("fmmx4cf"))
//                        .setServiceCaseName("Conferencing")
//                        .setServiceCaseDescription("For video conferencing via hologram")
//                        .build();
//
//        TVSessionFactory.createTVSession(this, "YOUR_SDK_TOKEN",
//                new TVSessionCreationCallback() {
//                    @Override
//                    public void onTVSessionCreationSuccess(TVSession session) {
//                        session.start(config);
//                    }
//
//                    @Override
//                    public void onTVSessionCreationFailed(TVCreationError error) {
//                    }
//                });
//
//        session.setTVSessionCallback(new TVSessionCallback() {
//            @Override
//            public void onTVSessionError(TVSessionError error) {
//                // React to session errors
//            }
//
//            @Override
//            public void onTVSessionEnd() {
//                // React to the session ending
//            }
//        });


         /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}
