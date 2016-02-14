package com.example.mohamed.attendence;

import android.app.Application;
import com.parse.Parse;

/**
 * Created by Mohamed on 12/15/2015.
 */
public class attendenceApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // [Optional] Power your app with Local Datastore. For more info, go to
        // https://parse.com/docs/android/guide#local-datastore
        Parse.enableLocalDatastore(this);

        Parse.initialize(this);
    }
}