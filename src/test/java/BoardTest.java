import com.aymanmz.game.elements.Board;
import com.aymanmz.game.exception.LowCardAmountException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardTest {
    private Board sut;
    @Before
    public void setup() { sut = new Board();}

    @Test
    public void board_puts_card_away_and_returns_it() {
        //Arrange
        sut.setCardsOnBoard(new ArrayList<>(List.of(1, 2, 3)));
        List<Integer> expectedList = new ArrayList<>(List.of(1, 2));
        //Act
        int actual = sut.putTopCardAway();
        //Assert
        Assert.assertEquals(3, actual);
        Assert.assertEquals(expectedList, sut.getCardsOnBoard());
    }

    @Test
    public void board_puts_all_cards_away_and_returns_it() {
        //Arrange
        sut.setCardsOnBoard(new ArrayList<>(List.of(1, 2, 3)));
        List<Integer> expectedList1 = new ArrayList<>(List.of(3, 2, 1));
        List<Integer> expectedList2 = new ArrayList<>();
        //Act
        List<Integer> actual = sut.putAllCardsAway();
        //Assert
        Assert.assertEquals(expectedList1, actual);
        Assert.assertEquals(expectedList2, sut.getCardsOnBoard());
    }

    @Test
    public void board_takes_card() {
        //Arrange
        sut.setCardsOnBoard(new ArrayList<>(List.of(1, 2, 3)));
        List<Integer> expectedList = new ArrayList<>(List.of(1, 2, 3, 4));
        //Act
        sut.takeCard(4);
        //Assert
        Assert.assertEquals(expectedList, sut.getCardsOnBoard());
    }

    @Test
    public void board_takes_null() {
        //Arrange
        sut.setCardsOnBoard(new ArrayList<>(List.of(1, 2, 3)));
        List<Integer> expectedList = new ArrayList<>(List.of(1, 2, 3));
        //Act
        sut.takeCard(null);
        //Assert
        Assert.assertEquals(expectedList, sut.getCardsOnBoard());
    }
    @Test
    public void board_takes_card_list() {
        //Arrange
        List<Integer> expectedList = new ArrayList<>(List.of(1, 2, 3));
        //Act
        sut.takeCards(expectedList);
        //Assert
        Assert.assertEquals(expectedList, sut.getCardsOnBoard());
    }
    @Test
    public void board_takes_cards_list_null_inside() {
        //Arrange
        List<Integer> listToTake = new ArrayList<>(List.of(1, 2, 3));
        listToTake.add(null);
        List<Integer> expectedList = new ArrayList<>(List.of(1, 2, 3));
        //Act
        sut.takeCards(listToTake);
        //Assert
        Assert.assertEquals(expectedList, sut.getCardsOnBoard());
    }
}
