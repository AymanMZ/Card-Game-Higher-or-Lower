import com.aymanmz.game.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {
    private Game sut;
    @Before
    public void setup() {
        sut = new Game();
    }

    @Test
    public void using_punch_decreases_monster_health() {
        //Arrange

        //Act
        sut.usePunchOnMonster();
        //
        Assert.assertEquals(99, sut.getMonster().getCurrentHealth());
    }
    @Test
    public void using_punch_a_lot_adds_a_kick_and_resets_tracker() {
        //Arrange

        //Act
        for (int i = 0; i < 11; i++) {
            sut.usePunchOnMonster();
        }
        //Assert
        Assert.assertEquals(1, sut.getInventory().getListOfKicks().size());
    }

}
