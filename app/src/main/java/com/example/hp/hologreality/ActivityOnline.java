package com.example.hp.hologreality;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.vidyo.VidyoClient.Connector.Connector;
import com.vidyo.VidyoClient.Connector.ConnectorPkg;


public class ActivityOnline extends AppCompatActivity implements Connector.IConnect {

    private Connector vc;
    private Connector vc2;
    private Connector vc3;
    private Connector vc4;

    private FrameLayout videoFrame;
    private FrameLayout videoFrame2;
    private FrameLayout videoFrame3;
    private FrameLayout videoFrame4;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);

        ConnectorPkg.setApplicationUIContext(this);
        ConnectorPkg.initialize();

        videoFrame = (FrameLayout) findViewById(R.id.videoFrame1);
        videoFrame2 = (FrameLayout) findViewById(R.id.videoFrame2);
        videoFrame3 = (FrameLayout) findViewById(R.id.videoFrame3);
        videoFrame4 = (FrameLayout) findViewById(R.id.videoFrame4);


    }

    public View playvideo(){

        vc = new Connector(videoFrame, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
        vc.showViewAt(videoFrame, 0, 0, videoFrame.getWidth(), videoFrame.getHeight());

        Log.d("check2", vc.toString());
        Log.d("check23", videoFrame.toString());
        return videoFrame;

    }

    public void Start(View v) {
        Log.d("check1","running first");
        Log.d("check4",playvideo().toString());
//        playvideo(videoFrame);
        playvideo();




//        playVideo(videoFrame);
//        playVideo(videoFrame2);
//        playVideo(videoFrame3);
//        playVideo(videoFrame4);


//        vc = new Connector(videoFrame, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
//        vc = new Connector(videoFrame2, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
//        vc = new Connector(videoFrame3, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
//        vc = new Connector(videoFrame4, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
//
//        vc.showViewAt(videoFrame, 0, 0, videoFrame.getWidth(), videoFrame.getHeight());
//        vc.showViewAt(videoFrame2, 0, 0, videoFrame2.getWidth(), videoFrame2.getHeight());
//        vc.showViewAt(videoFrame3, 0, 0, videoFrame3.getWidth(), videoFrame3.getHeight());
//        vc.showViewAt(videoFrame, 0, 0, videoFrame.getWidth(), videoFrame.getHeight());




//
//        Log.d("check2","running second");
//        vc2 = new Connector(videoFrame2, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
//        vc2.showViewAt(videoFrame2, 0, 0, videoFrame2.getWidth(), videoFrame2.getHeight());
//        Log.d("check2","runned second");
//
//        Log.d("check3","running third");
//        vc3 = new Connector(videoFrame3, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
//        vc3.showViewAt(videoFrame3, 0, 0, videoFrame3.getWidth(), videoFrame3.getHeight());
//        Log.d("check3","runned third");
//
//        Log.d("check4", "running forth");
//        vc4 = new Connector(videoFrame4, Connector.ConnectorViewStyle.VIDYO_CONNECTORVIEWSTYLE_Default, 15, "warning info@VidyoClient info@VidyoConnector", "", 0);
//        vc4.showViewAt(videoFrame4, 0, 0, videoFrame4.getWidth(), videoFrame4.getHeight());
//        Log.d("check4", "runned forth");
    }

    public void Connect(View v) {
        String token = "cHJvdmlzaW9uAERlZmF1bHRBcHBsaWNhdGlvbkAwYjAyMjAudmlkeW8uaW8ANjM2ODE0NTA1ODAAADVjNDVkMjNjYTkwYzIzNjc1MThlMTI4YTZhYWU5ZWYyNzkyZmUwZjY1ZDMxNzI0MWYzNjZhMjUyNGZhYjViODJkZmRiMTcwN2QwMjc1ZDRjNDg3ZjRiMzljNWZlOGQxNQ==";
        vc.connect("prod.vidyo.io", token, "DemoUser", "DemoRoom", ActivityOnline.this);
//        vc2.connect("prod.vidyo.io", token, "DemoUser", "DemoRoom", ActivityOnline.this);
//        vc3.connect("prod.vidyo.io", token, "DemoUser", "DemoRoom", ActivityOnline.this);
//        vc4.connect("prod.vidyo.io", token, "DemoUser", "DemoRoom", ActivityOnline.this);
    }

    public void Disconnect(View v) {
        vc.disconnect();
    }

    /*
     *  Connector Events
     */

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFailure(Connector.ConnectorFailReason connectorFailReason) {

    }

    @Override
    public void onDisconnected(Connector.ConnectorDisconnectReason connectorDisconnectReason) {

    }
}
