// Interface Standard
interface Standard<T> {
    // Define any methods required by Standard
}

// Interface CounterKernel
interface CounterKernel extends Standard<Counter> {
    /**
     * Increments the counter by 1.
     *
     * @ensures the value of the counter is increased by 1.
     */
    void increment();

    /**
     * Decrements the counter by 1.
     *
     * @ensures the value of the counter is decreased by 1.
     */
    void decrement();

    /**
     * Resets the counter to 0.
     *
     * @ensures the value of the counter is set to 0.
     */
    void reset();

    /**
     * Retrieves the current value of the counter.
     *
     * @return the current value of the counter.
     */
    int getValue();

    void incrementBy(int amount);

    void setValue(int value);
}

// Interface CounterInterface
interface CounterInterface extends CounterKernel {
    /**
     * Increments the counter by a specified amount.
     *
     * @param amount the amount to increment the counter by.
     * @requires amount >= 0
     * @ensures the value of the counter is increased by the specified amount.
     */
    void incrementBy(int amount);

    /**
     * Decrements the counter by a specified amount.
     *
     * @param amount the amount to decrement the counter by.
     * @requires amount >= 0
     * @ensures the value of the counter is decreased by the specified amount.
     */
    void decrementBy(int amount);

    /**
     * Sets the counter to a specific value.
     *
     * @param value the value to set the counter to.
     * @ensures the value of the counter is set to the specified value.
     */
    void setValue(int value);

    /**
     * Checks if the counter is currently at 0.
     *
     * @return true if the counter is zero, false otherwise.
     */
    boolean isZero();

    /**
     * Displays the current value of the counter.
     *
     * @ensures the current value of the counter is displayed.
     */
    void displayValue();

    /**
     * Increments the counter by 1 and returns the new value.
     *
     * @return the new value of the counter after incrementing by 1.
     * @ensures the value of the counter is increased by 1.
     */
    int incrementAndReturnValue();

    /**
     * Decrements the counter by 1 and returns the new value.
     *
     * @return the new value of the counter after decrementing by 1.
     * @ensures the value of the counter is decreased by 1.
     */
    int decrementAndReturnValue();
}

// Implementation of CounterInterface in the Counter class
public class Counter implements CounterInterface {
    private int value;

    // Constructs a new Counter object with an initial value of 0
    public Counter() {
        this.value = 0;
    }

    // Kernel methods

    /**
     * Increments the counter by 1.
     *
     * @ensures the value of the counter is increased by 1.
     */
    @Override
    public void increment() {
        this.value++;
    }

    /**
     * Decrements the counter by 1.
     *
     * @ensures the value of the counter is decreased by 1.
     */
    @Override
    public void decrement() {
        this.value--;
    }

    /**
     * Resets the counter to 0.
     *
     * @ensures the value of the counter is set to 0.
     */
    @Override
    public void reset() {
        this.value = 0;
    }

    /**
     * Retrieves the current value of the counter.
     *
     * @return the current value of the counter.
     */
    @Override
    public int getValue() {
        return this.value;
    }

    // Secondary methods

    /**
     * Increments the counter by a specified amount.
     *
     * @param amount the amount to increment the counter by.
     * @requires amount >= 0
     * @ensures the value of the counter is increased by the specified amount.
     */
    @Override
    public void incrementBy(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.value += amount;
    }

    /**
     * Decrements the counter by a specified amount.
     *
     * @param amount the amount to decrement the counter by.
     * @requires amount >= 0
     * @ensures the value of the counter is decreased by the specified amount.
     */
    @Override
    public void decrementBy(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.value -= amount;
    }

    /**
     * Sets the counter to a specific value.
     *
     * @param value the value to set the counter to.
     * @ensures the value of the counter is set to the specified value.
     */
    @Override
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Checks if the counter is currently at 0.
     *
     * @return true if the counter is zero, false otherwise.
     */
    @Override
    public boolean isZero() {
        return this.value == 0;
    }

    /**
     * Displays the current value of the counter.
     *
     * @ensures the current value of the counter is displayed.
     */
    @Override
    public void displayValue() {
        System.out.println("Current value: " + this.value);
    }

    /**
     * Increments the counter by 1 and returns the new value.
     *
     * @return the new value of the counter after incrementing by 1.
     * @ensures the value of the counter is increased by 1.
     */
    @Override
    public int incrementAndReturnValue() {
        increment();
        return this.value;
    }

    /**
     * Decrements the counter by 1 and returns the new value.
     *
     * @return the new value of the counter after decrementing by 1.
     * @ensures the value of the counter is decreased by 1.
     */
    @Override
    public int decrementAndReturnValue() {
        decrement();
        return this.value;
    }

    // Main method for testing purposes
    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.increment();
        counter.incrementBy(5);
        counter.displayValue();
        counter.decrement();
        counter.reset();
        counter.displayValue();
    }
}
