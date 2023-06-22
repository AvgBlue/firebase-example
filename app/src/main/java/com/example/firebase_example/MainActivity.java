package com.example.firebase_example;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.e("FCM Token", "Fetching FCM registration token failed", task.getException());
                    return;
                }

                // Get the FCM registration token
                String token = task.getResult();

                // Log the token
                Log.d("FCM Token", token);

                // You can now use the token to send push notifications to this device
            }
        });

        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        Task<String> getTokenTask = firebaseMessaging.getToken();

        getTokenTask.addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.e("FCM Token", "Fetching FCM registration token failed", task.getException());
                    return;
                }

                // Get the FCM registration token
                String token = task.getResult();

                // Log the token
                Log.d("FCM Token", token);

                // You can now use the token to send push notifications to this device
            }
        });


    }
}