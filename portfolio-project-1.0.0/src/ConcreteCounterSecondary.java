// Concrete class ConcreteCounterSecondary extending CounterSecondary
public class ConcreteCounterSecondary extends CounterSecondary {

    // Constructor accepting a CounterKernel object
    public ConcreteCounterSecondary(CounterKernel kernel) {
        super(kernel);
    }

    // Additional method: get the current value of the counter
    public int getCurrentValue() {
        return counterKernel.getValue();
    }

    // Additional method: reset the counter to zero
    public void resetCounter() {
        counterKernel.reset();
    }

    // Overrides the increment method to delegate to CounterKernel
    @Override
    public void increment() {
        counterKernel.increment();
    }

    // Overrides the decrement method to delegate to CounterKernel
    @Override
    public void decrement() {
        counterKernel.decrement();
    }

    // Overrides the reset method to delegate to CounterKernel
    @Override
    public void reset() {
        counterKernel.reset();
    }

    // Overrides the getValue method to delegate to CounterKernel
    @Override
    public int getValue() {
        return counterKernel.getValue();
    }

    // Additional method: check ifi the counter is equal to a specified value
    public boolean isCounterValue(int value) {
        return counterKernel.getValue() == value;
    }

    // Overrides the equals method to compare this instance with another object
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConcreteCounterSecondary) {
            ConcreteCounterSecondary other = (ConcreteCounterSecondary) obj;
            return counterKernel.getValue() == other.getCurrentValue();
        }
        return false;
    }

    // Overrides the hashCode method to provide a custom hash code for the counter
    @Override
    public int hashCode() {
        return Integer.hashCode(getCurrentValue());
    }

    // Overrides the toString method to provide a custom string representation of
    // the counter
    @Override
    public String toString() {
        return "ConcreteCounterSecondary: Counter value = " + getCurrentValue();
    }
}
