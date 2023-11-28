package com.example.login;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiService {

    @POST("authorizationLogin")
    Call<Answer> ResquestLogin (String user, String contra);

}
