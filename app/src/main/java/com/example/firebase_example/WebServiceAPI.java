package com.example.firebase_example;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;




public interface WebServiceAPI {

    @POST("api/fireBaseTokens")
    Call<String> postFireBaseToken(@Body FireBaseRequest fireBaseToken);

}
