package com.example.simpletask.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.simpletask.model.LoginRequest;
import com.example.simpletask.model.User;
import com.example.simpletask.pojo.ApiService;
import com.example.simpletask.model.LoginResponse;
import com.example.simpletask.R;
import com.example.simpletask.pojo.RetrofitClient;

import java.util.HashMap;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText usernameField, passwordField;
    private Button loginButton;
    //    private ProgressBar progressBar;
    private static LoginRequest loginRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initializeViews();
        loginButton.setOnClickListener(v -> authenticateUser());
    }

    private void initializeViews() {
        usernameField = findViewById(R.id.username);
        passwordField = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
//        progressBar = findViewById(R.id.progressBar);
    }

    private void authenticateUser() {
        String username = usernameField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Username and password are required", Toast.LENGTH_SHORT).show();
            return;
        }

//        showLoading(true);

        loginRequest = new LoginRequest();
        loginRequest.setJ_password(username);
        loginRequest.setJ_password(password);
        ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
        Call<LoginResponse> call = apiService.authenticate(username,password);

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                showLoading(false);
                if (response.isSuccessful() && response.body() != null) {
                    handleLoginSuccess(response.body());
                } else {
                    showLoginError("Invalid login credentials");
                }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
//                showLoading(false);
                showLoginError("Error: " + t.getMessage());
            }
        });
    }

    private void handleLoginSuccess(@NonNull LoginResponse loginResponse) {
        User userName = loginResponse.getUser();
        if (loginResponse.getAuth().equals("true")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            intent.putExtra("userName", userName.getFullName());
            Log.d(TAG, "UserName" + userName.getFullName());
            startActivity(intent);
            finish();
        } else {
            showLoginError("User not recognized");
        }
    }

    private void showLoginError(String message) {
        Log.e(TAG, message);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showLoading(boolean isLoading) {
//        progressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        loginButton.setEnabled(!isLoading);
    }
}
