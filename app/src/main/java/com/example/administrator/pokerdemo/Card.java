package com.example.administrator.pokerdemo;

/**
 * Created by Administrator on 4/1/2017.
 */

public class Card {
    private String face;
    private String suit;

    //two-argument constructor initializes Cards face and suit
    public Card(String face, String suit) {
        super();
        if (face.equalsIgnoreCase("14")) {
            this.face = "Ace";
        }
        if (face.equalsIgnoreCase("13")) {
            this.face = "King";
        }
        if (face.equalsIgnoreCase("12")) {
            this.face = "Queen";
        }
        if (face.equalsIgnoreCase("11")) {
            this.face = "Jack";
        }
        else {
            this.face = face;
        }
        this.suit = suit;
    }

    //getter method to return the face value
    public String getFace() {
        return face;
    }

    //setter method to initialize the face
    public void setFace(String face) {
        this.face = face;
    }

    //getter method to return the suit value
    public String getSuit() {
        return suit;
    }

    //setter method to initialize the suit
    public void setSuit(String suit) {
        this.suit = suit;
    }

    //return String representation of Card object
    public String toString() {
        return face + " of " + suit;
    }
}
