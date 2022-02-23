import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuadraticEquationTest {

    @Test
    public void testGetX(){
        //given
        QuadraticEquation quad = new QuadraticEquation(1, 2 , 1);

        //when
        double[] result = quad.getX();
        //then

        assertArrayEquals(new double[]{-1.0, -1.0}, result);
    }
}