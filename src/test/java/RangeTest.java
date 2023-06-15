import org.junit.Test;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class RangeTest {
    @Test
    public void rangeTest() throws IOException {
        IntStream.rangeClosed(1,10).forEach(System.out::println);
    }
}
