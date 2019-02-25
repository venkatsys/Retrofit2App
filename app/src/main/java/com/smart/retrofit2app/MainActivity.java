package com.smart.retrofit2app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.smart.retrofit2app.http.TwitchAPI;
import com.smart.retrofit2app.http.apimodel.Top;
import com.smart.retrofit2app.http.apimodel.Twitch;
import com.smart.retrofit2app.root.App;

import java.time.Clock;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Inject
    TwitchAPI twitchAPI;

    private static final String CLIENT_ID = "c333tqqyfmsdjd46o8jegvkvls6uha";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        Call<Twitch> call = twitchAPI.getTopGames(CLIENT_ID);

        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                List<Top> gameList = response.body().getTop();

                for (Top top : gameList){
                    System.out.println(top.getGame().getName());
                }
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
