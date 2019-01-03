import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AbsoluteTest {


    @Test
    void positiveZero(){
        assertEquals(0,Absolute.absoluteValueOf(0));
    }
    @Test
    void negativeZero(){
        assertEquals(0,Absolute.absoluteValueOf(-0));
    }
    @Test
    void positiveOne(){
        assertEquals(1,Absolute.absoluteValueOf(1));
    }
    @Test
    void negativeOne(){
        assertEquals(1,Absolute.absoluteValueOf(-1));
    }
    @Test
    void positiveOdd(){
        assertEquals(5,Absolute.absoluteValueOf(5));
    }
    @Test
    void negativeOdd(){
        assertEquals(5,Absolute.absoluteValueOf(-5));
    }
    @Test
    void positiveEven(){
        assertEquals(2,Absolute.absoluteValueOf(2));
    }
    @Test
    void negativeEven(){
        assertEquals(2,Absolute.absoluteValueOf(-2));
    }
    @Test
    void bigPositive(){
        assertEquals(1768,Absolute.absoluteValueOf(1768));
    }
    @Test
    void bigNegative(){
        assertEquals(1022,Absolute.absoluteValueOf(-1022));
    }
}