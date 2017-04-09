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
            } else if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())) {
                if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())) {
                    if (!cards[0].getFace().equalsIgnoreCase(cards[3].getFace())) {
                        if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())) {
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

        int highCard =0;

        for (int counter =0; counter<cards.length;counter++) {

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
        if (flush()==0){
        if (cards[0].getFace().equalsIgnoreCase(cards[1].getFace())){
            return 0;
        }
        else if (cards[0].getFace().equalsIgnoreCase(cards[2].getFace())){
            return 0;
        }
        else if (cards[0].getFace().equalsIgnoreCase(cards[3].getFace())){
            return 0;
        }
        else if (cards[0].getFace().equalsIgnoreCase(cards[4].getFace())){
            return 0;
        }
        else if (cards[1].getFace().equalsIgnoreCase(cards[2].getFace())){
            return 0;
        }
        else if (cards[1].getFace().equalsIgnoreCase(cards[3].getFace())){
            return 0;
        }
        else if (cards[1].getFace().equalsIgnoreCase(cards[4].getFace())){
            return 0;
        }
        else if (cards[2].getFace().equalsIgnoreCase(cards[3].getFace())){
            return 0;
        }
        else if (cards[2].getFace().equalsIgnoreCase(cards[4].getFace())){
            return 0;
        }
        else if (cards[3].getFace().equalsIgnoreCase(cards[4].getFace())){
            return 0;
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


}
