import com.aymanmz.game.elements.Inventory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InventoryTest {
    private Inventory sut;
    @Before
    public void setup() {
        sut = new Inventory();
    }

    @Test
    public void move_gets_added_to_list() {
        //Arrange

        //Act
        sut.addAKick();
        sut.addAKick();
        //Assert
        Assert.assertEquals(2, sut.getListOfKicks().size());
    }

    @Test
    public void move_gets_added_to_list_only_3_times() {
        //Arrange

        //Act
        for (int i = 0; i < 4; i++) {
            sut.addAnUppercut();
        }
        //Assert
        Assert.assertEquals(3, sut.getListOfUppercuts().size());
    }

    @Test
    public void move_used_lowers_list_and_returns_number_in_range() {
        //Arrange
        sut.addAKick();
        //Arrange
        int test = sut.useAKick().getDamage();
        //Assert
        boolean actual = test <= 5 && test >= 3;
        Assert.assertTrue(actual);
        Assert.assertEquals(0, sut.getListOfKicks().size());
    }

    @Test
    public void resetValues_resets_the_values_to_initial_size() {
        //Arrange
        sut.addAKick();
        sut.addAnUppercut();
        //Arrange
        sut.resetValues();
        //Assert
        Assert.assertEquals(0, sut.getListOfKicks().size());
        Assert.assertEquals(0, sut.getListOfUppercuts().size());
    }
}
