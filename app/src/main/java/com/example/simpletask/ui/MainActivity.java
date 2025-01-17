package com.example.simpletask.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.simpletask.pojo.ApiService;
import com.example.simpletask.R;
import com.example.simpletask.pojo.RetrofitClient;
import com.example.simpletask.model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public class TasksActivity extends AppCompatActivity {
        private RecyclerView recyclerView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            recyclerView = findViewById(R.id.recycleView);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            String token = getIntent().getStringExtra("token");
            fetchTasks(token);
        }

        private void fetchTasks(String token) {
            ApiService apiService = RetrofitClient.getInstance().create(ApiService.class);
            Call<List<Task>> call = apiService.getTasks();

            call.enqueue(new Callback<List<Task>>() {
                @Override
                public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        TaskAdapter adapter = new TaskAdapter(response.body());
                        recyclerView.setAdapter(adapter);
                    }
                }

                @Override
                public void onFailure(Call<List<Task>> call, Throwable t) {
                    Toast.makeText(TasksActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}