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

    @POST("rest/service/auth")
    Call<LoginResponse> authenticate(
            @Query("j_username") String username,
            @Query("j_password") String password
    );

    @POST("tasks/16-06-2021/16-06-2021")
    Call<List<Task>> getTasks();
}
