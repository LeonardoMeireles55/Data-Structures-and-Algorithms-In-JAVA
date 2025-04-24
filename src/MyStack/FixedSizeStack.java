package MyStack;

/**
 * A generic stack implementation with fixed size.
 * 
 * @param <T> Type of elements stored in the stack
 */
public class FixedSizeStack<T> {
    private final T[] elements;
    private Integer stackSize;

    /**
     * Constructs a fixed size stack with specified capacity.
     * 
     * @param size Maximum capacity of the stack
     */
    public FixedSizeStack(Integer size) {
        elements = (T[]) new Object[size];
        stackSize = 0;
    }

    /**
     * Checks if the stack is empty.
     * 
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return stackSize == 0;
    }

    /**
     * Returns the top element without removing it.
     * 
     * @return The top element of the stack
     * @throws IllegalStateException if the stack is empty
     */
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot peek an empty stack");
        }
        return elements[stackSize - 1];
    }

    /**
     * Adds an element to the top of the stack.
     * 
     * @param element Element to be added to the stack
     * @throws StackOverflowError if the stack is full
     */
    public void push(T element) {
        if (stackSize == elements.length) {
            throw new StackOverflowError("Stack is full");
        }
        elements[stackSize++] = element;
    }

    /**
     * Removes and returns the top element of the stack.
     * 
     * @return The removed element
     * @throws IllegalStateException if the stack is empty
     */
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack");
        }
        T element = elements[--stackSize];
        elements[stackSize] = null; // Help garbage collection
        return element;
    }

    /**
     * Returns a string representation of the stack.
     * 
     * @return String representation of the stack
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");
        for (Integer i = stackSize - 1; i >= 0; i--) {
            stringBuilder.append(elements[i]);
            if (i > 0) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.append("]").toString();
    }
}
