import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolynomialTest {

    Polynomial polynomial;

    @Before
    public void setup(){
        polynomial = new Polynomial("3x^3 + 2x^2 + 3");
    }

    @Test
    public void basicPostProcessTest(){
        String output = polynomial.post_process(new int[]{1, 2, 2});
        Assert.assertEquals("2x^2 +2x^1 +1 ", output);
    }

    @Test
    public void basicMultiplyTest(){
        String output = polynomial.multiply("2x^1 + 1");
        Assert.assertEquals("6x^4 +7x^3 +2x^2 +6x^1 +3 ", output);
    }
}
