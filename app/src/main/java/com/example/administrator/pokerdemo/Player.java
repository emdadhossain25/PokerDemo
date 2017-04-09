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

    public static int[] doSelectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
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
     * checking for royal flush - same suit 5 cards with {ACE, KING, QUEEN, JACK, 10};
     *
     * @return
     */
    public int royalFlush() {
        // checking if the cards are in the same suit or flush
        int i = flush();
        int counter = 0;

        // checking for flush
        if (i == 1) {
            // iterating through cards for checking royal
            for (int j = 0; j < cards.length; j++) {
                if (
                        (cards[j].getFace().equalsIgnoreCase("9")) ||
                                (cards[j].getFace().equalsIgnoreCase("10")) ||
                                (cards[j].getFace().equalsIgnoreCase("Jack")) ||
                                (cards[j].getFace().equalsIgnoreCase("Queen")) ||
                                (cards[j].getFace().equalsIgnoreCase("King"))
                        ) {
                    counter = counter + 1;
                    if (counter == cards.length) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * checking  straight flush - 5 consecutive cards of same suit
     *
     * @return
     */
    public int straightFlush() {
        int i = flush();
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int counter7 = 0;
        int counter8 = 0;
        int counter9 = 0;

        if (i == 1) {
            // iterating through cards for checking straight - lowest possible straight
            for (int j = 0; j < cards.length; j++) {
                if (
                        (cards[j].getFace().equalsIgnoreCase("Ace")) ||
                                (cards[j].getFace().equalsIgnoreCase("2")) ||
                                (cards[j].getFace().equalsIgnoreCase("3")) ||
                                (cards[j].getFace().equalsIgnoreCase("4")) ||
                                (cards[j].getFace().equalsIgnoreCase("5"))) {
                    counter1 = counter1 + 1;
                    if (counter1 == cards.length) {
                        return 1;
                    }
                }
            }

            for (int j = 0; j < cards.length; j++) {
                if (
                        (cards[j].getFace().equalsIgnoreCase("2")) ||
                                (cards[j].getFace().equalsIgnoreCase("3")) ||
                                (cards[j].getFace().equalsIgnoreCase("4")) ||
                                (cards[j].getFace().equalsIgnoreCase("5")) ||
                                (cards[j].getFace().equalsIgnoreCase("6"))
                        ) {
                    counter2 = counter2 + 1;
                    if (counter2 == cards.length) {
                        return 1;
                    }
                }
            }

            for (int j = 0; j < cards.length; j++) {
                if (
                        (cards[j].getFace().equalsIgnoreCase("3")) ||
                                (cards[j].getFace().equalsIgnoreCase("4")) ||
                                (cards[j].getFace().equalsIgnoreCase("5")) ||
                                (cards[j].getFace().equalsIgnoreCase("6")) ||
                                (cards[j].getFace().equalsIgnoreCase("7"))
                        ) {
                    counter3 = counter3 + 1;
                    if (counter3 == cards.length) {
                        return 1;
                    }
                }
            }

            for (int j = 0; j < cards.length; j++) {
                if (
                        (cards[j].getFace().equalsIgnoreCase("4")) ||
                                (cards[j].getFace().equalsIgnoreCase("5")) ||
                                (cards[j].getFace().equalsIgnoreCase("6")) ||
                                (cards[j].getFace().equalsIgnoreCase("7")) ||
                                (cards[j].getFace().equalsIgnoreCase("8"))
                        ) {
                    counter4 = counter4 + 1;
                    if (counter4 == cards.length) {
                        return 1;
                    }
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("5")) ||
                            (cards[j].getFace().equalsIgnoreCase("6")) ||
                            (cards[j].getFace().equalsIgnoreCase("7")) ||
                            (cards[j].getFace().equalsIgnoreCase("8")) ||
                            (cards[j].getFace().equalsIgnoreCase("9"))
                    ) {
                counter5 = counter5 + 1;
                if (counter5 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("6")) ||
                            (cards[j].getFace().equalsIgnoreCase("7")) ||
                            (cards[j].getFace().equalsIgnoreCase("8")) ||
                            (cards[j].getFace().equalsIgnoreCase("9")) ||
                            (cards[j].getFace().equalsIgnoreCase("10"))
                    ) {
                counter6 = counter6 + 1;
                if (counter6 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("7")) ||
                            (cards[j].getFace().equalsIgnoreCase("8")) ||
                            (cards[j].getFace().equalsIgnoreCase("9")) ||
                            (cards[j].getFace().equalsIgnoreCase("10")) ||
                            (cards[j].getFace().equalsIgnoreCase("Jack"))
                    ) {
                counter7 = counter7 + 1;
                if (counter7 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("8")) ||
                            (cards[j].getFace().equalsIgnoreCase("9")) ||
                            (cards[j].getFace().equalsIgnoreCase("10")) ||
                            (cards[j].getFace().equalsIgnoreCase("Jack")) ||
                            (cards[j].getFace().equalsIgnoreCase("Queen"))
                    ) {
                counter8 = counter8 + 1;
                if (counter8 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("9")) ||
                            (cards[j].getFace().equalsIgnoreCase("10")) ||
                            (cards[j].getFace().equalsIgnoreCase("Jack")) ||
                            (cards[j].getFace().equalsIgnoreCase("Queen")) ||
                            (cards[j].getFace().equalsIgnoreCase("King"))
                    ) {
                counter9 = counter9 + 1;
                if (counter9 == cards.length) {
                    return 1;
                }
            }
        }

        return 0;
    }


    /**
     * checking for flush - same suit 5 cards
     *
     * @return
     */
    public int flush() {
        if ((cards[0].getSuit().equalsIgnoreCase(cards[1].getSuit())) &&
                (cards[0].getSuit().equalsIgnoreCase(cards[2].getSuit())) &&
                (cards[0].getSuit().equalsIgnoreCase(cards[3].getSuit())) &&
                (cards[0].getSuit().equalsIgnoreCase(cards[4].getSuit()))
                ) {
            return 1;
        }

        return 0;
    }


    // four of a kind method
    public int fourOfaKind() {
        int counter = 0;
        for (int i = 0; i < cards.length - 1; i++) {
            if (cards[i].getSuit().equalsIgnoreCase(cards[i + 1].getSuit())) {
                counter++;
            }
        }
        if (counter == 4) {
            return 1;
        } else {
            return 0;
        }

    }


    /**
     * checking straight - 5 consecutive cards
     *
     * @return
     */
    public int straight() {

        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int counter5 = 0;
        int counter6 = 0;
        int counter7 = 0;
        int counter8 = 0;
        int counter9 = 0;
        int counter10 = 0;

        // iterating through cards for checking straight - lowest possible straight


        for (int j = 0; j < cards.length; j++) {
            if (

                    (cards[j].getFace().equalsIgnoreCase("10")) ||
                            (cards[j].getFace().equalsIgnoreCase("Jack")) ||
                            (cards[j].getFace().equalsIgnoreCase("Queen")) ||
                            (cards[j].getFace().equalsIgnoreCase("King")) ||
                            (cards[j].getFace().equalsIgnoreCase("Ace"))
                    ) {
                counter10 = counter10 + 1;
                if (counter10 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("Ace")) ||
                            (cards[j].getFace().equalsIgnoreCase("2")) ||
                            (cards[j].getFace().equalsIgnoreCase("3")) ||
                            (cards[j].getFace().equalsIgnoreCase("4")) ||
                            (cards[j].getFace().equalsIgnoreCase("5"))) {
                counter1 = counter1 + 1;
                if (counter1 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("2")) ||
                            (cards[j].getFace().equalsIgnoreCase("3")) ||
                            (cards[j].getFace().equalsIgnoreCase("4")) ||
                            (cards[j].getFace().equalsIgnoreCase("5")) ||
                            (cards[j].getFace().equalsIgnoreCase("6"))
                    ) {
                counter2 = counter2 + 1;
                if (counter2 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("3")) ||
                            (cards[j].getFace().equalsIgnoreCase("4")) ||
                            (cards[j].getFace().equalsIgnoreCase("5")) ||
                            (cards[j].getFace().equalsIgnoreCase("6")) ||
                            (cards[j].getFace().equalsIgnoreCase("7"))
                    ) {
                counter3 = counter3 + 1;
                if (counter3 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("4")) ||
                            (cards[j].getFace().equalsIgnoreCase("5")) ||
                            (cards[j].getFace().equalsIgnoreCase("6")) ||
                            (cards[j].getFace().equalsIgnoreCase("7")) ||
                            (cards[j].getFace().equalsIgnoreCase("8"))
                    ) {
                counter4 = counter4 + 1;
                if (counter4 == cards.length) {
                    return 1;
                }
            }
        }


        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("5")) ||
                            (cards[j].getFace().equalsIgnoreCase("6")) ||
                            (cards[j].getFace().equalsIgnoreCase("7")) ||
                            (cards[j].getFace().equalsIgnoreCase("8")) ||
                            (cards[j].getFace().equalsIgnoreCase("9"))
                    ) {
                counter5 = counter5 + 1;
                if (counter5 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("6")) ||
                            (cards[j].getFace().equalsIgnoreCase("7")) ||
                            (cards[j].getFace().equalsIgnoreCase("8")) ||
                            (cards[j].getFace().equalsIgnoreCase("9")) ||
                            (cards[j].getFace().equalsIgnoreCase("10"))
                    ) {
                counter6 = counter6 + 1;
                if (counter6 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("7")) ||
                            (cards[j].getFace().equalsIgnoreCase("8")) ||
                            (cards[j].getFace().equalsIgnoreCase("9")) ||
                            (cards[j].getFace().equalsIgnoreCase("10")) ||
                            (cards[j].getFace().equalsIgnoreCase("Jack"))
                    ) {
                counter7 = counter7 + 1;
                if (counter7 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("8")) ||
                            (cards[j].getFace().equalsIgnoreCase("9")) ||
                            (cards[j].getFace().equalsIgnoreCase("10")) ||
                            (cards[j].getFace().equalsIgnoreCase("Jack")) ||
                            (cards[j].getFace().equalsIgnoreCase("Queen"))
                    ) {
                counter8 = counter8 + 1;
                if (counter8 == cards.length) {
                    return 1;
                }
            }
        }

        for (int j = 0; j < cards.length; j++) {
            if (
                    (cards[j].getFace().equalsIgnoreCase("9")) ||
                            (cards[j].getFace().equalsIgnoreCase("10")) ||
                            (cards[j].getFace().equalsIgnoreCase("Jack")) ||
                            (cards[j].getFace().equalsIgnoreCase("Queen")) ||
                            (cards[j].getFace().equalsIgnoreCase("King"))
                    ) {
                counter9 = counter9 + 1;
                if (counter9 == cards.length) {
                    return 1;
                }
            }
        }
        return 0;
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
            if (cards[counter].getFace().equalsIgnoreCase("Ace")) {
                cards[counter].setFace("14");
            } else if (cards[counter].getFace().equalsIgnoreCase("King")) {
                cards[counter].setFace("13");
            } else if (cards[counter].getFace().equalsIgnoreCase("Queen")) {
                cards[counter].setFace("12");
            } else if (cards[counter].getFace().equalsIgnoreCase("Jack")) {
                cards[counter].setFace("11");
            }

            if (Integer.parseInt(cards[counter].getFace()) > highCard) {
                highCard = Integer.parseInt(cards[counter].getFace());
            }
        }
        return highCard;
    }


}
