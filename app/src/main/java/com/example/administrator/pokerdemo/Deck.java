package com.example.administrator.pokerdemo;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Random;

/**
 * Created by Administrator on 4/1/2017.
 */

public class Deck {
    Context context;
    private final String faces[] = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private final String suits[]={"Hearts","Diamonds","Clubs","Spades"};
    private Card deck[];
    private final int TOTAL_CARDS=52;
    private Random randNum;
    //no-argument constructor fills the deck of cards
    public Deck(Context context){
        this.context = context;
        deck = new Card[TOTAL_CARDS];
        randNum = new Random();
        for(int i=0;i<deck.length;i++){
            deck[i] = new Card(faces[i%13],suits[i/13]);
        }
    }

    //shuffles the deck
    public void shuffle(int s){
        // setting the text view for shuffle text
        TextView txtView = (TextView) ((MainActivity)context).findViewById(R.id.shuffle_text);
        txtView.setText(null);
        txtView.setMovementMethod(new ScrollingMovementMethod());
        txtView.scrollTo(0,0);

        //operating
        for(int i=0;i<deck.length;i++){
            int j = randNum.nextInt(TOTAL_CARDS);
            Card c = deck[i];
            deck[i] = deck[j];
            deck[j] = c;
        }

        for (int k = 0;k<deck.length;k++){
            txtView.append(deck[k].getFace()+deck[k].getSuit()+ "\n");

        }
        if(s==1){
        Toast.makeText(context,"Shuffle done! Please scroll down to view full deck.",Toast.LENGTH_LONG).show();
        }
    }

    //returns the individual card in the deck
    public Card getCard(int index){
        return deck[index];
    }
}
