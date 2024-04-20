public class CounterKernelImpl implements CounterKernel {
    private int counterValue;

    // Constructor
    public CounterKernelImpl() {
        this.counterValue = 0;
    }

    /**
     * Increments the counter by 1.
     *
     * @ensures the value of the counter is increased by 1.
     */
    @Override
    public void increment() {
        counterValue++;
    }

    /**
     * Decrements the counter by 1.
     *
     * @ensures the value of the counter is decreased by 1.
     */
    @Override
    public void decrement() {
        counterValue--;
    }

    /**
     * Resets the counter to 0.
     *
     * @ensures the value of the counter is set to 0.
     */
    @Override
    public void reset() {
        counterValue = 0;
    }

    /**
     * Retrieves the current value of the counter.
     *
     * @return the current value of the counter.
     */
    @Override
    public int getValue() {
        return counterValue;
    }

    @Override
    public void incrementBy(int amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'incrementBy'");
    }

    @Override
    public void setValue(int value) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setValue'");
    }

    /**
     * Convention: The variable counterValue represents the current value of the
     * counter.
     * Correspondence: The abstract state of the counter is represented by
     * counterValue.
     */
}
