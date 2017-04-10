package com.example.administrator.pokerdemo;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 4/1/2017.
 */

public class Game {
    private Player[] players;
    private Deck deck;
    Context context;

    //constructor initializes the deck and cards
    public Game(Context context, int deal_hands) {
        this.context = context;
        deck = new Deck(context);
        players = new Player[deal_hands];
        for (int i = 0; i < deal_hands; i++) {
            players[i] = new Player();
        }
        deck.shuffle(0);
    }

    //deals the card to each player
    public void dealCards() {
        int count = 0;
        for (int i = 0; i < players[0].getCards().length; i++) {
            for (int j = 0; j < players.length; j++) {
                players[j].setCardAtIndex(deck.getCard(count++), i);
            }
        }
    }

    //simulates the game and shows the result
    public void showCards() {
        TextView txtView = (TextView) ((MainActivity) context).findViewById(R.id.deal_text);
        txtView.setText(null);
        txtView.setMovementMethod(new ScrollingMovementMethod());
        txtView.scrollTo(0, 0);

        for (int i = 0; i < players.length; i++) {
            txtView.append("Player " + (i + 1) + ": ");
            txtView.append("\n");
            txtView.append("-------------------------");
            for (int j = 0; j < players[0].getCards().length; j++) {
                txtView.append("\ncard :" + " " + players[i].getCardAtIndex(j).toString() + "\n ");
            }

            if (players[i].royalFlush() == 1) {
                txtView.append("\nResult: Royal Flush");
            } else if (players[i].straightFlush() == 1) {
                txtView.append("\nResult: FLUSH!!\n");
            } else if (players[i].fourOfaKind() == 1) {
                txtView.append("\nResult: Four of a kind!!\n");
            } else if (players[i].fullHouse() == 1) {
                txtView.append("\nResult: Full House!!\n");
            } else if (players[i].flush() == 1) {
                txtView.append("\nResult: Flush!!\n");
            } else if (players[i].straight() == 1) {
                txtView.append("\nResult: Straight!!\n");
            } else if (players[i].threeofakind() == 1) {
                txtView.append("\nResult: Three of a kind!!\n");
            } else if (players[i].twoPairs() == 1) {
                txtView.append("\nResult: Two pairs!!\n");
            } else if (players[i].pair() == 1) {
                txtView.append("\nResult: Pair!!\n");
            } else if (players[i].highCard() != 0) {
                if (players[i].highCard() == 14) {
                    txtView.append("\nHighest Card:" + " Ace");
                } else if (players[i].highCard() == 13) {
                    txtView.append("\nHighest Card:" + " King");
                } else if (players[i].highCard() == 12) {
                    txtView.append("\nHighest Card:" + " Queen");
                } else if (players[i].highCard() == 11) {
                    txtView.append("\nHighest Card:" + " Jack");
                } else
                    txtView.append("\nHighest Card: " + players[i].highCard());
            }


            txtView.append("\n");
            txtView.append("\n");
        }
        Toast.makeText(context, "Deal! Please scroll text view to see full result", Toast.LENGTH_LONG).show();
    }
}
