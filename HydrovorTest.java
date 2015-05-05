package hydrovor;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class HydrovorTest {

    @Test(expected = IllegalArgumentException.class)
    public void constructor_nullTank_throwException(){
        new Hydrovor(null, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_volumeLessThan0_throwException(){
        new Hydrovor(new Tank(1,1), -1);
    }

    @Test
    public void hydrovor_Constructor_returnsZero(){
        //given
        Tank tank = Mockito.mock(Tank.class);
        Hydrovor hydrovor = new Hydrovor(tank, -1);
        //when
        int result = hydrovor.getWater();
        //then
        Assert.assertEquals(result, -1);
    }

    @Test
    public void getWater_empty_returns0(){
        //GIVEN
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 0);
        //WHEN
        int result = hydrovor.getWater();
        //THEN
        assertEquals(0, result);
    }

    @Test
    public void tick_callWhenOnAndTankEmpty_return0(){
        //GIVEN
        Hydrovor hydrovor = new Hydrovor(new Tank(1,0), 0);
        //WHEN
        hydrovor.on();
        hydrovor.tick();
        //THEN
        int result = hydrovor.getWater();
        assertEquals(0, result);
    }
    @Test
    public void tick_callWhenOnAndTankEmpty_return1(){
        //GIVEN
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1), 0);
        //WHEN
        hydrovor.on();
        hydrovor.tick();
        //THEN
        int result = hydrovor.getWater();
        assertEquals(1, result);
    }
    
        @Test
    public void tick_callWhenOffAndEmpty_return0(){
        //GIVEN
        Hydrovor hydrovor = new Hydrovor(new Tank(1,1),0);
        //WHEN
        hydrovor.off();
        hydrovor.tick();
        //THEN
        int result = hydrovor.getWater();
            assertEquals(0, result);
    }
}
