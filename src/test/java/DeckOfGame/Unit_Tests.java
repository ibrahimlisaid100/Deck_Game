package DeckOfGame;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Unit_Tests extends Deck{

    @DisplayName("Number of Suits equals 4")
    @Test
    public void numberOfSuits(){
        int expNumOfSuits = 4;
        int actNumOfSuits = suits.length;

        Assert.assertEquals(expNumOfSuits, actNumOfSuits);

        System.out.println("Test succesful!! \nNumber of Suits equals 4\n");


    }

    @DisplayName("Number of Ranks equals 13")
    @Test
    public void numberOfRAnks(){
        int expNumOfRanks = 13;
        int actNumOfRanks = ranks.length;

        Assert.assertEquals(expNumOfRanks, actNumOfRanks);

        System.out.println("Test succesful!! \nNumber of Ranks equals 13\n");

    }

    @DisplayName("Number of cards in Each Deck equals 52")
    @Test
    public void numberOfCardsInDeck(){
        int expNumOfCardsInDeck = 52;
        int actNumOfCardsInDeck = deck.size();

        Assert.assertEquals(expNumOfCardsInDeck, actNumOfCardsInDeck);
        System.out.println("Test succesful!! \nNumber of cards in Each Deck equals 52\n");
    }

    @DisplayName("Number of Cards to Each Player varies depending on the number inputted by User")
    @Test
    public void numberOfCardsForEachPlayer(){
        int NumOfCardsInDeck = 52;

        int expectedfor2 = NumOfCardsInDeck/2;
        int expectedfor5 = NumOfCardsInDeck/5;
        int expectedfor10 = NumOfCardsInDeck/10;

        int actual2 = numCardsForPlayer(2);
        int actual5 = numCardsForPlayer(5);
        int actual10 = numCardsForPlayer(10);

        Assert.assertEquals(expectedfor2, actual2);
        System.out.println("Test succesful!! \nNumber of Cards to Each out of 2 Player equals " + expectedfor2 + "\n");

        Assert.assertEquals(expectedfor5, actual5);
        System.out.println("Test succesful!! \nNumber of Cards to Each out of 5 Player equals " + expectedfor5 + "\n");

        Assert.assertEquals(expectedfor10, actual10);
        System.out.println("Test succesful!! \nNumber of Cards to Each out of 10 Player equals " + expectedfor10);



    }


}
