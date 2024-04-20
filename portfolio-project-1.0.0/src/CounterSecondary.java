// Abstract class CounterSecondary implementing CounterInterface
public abstract class CounterSecondary implements CounterInterface {
    // CounterKernel to represent the kernel implementation
    protected CounterKernel counterKernel;

    // Constructor accepting a CounterKernel object
    public CounterSecondary(CounterKernel kernel) {
        if (kernel == null) {
            throw new IllegalArgumentException("CounterKernel cannot be null");
        }
        this.counterKernel = kernel;
    }

    // Method to get the CounterKernel for testing purposes
    protected CounterKernel getCounterKernel() {
        return counterKernel;
    }

    @Override
    public void incrementBy(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        for (int i = 0; i < amount; i++) {
            counterKernel.increment();
        }
    }

    @Override
    public void decrementBy(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        for (int i = 0; i < amount; i++) {
            counterKernel.decrement();
        }
    }

    @Override
    public void setValue(int value) {
        counterKernel.reset();
        if (value > 0) {
            incrementBy(value);
        } else if (value < 0) {
            decrementBy(-value);
        }
    }

    @Override
    public boolean isZero() {
        return counterKernel.getValue() == 0;
    }

    @Override
    public void displayValue() {
        System.out.println("Current value: " + counterKernel.getValue());
    }

    @Override
    public int incrementAndReturnValue() {
        counterKernel.increment();
        return counterKernel.getValue();
    }

    @Override
    public int decrementAndReturnValue() {
        counterKernel.decrement();
        return counterKernel.getValue();
    }

    @Override
    public String toString() {
        return "Counter: " + counterKernel.getValue();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CounterSecondary) {
            CounterSecondary other = (CounterSecondary) obj;
            return counterKernel.getValue() == other.counterKernel.getValue();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(counterKernel.getValue());
    }
}
