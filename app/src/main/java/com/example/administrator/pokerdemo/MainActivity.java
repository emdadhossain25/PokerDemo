package com.example.administrator.pokerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_deal, button_shuffle;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //initializing buttons instances variables/ objects;
        button_deal = (Button) findViewById(R.id.button_deal);
        button_shuffle = (Button) findViewById(R.id.button_shuffle);

        //implementing onClickListener interfaces for shuffle and deal button
        button_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("button_deal","button_deal");
                game = new Game();
                game.dealCards();
                game.showCards();

            }
        });

        button_shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("button_shuffle","button_shuffle");

            }
        });



    }
}
