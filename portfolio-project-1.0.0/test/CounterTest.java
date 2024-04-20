import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class CounterTest {

    @Test
    public void testIncrement() {
        Counter counter = new Counter();
        counter.increment();
        assertEquals(1, counter.getValue());
    }

    @Test
    public void testDecrement() {
        Counter counter = new Counter();
        counter.decrement();
        assertEquals(-1, counter.getValue());
    }

    @Test
    public void testReset() {
        Counter counter = new Counter();
        counter.incrementBy(5);
        counter.reset();
        assertEquals(0, counter.getValue());
    }

    @Test
    public void testIncrementBy() {
        Counter counter = new Counter();
        counter.incrementBy(5);
        assertEquals(5, counter.getValue());
    }

    @Test
    public void testDecrementBy() {
        Counter counter = new Counter();
        counter.incrementBy(5);
        counter.decrementBy(3);
        assertEquals(2, counter.getValue());
    }

    @Test
    public void testSetValue() {
        Counter counter = new Counter();
        counter.setValue(10);
        assertEquals(10, counter.getValue());
    }

    @Test
    public void testNegativeIncrementBy() {
        Counter counter = new Counter();
        assertThrows(IllegalArgumentException.class, () -> counter.incrementBy(-5));
    }

    @Test
    public void testNegativeDecrementBy() {
        Counter counter = new Counter();
        assertThrows(IllegalArgumentException.class, () -> counter.decrementBy(-5));
    }
}
