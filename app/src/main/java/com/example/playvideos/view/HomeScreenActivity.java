package com.example.playvideos.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.playvideos.R;
import com.example.playvideos.adapter.VideosAdapter;
import com.example.playvideos.api.ApiClient;
import com.example.playvideos.api.ApiInterface;
import com.example.playvideos.model.PlayVideosObj;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeScreenActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    public static final String TAG = "HomeScreenActivity";
    private RecyclerView recyclerView;
    private VideosAdapter mAdapter;
    private List<PlayVideosObj> videosList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        recyclerView = findViewById(R.id.my_recycler_view);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<List<PlayVideosObj>> call = apiInterface.getVideosList("pretty");
        call.enqueue(new Callback<List<PlayVideosObj>>() {
            @Override
            public void onResponse(Call<List<PlayVideosObj>> call, Response<List<PlayVideosObj>> response) {
                Log.d(TAG,response.body().size()+"");
                videosList = response.body();
                mAdapter = new VideosAdapter(HomeScreenActivity.this,videosList);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerView.setLayoutManager(mLayoutManager);
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<PlayVideosObj>> call, Throwable t) {
                Log.d(TAG,"failed");
            }
        });
    }
}
