import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CountingTest {

    @Test
    public void getResultMessageTest() {
        String expected = "\"H\" - 1\n"
                        + "\"e\" - 1\n"
                        + "\"l\" - 3\n"
                        + "\"o\" - 2\n"
                        + "\" \" - 1\n"
                        + "\"w\" - 1\n"
                        + "\"r\" - 1\n"
                        + "\"d\" - 1\n"
                        + "\"!\" - 1\n";
        String actual = Counting.getResultMessage("Hello world!");

        assertEquals(expected, actual);
    }
}
