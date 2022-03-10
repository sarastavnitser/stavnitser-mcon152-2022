import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhysicsObjectsInMotionTest {

    @Test
    public void testX() {
        //given
        PhysicsObjectsInMotion proj = new PhysicsObjectsInMotion();

        //when
        double result = proj.x(43.0, 6.0, 52.0);

        //then
        assertEquals(158.84066063401983, result);
    }

    @Test
    public void testY() {
        //given
        PhysicsObjectsInMotion proj = new PhysicsObjectsInMotion();
        //when
        double result = proj.y(43.0, 6.0, 52.0, 9.8);
        //then
        assertEquals(26.906774430534284, result);
    }
}