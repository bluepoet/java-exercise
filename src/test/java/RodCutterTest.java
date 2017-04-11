import net.bluepoet.exercise.lambda.RodCutter;
import net.bluepoet.exercise.lambda.RodCutterException;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.fail;

/**
 * Created by daumkakao on 2017. 4. 11..
 */
public class RodCutterTest {
    @Test
    public void ConciseExceptionTest() throws Exception {
        RodCutter r = new RodCutter();
        r.setPrices(Arrays.asList());
        TestHelper.assertThrows(RodCutterException.class, () -> r.maxProfit(0));
    }

    public static class TestHelper {
        public static <X extends Throwable> Throwable assertThrows(final Class<X> exceptionClass, final Runnable block) {
            try {
                block.run();
            }catch (Throwable e) {
                if(exceptionClass.isInstance(e)) {
                    return e;
                }
            }

            fail("failed to throw expected exception");
            return null;
        }
    }
}
