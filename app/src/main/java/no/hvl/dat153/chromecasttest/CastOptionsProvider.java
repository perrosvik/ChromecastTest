package no.hvl.dat153.chromecasttest;

import android.content.Context;

import com.google.android.gms.cast.*;

import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.OptionsProvider;
import com.google.android.gms.cast.framework.SessionProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pmr on 14.02.18.
 */

public class CastOptionsProvider implements OptionsProvider {

    public static final String CUSTOM_NAMESPACE = "urn:x-cast:custom_namespace";

    @Override
    public CastOptions getCastOptions(Context context) {

        List<String> supportedNamespaces = new ArrayList<>();
        supportedNamespaces.add(CUSTOM_NAMESPACE);

        CastOptions castOptions = new CastOptions.Builder()
                .setReceiverApplicationId(CastMediaControlIntent.DEFAULT_MEDIA_RECEIVER_APPLICATION_ID)
                .build();
        return castOptions;
    }

    @Override
    public List<SessionProvider> getAdditionalSessionProviders(Context context) {
        return null;
    }
}