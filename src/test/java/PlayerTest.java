import com.aymanmz.game.elements.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayerTest {
    private Player sut;

    @Before
    public void setup() {
        sut = new Player();
    }

    @Test
    public void remove_the_second_card() {
        //Arrange
        sut.setCardsOnHand(new ArrayList<>(List.of(1, 2, 3)));
        List<Integer> expected = new ArrayList<>(List.of(1, 3));
        //Act
        int actual = sut.removeCard(1);
        //Assert
        Assert.assertEquals(2, actual);
        Assert.assertEquals(expected, sut.getCardsOnHand());
    }
}
