package com.example.simpletask.pojo;

import com.example.simpletask.model.LoginRequest;
import com.example.simpletask.model.LoginResponse;
import com.example.simpletask.model.Task;
import com.example.simpletask.model.User;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @POST("auth")
    Call<LoginResponse> authenticate(
            @Body LoginRequest loginRequest
    );

//    @FormUrlEncoded
//    @POST("auth?")
//    Call<LoginResponse> authenticate(@Body HashMap<Object,Object> map);

    @GET("tasks/16-06-2021/16-06-2021")
    Call<List<Task>> getTasks();
}
