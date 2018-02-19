package no.hvl.dat153.chromecasttest;

import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.MediaRouteButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.images.WebImage;

public class MainActivity extends AppCompatActivity {

    private MediaRouteButton mMediaRouteButton;
    private CastContext mCastContext;
    private CastSession mCastSession;

    private MediaInfo mSelectedMedia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaRouteButton = (MediaRouteButton) findViewById(R.id.media_route_button);
        CastButtonFactory.setUpMediaRouteButton(getApplicationContext(), mMediaRouteButton);

        mCastContext = CastContext.getSharedInstance(this);

        final Button btn_video = findViewById(R.id.btn_video);
        btn_video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCastSession = mCastContext.getSessionManager().getCurrentCastSession();
                loadRemoteMedia(true);
            }
        });
    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        CastButtonFactory.setUpMediaRouteButton(getApplicationContext(),
                menu,
                R.id.media_route_menu_item);
        return true;
    }


    private void loadRemoteMedia(boolean autoPlay){
        if (mCastSession == null) {
            return;
        }
        RemoteMediaClient remoteMediaClient = mCastSession.getRemoteMediaClient();
        if (remoteMediaClient == null) {
            return;
        }
        //remoteMediaClient.load(buildMediaInfo(), autoPlay, position);

       /* MediaMetadata mediaMetadata = new MediaMetadata(MediaMetadata.MEDIA_TYPE_MOVIE);
        mediaMetadata.putString(MediaMetadata.KEY_TITLE, "Title goes here");
        MediaInfo mi = new MediaInfo.Builder("https://www.youtube.com/watch?v=Dgxz0kZ2dp4")
                .setStreamType(MediaInfo.STREAM_TYPE_BUFFERED)
                .setContentType("video/*")
                .setMetadata(mediaMetadata)
                .build();
        remoteMediaClient.load(mi,autoPlay, 0); */

        MediaMetadata mediaMetadata = new MediaMetadata(MediaMetadata.MEDIA_TYPE_PHOTO);
        mediaMetadata.putString(MediaMetadata.KEY_TITLE, "Title goes here");
        MediaInfo mi = new MediaInfo.Builder("https://lh3.googleusercontent.com/dYPQ5rDjvDTS0fJ4GilwnIKzyrILy1cUQdNJOA9szbevGB97PB7ThJGDCzUswPcNrc2g0BGVZSxXk51oA2K4ck39v6sZJb4YkNDbA_kaOvADftHJWpXOLn8QbKQDuGAAOCYtmKbgNudCgxpwdQXWcbM4CpRqdHZozQ3KudNux5babpkPEkCk0aBgcQPhWswhPyVeauU7KnBy8iESSM1tVFHYkMtTT2AXZmM1L01ouOyCiYkXAcJvnugMsLnT2Y9LXg2Bjr-AUOw-zMQWX7zPyL9VdMHTXwO2d3gTg5zkiJRJhDyD8bHjsJeZRkG5qGz0GN0CKOYRL2grFNFtaZpDshUinXX5DPlfoiVi39xyaIGJj2K8-36_CrZWpEKLIHvuMgEIoXAg4GfUmHeAQDgIbBGvo-_FUf1Pb-NS5i8sHPzU4ckPOJUyh2AwVaMqQzMLZx2VkKrve0i3vbKOCAXQzWMQQunS2kki6mJDBo_Yg9ZSJnVXuksDDiPHVVZG3LCYzCJpzzcfmf9HO9QUjoVI98O82uz3a9YV6cFe4iGX_XcaUqvT6zp3SgIaa3_zWwxCnMe-tGYAtP9m36ZZOgSuCXxd1dejqlILmgxt-TC0=w636-h848-no")
                .setStreamType(MediaInfo.STREAM_TYPE_NONE)
                .setContentType("image/jpeg")
                .setMetadata(mediaMetadata)
                .build();
        remoteMediaClient.load(mi,autoPlay, 0);
    }
}
