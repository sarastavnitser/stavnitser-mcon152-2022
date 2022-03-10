

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RPNTest {

    @Test
    public void findResultShort() {
    //given
        RPN rpn = new RPN();
    //when
        String result = rpn.findRPNResult("3 5 +");
    //then
        assertEquals("8.0", result);
    }
    @Test
    public void findResultLong(){
        //given
        RPN rpn = new RPN();

        //when
        String result = rpn.findRPNResult("2 5 * 4 + 3 2 * 1 + / ");

        //then
        assertEquals("2.0", result);
    }

    @Test
    public void findResultError(){
        //given
        RPN rpn = new RPN();

        //when
        String result = rpn.findRPNResult("a b c");

        //then
        assertEquals("unexpected symbol", result);
    }


}