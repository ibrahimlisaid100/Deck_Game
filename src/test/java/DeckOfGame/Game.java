package DeckOfGame;

import java.util.*;

class Card {

    /*
    I have Card_class and two instance variables for the object of Card_class.
    Both of them String: one for rank and the second for suit
    */

    private String rank;
    private String suit;

    /*
    I have constructor Card with two parameters
    Both of them String: one for rank and the second for suit
     */
    public Card(String r,String s) {
        rank=r;
        suit=s;
    }

    /*
    This toString method helps to represent Card_object to String representation
    No parameters
    Return = String representation of Card_object
     */
    public String toString() {
        return rank+" of "+suit;
    }
}


class Deck {

    /*
    I have Deck_class
    I have protected ArrayList of Card_class_instances and protects Arrays for rank and suit
    In the beginning they were private but
    I need these variables to be seen in Unit_Tests class for testing purposes
    So, later I altered access-modifier for protected
    because protected is seen in the class and in child class - I extend Deck_class by Unit_Tests_class
     */

    protected ArrayList<Card> deck;
    protected final String[] suits ={"SPADE","HEART","CLUB","DIAMOND"};
    protected final String[] ranks ={"ACE","2","3","4","5","6","7","8","9","10","JACK","QUEEN","KING"};

    /*
    Constructor of Deck_class creates ArrayList of Card_instances:
    it invokes Constructor of Card_class and with the help of two for_loops creates ArrayList of Card_instances
     */
    public Deck() {
        deck = new ArrayList<Card>();
        for(int i=0;i<suits.length;i++) {
            for(int j=0;j<ranks.length;j++) {
                deck.add(new Card(ranks[j],suits[i]));
            }
        }
    }

    /*
    This method prints out the instances of Card class with the help of for_each loop and toString method from Card class
    No parameters
    Void method
     */
    public void showCards() {
        System.out.println("\n\n Showing Cards !!!");
        int i=1;
        for(Card each:deck) {
            System.out.println("Card "+(i++)+" : "+ each);
        }
    }

    /*
    This method shuffles deck with the help of while_loop and Math.random() which is a double in the range between 0 and 1
    Until deck has 1 and more instance inside:
    the size of deck_ArrayList will be multiplied by a number in the range between 0 and 1
    Then Card_instance having this index number in the deck_ArrayList will be "migrated" to a new ArrayList_shuffledDeck
    by adding it to ArrayList_shuffledDeck and removing from deck_ArrayList

    No parameters to this method
    Void method
     */
    public  void shuffle() {
        ArrayList<Card> shuffledDeck = new ArrayList<Card>();
        while(!deck.isEmpty()) {
            int j=(int)(Math.random()*deck.size());
            shuffledDeck.add(deck.get(j));
            deck.remove(j);
        }
        deck=shuffledDeck;
    }

    /*
    This method calculates the number of cards for each player by dividing the the size of deck_ArrayList by number of players
    Parameter = number of players received with the help of Scanner
    Return int = number of cards for one player in a game
     */
    public int numCardsForPlayer(int numPlayers){
        int numCardsForPlayer = deck.size()/numPlayers;
        return numCardsForPlayer;
    }

    /*
    Method distributes cards by players with the help of for_loop
    that repeats as many times as many players will be playing the game
    List of Card_instances is created which is sublist of deck_ArrayList that takes as many cards from deck_ArrayList
    as is needed for 1 each player - starting from Card_instance with index 0;
    Parameter =
    1. number of players received with the help of Scanner
    2. number of cards for each 1 player - calculated by method "numCardsForPlayer"
    Void method
     */
    public void dealCards(int numPlayers, int numCardsFor1Player) {
        System.out.println("\n\n Dealing the Cards !!!");
        for (int i = 0; i<numPlayers; i++) {
            List<Card> player = deck.subList(0, numCardsFor1Player);
            System.out.println(player.toString());
            player.clear();

        }
    }

}
//

public class Game {
    public static void main(String[] args) {

        /*
        I create Deck_class_instance which invokes creating a deck_ArrayList of Card_instances
        Then I call showCards_method which is meant to print out the Card_instances in String representation
        After it I call shuffle_method which shuffles the Card_instances in deck_ArrayList
        Then I repeatedly call showCards_method which is meant to print out the Card_instances in String representation
         */
        Deck myDeck = new Deck();
        myDeck.showCards();
        myDeck.shuffle();
        myDeck.showCards();

        /*
        I am asking User of the number of players to play the game
        Then Scanner gets the number for me
         */
        System.out.println("How many players will play the game? \nNumber of players must be from 2 up to 10.");
        Scanner scan = new Scanner(System.in);
        int numPlayers = scan.nextInt();

        /*
        If User gets number less than 2 or more than 10,
        I am asking the User to give another number in the range between 2 and 10
         */
        while (numPlayers <= 1 || numPlayers >= 11) {
            System.out.println("Please fill in correct number of players. \n\nNumber of players must be from 2 up to 10. ");
            numPlayers = scan.nextInt();

        }

        /*
        I am invoking method "numCardsForPlayer" to know how many cards each player will have
        I am printing this number as well
        And lastly, I am calling method "dealCards" which deals the cards to players
         */
        int cardsFor1Player = myDeck.numCardsForPlayer(numPlayers);

        System.out.println("Each player will receive " + cardsFor1Player + " cards");

        myDeck.dealCards(numPlayers, cardsFor1Player);


    }



}
