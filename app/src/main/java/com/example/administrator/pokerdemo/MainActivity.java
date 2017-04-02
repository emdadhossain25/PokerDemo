package com.example.administrator.pokerdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button_deal, button_shuffle;
    Game game;
    Deck deck;
    int deal_hands;

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

                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("DEAL HANDS");
                alertDialog.setMessage("Enter Deal Hands (2-5)");

                final EditText input = new EditText(MainActivity.this);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input);


                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                try {
                                    deal_hands = Integer.parseInt(input.getText().toString());
                                    if (deal_hands >= 2 && deal_hands <= 5) {
                                        game = new Game(MainActivity.this, deal_hands);
                                        game.dealCards();
                                        game.showCards();
                                    } else {
                                        Toast.makeText(MainActivity.this, "Please enter value in 2-5", Toast.LENGTH_LONG).show();
                                    }
                                } catch (Exception e){
                                    Toast.makeText(MainActivity.this, "Please enter value in 2-5", Toast.LENGTH_LONG).show();
                                    e.printStackTrace();
                                }
                                }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        });

                alertDialog.show();

            }
        });

        button_shuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deck = new Deck(MainActivity.this);
                deck.shuffle(1);
                Log.e("button_shuffle","button_shuffle");

            }
        });



    }
}
