package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    // Initalizes
    @Override
    public void onCreate() {
        super.onCreate();

        // Register your parse models
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("FixCehDmIOkTk5XLEnMfvhUqmqJuowoh0IXSLX0D")
                .clientKey("Q5blfs0uzCz9uYZpF3DLBJI23wyTOOtlrsav4joC")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
