package com.example.administrator.pokerdemo;

/**
 * Created by Administrator on 4/1/2017.
 */

public class Player {
    public final static int MAX_CARD = 5;
    private Card cards[];

    //constructor initializes 5 cards in each hand
    public Player() {
        cards = new Card[MAX_CARD];
    }

    //returns all the cards in hand
    public Card[] getCards() {
        return cards;
    }

    //get the cards at a particular position
    public Card getCardAtIndex(int index) {
        if (index >= 0 && index < MAX_CARD)
            return cards[index];
        else
            return null;
    }

    //sets the card at particular position
    public void setCardAtIndex(Card c, int index) {
        if (index >= 0 && index < MAX_CARD)
            cards[index] = c;
    }

    // check for royal flush
    public int royalFlush() {
        if (cards[0].getFace().equalsIgnoreCase("Ace") &&
                cards[1].getFace().equalsIgnoreCase("10") &&
                cards[2].getFace().equalsIgnoreCase("Jack") &&
                cards[3].getFace().equalsIgnoreCase("Queen") &&
                cards[4].getFace().equalsIgnoreCase("King")) {
            return 1;
        } else {
            return 0;
        }
    }

    // straight flush method
    public int straightFlush() {
        for (int counter = 1; counter < 5; counter++) {
            if (!cards[0].getSuit().equalsIgnoreCase(cards[counter].getSuit())) {
                return 0;
            }
        }
        for (int counter2 = 1; counter2 < 5; counter2++) {
            if (!cards[counter2 - 1].getFace().equalsIgnoreCase(cards[counter2].getFace())) {
                return 0;
            }

        }
        return 1;
    }

    // four of a kind method
    public int fourOfaKind() {
        if (!cards[0].getFace().equalsIgnoreCase(cards[3].getFace()) && !cards[1].getFace().equalsIgnoreCase(cards[4].getFace())) {
            return 0;
        } else {
            return 1;
        }
    }

    // full house
    public int fullHouse() {
        int comparison = 0;
        for (int counter = 1; counter < 5; counter++) {
            if (cards[counter - 1].getFace().equalsIgnoreCase(cards[counter].getFace())) {
                comparison++;
            }
        }
        if (comparison == 3) {
            return 1;
        } else {
            return 0;
        }
    }

    // checks for flush
    public int flush() {
        for (int counter = 1; counter < 5; counter++) {
            if (!cards[0].getSuit().equalsIgnoreCase(cards[counter].getSuit())) {
                return 0;
            }
        }
        return 1;
    }

    // check for straight
    public int straight() {
        for (int counter2 = 1; counter2 < 5; counter2++) {
            if (!cards[counter2 - 1].getFace().equalsIgnoreCase(cards[counter2].getFace())) {
                return 0;
            }

        }
        return 1;
    }

    public int twoPairs() {
        int check = 0;
        for (int counter = 1; counter < 5; counter++) {
            if (cards[counter - 1].getFace().equalsIgnoreCase(cards[counter].getFace())) {
                check++;
            }
        }
        if (check == 2) {
            return 1;
        } else {
            return 0;
        }
    }

    // check for pair
    public int pair() {
        int check = 0;
        for (int counter = 1; counter < 5; counter++) {
            if (cards[counter - 1].getFace().equalsIgnoreCase(cards[counter].getFace())) {
                check++;
            }
        }
        if (check == 1) {
            return 1;
        } else {
            return 0;
        }
    }


    public int triple() {
        if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace()) && cards[2].getFace().equalsIgnoreCase(cards[4].getFace())) {
            return 1;
        }
        return 0;
    }

    // find the highest card
    public int highCard() {
        int highCard = 0;

        for (int counter = 0; counter < 5; counter++) {
            if (cards[counter].getFace().equalsIgnoreCase("Ace")){
                cards[counter].setFace("14");
            }
            else if (cards[counter].getFace().equalsIgnoreCase("King")){
                cards[counter].setFace("13");
            }
            else if (cards[counter].getFace().equalsIgnoreCase("Queen")){
                cards[counter].setFace("12");
            }
            else if (cards[counter].getFace().equalsIgnoreCase("Jack")){
                cards[counter].setFace("11");
            }

            if (Integer.parseInt(cards[counter].getFace()) > highCard) {
                highCard = Integer.parseInt(cards[counter].getFace());
            }
        }
        return highCard;
    }
}
