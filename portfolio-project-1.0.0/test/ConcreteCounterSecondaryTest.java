import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ConcreteCounterSecondaryTest {

    private ConcreteCounterSecondary counterSecondary;
    private CounterKernel counterKernel;

    // Initialize the ConcreteCounterSecondary and CounterKernel before each test
    @Before
    public void setUp() {
        counterKernel = new CounterKernelImpl();
        counterSecondary = new ConcreteCounterSecondary(counterKernel);
    }

    // Test incrementing the counter by 1
    @Test
    public void testIncrement() {
        counterSecondary.increment();
        assertEquals(1, counterSecondary.getCurrentValue());
    }

    // Test decrementing the counter by 1
    @Test
    public void testDecrement() {
        counterSecondary.increment(); // Set counter to 1
        counterSecondary.decrement();
        assertEquals(0, counterSecondary.getCurrentValue());
    }

    // Test resetting the counter to zero
    @Test
    public void testReset() {
        counterSecondary.incrementBy(5); // Set counter to 5
        counterSecondary.reset();
        assertEquals(0, counterSecondary.getCurrentValue());
    }

    // Test setting the counter to a specific value
    @Test
    public void testSetValue() {
        counterSecondary.setValue(10);
        assertEquals(10, counterSecondary.getCurrentValue());
    }

    // Test incrementing the counter by a specified amount
    @Test
    public void testIncrementBy() {
        counterSecondary.incrementBy(5);
        assertEquals(5, counterSecondary.getCurrentValue());
    }

    // Test decrementing the counter by a specified amount
    @Test
    public void testDecrementBy() {
        counterSecondary.incrementBy(10); // Set counter to 10
        counterSecondary.decrementBy(3);
        assertEquals(7, counterSecondary.getCurrentValue());
    }

    // Test if the counter is zero
    @Test
    public void testIsZero() {
        assertTrue(counterSecondary.isZero()); // Initially zero
        counterSecondary.increment();
        assertFalse(counterSecondary.isZero()); // Not zero after increment
    }

    // Test incrementing and returning the new value
    @Test
    public void testIncrementAndReturnValue() {
        int newValue = counterSecondary.incrementAndReturnValue();
        assertEquals(1, newValue);
        assertEquals(1, counterSecondary.getCurrentValue());
    }

    // Test decrementing and returning the new value
    @Test
    public void testDecrementAndReturnValue() {
        counterSecondary.increment(); // Set counter to 1
        int newValue = counterSecondary.decrementAndReturnValue();
        assertEquals(0, newValue);
        assertEquals(0, counterSecondary.getCurrentValue());
    }

    // Test the equals method
    @Test
    public void testEquals() {
        CounterKernel counterKernel = new CounterKernelImpl();

        ConcreteCounterSecondary anotherCounterSecondary = new ConcreteCounterSecondary(counterKernel);
        assertTrue(counterSecondary.equals(anotherCounterSecondary));

        counterSecondary.increment();
        assertFalse(counterSecondary.equals(anotherCounterSecondary));

        anotherCounterSecondary.increment();
        assertTrue(counterSecondary.equals(anotherCounterSecondary));
    }

    // Test the hashCode method
    @Test
    public void testHashCode() {
        CounterKernel counterKernel = new CounterKernelImpl();

        ConcreteCounterSecondary anotherCounterSecondary = new ConcreteCounterSecondary(counterKernel);
        assertEquals(counterSecondary.hashCode(), anotherCounterSecondary.hashCode());

        counterSecondary.increment();
        assertNotEquals(counterSecondary.hashCode(), anotherCounterSecondary.hashCode());

        anotherCounterSecondary.increment();
        assertEquals(counterSecondary.hashCode(), anotherCounterSecondary.hashCode());
    }

    // Test the toString method
    @Test
    public void testToString() {
        assertEquals("ConcreteCounterSecondary: Counter value = 0", counterSecondary.toString());

        counterSecondary.incrementBy(5);
        assertEquals("ConcreteCounterSecondary: Counter value = 5", counterSecondary.toString());
    }
}
