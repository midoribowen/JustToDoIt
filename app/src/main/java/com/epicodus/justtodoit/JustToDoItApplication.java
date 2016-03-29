package com.epicodus.justtodoit;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Guest on 3/29/16.
 */
public class JustToDoItApplication extends Application {
    private static JustToDoItApplication app;
    private Firebase mFirebaseRef;

    public static JustToDoItApplication getAppInstance() {
        return app;
    }

    public Firebase getmFirebaseRef() {
        return mFirebaseRef;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Firebase.setAndroidContext(this);
        mFirebaseRef = new Firebase(this.getString(R.string.firebase_url));
    }
}
