package com.example.firebase_example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FirebaseTokenAPI {
    private Retrofit retrofit;
    private WebServiceAPI webServiceAPI;

    public FirebaseTokenAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(MyApplication.context.getString(R.string.BaseUrl))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        webServiceAPI = retrofit.create(WebServiceAPI.class);
    }

    public void postFirebaseToken(String firebaseToken, String username) {
        FireBaseRequest fireBaseRequest = new FireBaseRequest(firebaseToken, username);
        Call<String> call = webServiceAPI.postFireBaseToken(fireBaseRequest);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String result = response.body();
                    // Handle successful response
                } else {
                    // Handle error response
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // Handle network failure
            }
        });
    }
}
