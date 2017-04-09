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

    public static int[] doSelectionSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[index])
                    index = j;

            int smallerNumber = arr[index];
            arr[index] = arr[i];
            arr[i] = smallerNumber;
        }
        return arr;
    }


    /**
     * checking for royal flush - same suit 5 cards with ACE, KING, QUEEN, JACK, 10;
     * @return
     */
    public int royalFlush() {
        // checking if the cards are in the same suit or flush
        int i = flush();
        int counter=0;

        // checking for flush
        if (i==1)
        {
            // iterating through cards for checking royal
            for (int j = 0; j < cards.length; j++) {
                if (
                                cards[j].getFace().equalsIgnoreCase("Ace") ||
                                cards[j].getFace().equalsIgnoreCase("King") ||
                                cards[j].getFace().equalsIgnoreCase("Queen") ||
                                cards[j].getFace().equalsIgnoreCase("Jack") ||
                                cards[j].getFace().equalsIgnoreCase("10"))
                {
                    counter = counter + 1;
                    if (counter ==cards.length){
                        return 1;
                    }
                }
            }
        }
        return 0;
    }


    /**
     * checking for flush - same suit 5 cards
     * @return
     */
    public int flush() {
        for (int counter = 1; counter < cards.length; counter++) {
            if (!cards[0].getSuit().equalsIgnoreCase(cards[counter].getSuit())) {
                return 0;
            }
        }
        return 1;
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
        int counter = 0;
       for (int i = 0; i<cards.length-1; i++){
           if (cards[i].getSuit().equalsIgnoreCase(cards[i+1].getSuit())){
               counter++;
           }
       }
       if (counter==4){
           return 1;
       }
       else {
           return 0;
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
