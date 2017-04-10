package com.example.administrator.pokerdemo;

import android.util.Log;

/**
 * Created by Administrator on 4/1/2017.
 */

public class Player {
    public final static int MAX_CARD = 5;
    private Card cards[];
    int i;
    Integer[] cards_int_array;

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

    /**
     * Royal flush- same suit A, 10, K,Q,J
     */
    public int royalFlush() {
        i = 0;
        i = flush();

        for (int counter = 0; counter < cards.length; counter++) {

            if (cards[counter].getFace().equalsIgnoreCase("Ace")) {
                cards[counter].setFace("14");
            } else if (cards[counter].getFace().equalsIgnoreCase("King")) {
                cards[counter].setFace("13");
            } else if (cards[counter].getFace().equalsIgnoreCase("Queen")) {
                cards[counter].setFace("12");
            } else if (cards[counter].getFace().equalsIgnoreCase("Jack")) {
                cards[counter].setFace("11");
            }
        }

        if (i == 1) {
            cards_int_array = processLine(cards);
            cards_int_array = doSelection(cards_int_array);
             if (cards_int_array[4] == 14) {
                    if (cards_int_array[0] == 10) {
                        if (cards_int_array[1] == 11) {
                            if (cards_int_array[2] == 12) {
                                if (cards_int_array[3] == 13) {

                                    // highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                }

        }
        return 0;
    }

    /**
     * straight flush
     */
    public int straightFlush(){


        for (int counter = 0; counter < cards.length; counter++) {

            if (cards[counter].getFace().equalsIgnoreCase("Ace")) {
                cards[counter].setFace("14");
            } else if (cards[counter].getFace().equalsIgnoreCase("King")) {
                cards[counter].setFace("13");
            } else if (cards[counter].getFace().equalsIgnoreCase("Queen")) {
                cards[counter].setFace("12");
            } else if (cards[counter].getFace().equalsIgnoreCase("Jack")) {
                cards[counter].setFace("11");
            }
        }
        if (flush() == 1) {
            if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
                return 0;
            } else if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                return 0;
            } else if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                return 0;
            } else if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                return 0;
            } else if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())) {
                return 0;
            } else if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())) {
                return 0;
            } else if (cards[1].getFace().equalsIgnoreCase(cards[4].getFace())) {
                return 0;
            } else if (cards[2].getFace().equalsIgnoreCase(cards[3].getFace())) {
                return 0;
            } else if (cards[2].getFace().equalsIgnoreCase(cards[4].getFace())) {
                return 0;
            } else if (cards[3].getFace().equalsIgnoreCase(cards[4].getFace())) {
                return 0;
            } else {
                cards_int_array = processLine(cards);
                cards_int_array = doSelection(cards_int_array);

                if (cards_int_array[4] == 14) {
                    if (cards_int_array[0] == 2) {
                        if (cards_int_array[1] == 3) {
                            if (cards_int_array[2] == 4) {
                                if (cards_int_array[3] == 5) {

                                    // lowest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 6) {
                    if (cards_int_array[1] == 3) {
                        if (cards_int_array[2] == 4) {
                            if (cards_int_array[3] == 5) {
                                if (cards_int_array[0] == 2) {

                                    // 10th  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 7) {
                    if (cards_int_array[1] == 4) {
                        if (cards_int_array[2] == 5) {
                            if (cards_int_array[3] == 6) {
                                if (cards_int_array[0] == 3) {

                                    // 9th  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 8) {
                    if (cards_int_array[1] == 5) {
                        if (cards_int_array[2] == 6) {
                            if (cards_int_array[3] == 7) {
                                if (cards_int_array[0] == 4) {

                                    // 8th  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 9) {
                    if (cards_int_array[1] == 6) {
                        if (cards_int_array[2] == 7) {
                            if (cards_int_array[3] == 8) {
                                if (cards_int_array[0] == 5) {

                                    // 7th  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 10) {
                    if (cards_int_array[1] == 7) {
                        if (cards_int_array[2] == 8) {
                            if (cards_int_array[3] == 9) {
                                if (cards_int_array[0] == 6) {

                                    // sixth  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 11) {
                    if (cards_int_array[1] == 8) {
                        if (cards_int_array[2] == 9) {
                            if (cards_int_array[3] == 10) {
                                if (cards_int_array[0] == 7) {

                                    // fourth  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 12) {
                    if (cards_int_array[1] == 9) {
                        if (cards_int_array[2] == 10) {
                            if (cards_int_array[3] == 11) {
                                if (cards_int_array[0] == 8) {

                                    // third highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 13) {
                    if (cards_int_array[1] == 10) {
                        if (cards_int_array[2] == 11) {
                            if (cards_int_array[3] == 12) {
                                if (cards_int_array[0] == 9) {

                                    // second highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                }
//
            }

        }

        return 0;
    }

    /**
     * four of a kind- 4 same value
     */

    public int fourOfaKind() {
        if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
            if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                    if (!cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                        return 1;
                    }
                }
            }
        } else if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
            if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                        return 1;
                    }
                }
            }
        } else if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
            if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                        return 1;
                    }
                }
            } else if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                    if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                        if (!cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
                            return 1;
                        }
                    }
                }
            }
        } else if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())) {
            if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())) {
                if (cards[1].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }


    /**
     * full house - 3 same value and 2 same value
     *
     * @return
     */
    public int fullHouse() {
        if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
            if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                if (!cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                    if (cards[3].getFace().equalsIgnoreCase(cards[4].getFace())) {
                        return 1;
                    }
                }
            }

        } else if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
            if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                if (!cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (cards[1].getFace().equalsIgnoreCase(cards[4].getFace())) {
                        return 1;
                    }
                }
            } else if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
                if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                    if (!cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                        if (cards[2].getFace().equalsIgnoreCase(cards[4].getFace())) {
                            return 1;
                        }
                    }
                }
            } else if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                        if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())) {
                            return 1;
                        }
                    }
                }
            } else if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
                if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                        if (cards[2].getFace().equalsIgnoreCase(cards[3].getFace())) {
                            return 1;
                        }
                    }
                }
            } else if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                        if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())) {
                            return 1;
                        }
                    }
                }
            } else if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())) {
                if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())) {
                    if (!cards[1].getFace().equalsIgnoreCase(cards[4].getFace())) {
                        if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                            return 1;
                        }
                    }
                }
            } else if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())) {
                if (cards[1].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[1].getFace().equalsIgnoreCase(cards[0].getFace())) {
                        if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                            return 1;
                        }
                    }
                }

            } else if (cards[3].getFace().equalsIgnoreCase(cards[2].getFace())) {
                if (cards[3].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[3].getFace().equalsIgnoreCase(cards[0].getFace())) {
                        if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
                            return 1;
                        }
                    }
                }
            } else if (cards[3].getFace().equalsIgnoreCase(cards[1].getFace())) {
                if (cards[3].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[3].getFace().equalsIgnoreCase(cards[0].getFace())) {
                        if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                            return 1;
                        }
                    }
                }
            }


        }
        return 0;
    }

    /**
     * checking flush- all 5 same suit
     *
     * @return
     */
    public int flush() {
        if (cards[0].getSuit().equalsIgnoreCase(cards[1].getSuit())) {
            if (cards[0].getSuit().equalsIgnoreCase(cards[2].getSuit())) {
                if (cards[0].getSuit().equalsIgnoreCase(cards[3].getSuit())) {
                    if (cards[0].getSuit().equalsIgnoreCase(cards[4].getSuit())) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    /**
     * straight
     *
     * @return
     */
    public int straight() {


        for (int counter = 0; counter < cards.length; counter++) {

            if (cards[counter].getFace().equalsIgnoreCase("Ace")) {
                cards[counter].setFace("14");
            } else if (cards[counter].getFace().equalsIgnoreCase("King")) {
                cards[counter].setFace("13");
            } else if (cards[counter].getFace().equalsIgnoreCase("Queen")) {
                cards[counter].setFace("12");
            } else if (cards[counter].getFace().equalsIgnoreCase("Jack")) {
                cards[counter].setFace("11");
            }
        }
        if (flush() == 0) {
            if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
                return 0;
            } else if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                return 0;
            } else if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                return 0;
            } else if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                return 0;
            } else if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())) {
                return 0;
            } else if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())) {
                return 0;
            } else if (cards[1].getFace().equalsIgnoreCase(cards[4].getFace())) {
                return 0;
            } else if (cards[2].getFace().equalsIgnoreCase(cards[3].getFace())) {
                return 0;
            } else if (cards[2].getFace().equalsIgnoreCase(cards[4].getFace())) {
                return 0;
            } else if (cards[3].getFace().equalsIgnoreCase(cards[4].getFace())) {
                return 0;
            } else {
                cards_int_array = processLine(cards);
                cards_int_array = doSelection(cards_int_array);

                if (cards_int_array[4] == 14) {
                    if (cards_int_array[0] == 2) {
                        if (cards_int_array[1] == 3) {
                            if (cards_int_array[2] == 4) {
                                if (cards_int_array[3] == 5) {

                                    // lowest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 6) {
                    if (cards_int_array[1] == 3) {
                        if (cards_int_array[2] == 4) {
                            if (cards_int_array[3] == 5) {
                                if (cards_int_array[0] == 2) {

                                    // 10th  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 7) {
                    if (cards_int_array[1] == 4) {
                        if (cards_int_array[2] == 5) {
                            if (cards_int_array[3] == 6) {
                                if (cards_int_array[0] == 3) {

                                    // 9th  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 8) {
                    if (cards_int_array[1] == 5) {
                        if (cards_int_array[2] == 6) {
                            if (cards_int_array[3] == 7) {
                                if (cards_int_array[0] == 4) {

                                    // 8th  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 9) {
                    if (cards_int_array[1] == 6) {
                        if (cards_int_array[2] == 7) {
                            if (cards_int_array[3] == 8) {
                                if (cards_int_array[0] == 5) {

                                    // 7th  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 10) {
                    if (cards_int_array[1] == 7) {
                        if (cards_int_array[2] == 8) {
                            if (cards_int_array[3] == 9) {
                                if (cards_int_array[0] == 6) {

                                    // sixth  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 11) {
                    if (cards_int_array[1] == 8) {
                        if (cards_int_array[2] == 9) {
                            if (cards_int_array[3] == 10) {
                                if (cards_int_array[0] == 7) {

                                    // fourth  highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 12) {
                    if (cards_int_array[1] == 9) {
                        if (cards_int_array[2] == 10) {
                            if (cards_int_array[3] == 11) {
                                if (cards_int_array[0] == 8) {

                                    // third highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 13) {
                    if (cards_int_array[1] == 10) {
                        if (cards_int_array[2] == 11) {
                            if (cards_int_array[3] == 12) {
                                if (cards_int_array[0] == 9) {

                                    // second highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                } else if (cards_int_array[4] == 14) {
                    if (cards_int_array[0] == 10) {
                        if (cards_int_array[1] == 11) {
                            if (cards_int_array[2] == 12) {
                                if (cards_int_array[3] == 13) {

                                    // highest straight
                                    return 1;
                                }
                            }
                        }
                    }
                }
            }

        }

        return 0;
    }

    /**
     * checking for double pair
     */
    public int twoPairs() {
        int twopair = 0;

        if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
            twopair++;
        }
        if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
            twopair++;
        }
        if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
            twopair++;
        }
        if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
            twopair++;
        }
        if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())) {
            twopair++;
        }
        if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())) {
            twopair++;
        }
        if (cards[1].getFace().equalsIgnoreCase(cards[4].getFace())) {
            twopair++;
        }
        if (cards[2].getFace().equalsIgnoreCase(cards[3].getFace())) {
            twopair++;
        }
        if (cards[2].getFace().equalsIgnoreCase(cards[4].getFace())) {
            twopair++;
        }
        if (cards[3].getFace().equalsIgnoreCase(cards[4].getFace())) {
            twopair++;
        }

        if (twopair == 2) {
            return 1;
        } else
            return 0;

    }

    /**
     * chekcing for triple- 3 same value
     */

    public int threeofakind() {
        if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
            if ((cards[0].getFace().equalsIgnoreCase(cards[2].getFace()))) {
                return 1;
            } else if ((cards[0].getFace().equalsIgnoreCase(cards[3].getFace()))) {
                return 1;
            } else if ((cards[0].getFace().equalsIgnoreCase(cards[4].getFace()))) {
                return 1;
            }
        } else if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
            if ((cards[0].getFace().equalsIgnoreCase(cards[3].getFace()))) {
                return 1;
            } else if ((cards[0].getFace().equalsIgnoreCase(cards[4].getFace()))) {
                return 1;
            }
        } else if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
            if ((cards[0].getFace().equalsIgnoreCase(cards[4].getFace()))) {
                return 1;
            }
        } else if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())) {
            if ((cards[1].getFace().equalsIgnoreCase(cards[3].getFace()))) {
                return 1;
            } else if ((cards[1].getFace().equalsIgnoreCase(cards[4].getFace()))) {
                return 1;
            }
        } else if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())) {
            if ((cards[1].getFace().equalsIgnoreCase(cards[4].getFace()))) {
                return 1;
            }
        } else if (cards[2].getFace().equalsIgnoreCase(cards[3].getFace())) {
            if ((cards[2].getFace().equalsIgnoreCase(cards[4].getFace()))) {
                return 1;
            }
        }

        return 0;

    }

    /**
     * checking for single pair- one pair
     *
     * @return
     */
    public int pair() {

        if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())) {
            return 1;
        } else if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
            return 1;
        } else if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
            return 1;
        } else if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
            return 1;
        } else if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())) {
            return 1;
        } else if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())) {
            return 1;
        } else if (cards[1].getFace().equalsIgnoreCase(cards[4].getFace())) {
            return 1;
        } else if (cards[2].getFace().equalsIgnoreCase(cards[3].getFace())) {
            return 1;
        } else if (cards[2].getFace().equalsIgnoreCase(cards[4].getFace())) {
            return 1;
        } else if (cards[3].getFace().equalsIgnoreCase(cards[4].getFace())) {
            return 1;
        } else
            return 0;
    }


    /**
     * checking the highest card
     *
     * @return
     */
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

    /**
     * converting cards.face to int
     *
     * @param cards
     * @return
     */
    private Integer[] processLine(Card[] cards) {
        Integer[] card_int_array = new Integer[cards.length];
        int i = 0;
        for (Card str : cards) {
            card_int_array[i] = Integer.parseInt(str.getFace().trim());//Exception in this line
            i++;
        }
        return card_int_array;
    }


    public static Integer[] doSelection(Integer[] arr) {
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

}
