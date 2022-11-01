import com.aymanmz.game.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GameTest {
    private Game sut;

    @Before
    public void setup() {
        sut = new Game();
    }

    @Test
    public void is_it_lower_wrong_streak_is_0() {
        //Arrange
        Stack<Integer> deckTest = new Stack<>();
        deckTest.push(1);
        deckTest.push(2);
        deckTest.push(3);
        sut.getDeck().setStackOfCards(deckTest);
        sut.getBoard().setCardsOnBoard(new ArrayList<>(List.of(0)));

        //Act
        sut.isItLower();
        //Assert
        Assert.assertEquals(0, sut.getStreak());
    }

    @Test
    public void is_it_lower_correct_streak_is_1() {
        //Arrange
        Stack<Integer> deckTest = new Stack<>();
        deckTest.push(1);
        deckTest.push(2);
        deckTest.push(3);
        sut.getDeck().setStackOfCards(deckTest);
        sut.getBoard().setCardsOnBoard(new ArrayList<>(List.of(4)));

        //Act
        sut.isItLower();
        //Assert
        Assert.assertEquals(1, sut.getStreak());
    }

    @Test
    public void is_it_lower_high_streak_is_2() {
        //Arrange
        Stack<Integer> deckTest = new Stack<>();
        deckTest.push(1);
        deckTest.push(2);
        deckTest.push(3);
        sut.getDeck().setStackOfCards(deckTest);
        sut.getBoard().setCardsOnBoard(new ArrayList<>(List.of(4)));

        //Act
        sut.isItLower();
        sut.isItLower();
        sut.isItHigher();
        //Assert
        Assert.assertEquals(2, sut.getHighStreak());
    }
}
