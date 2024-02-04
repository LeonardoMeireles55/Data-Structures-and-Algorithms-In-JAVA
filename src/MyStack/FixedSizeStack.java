package MyStack;

public class FixedSizeStack<T> {
    private T[] elements;
    private int stackSize;

    public FixedSizeStack(int size) {
        elements = (T[]) new Object[size];
        stackSize = 0;
    }
    public boolean isEmpty() {
        return stackSize == 0;
    }

    public T peek() {
        if(isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elements[stackSize - 1];
    }

    public void push(T t) {
        if (stackSize == elements.length) {
            throw new StackOverflowError();
        }
        elements[stackSize++] = t;
    }

    public T pop() {
        if(isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return elements[--stackSize] = null;
    }

    @Override
    public String toString() {
        if (stackSize == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = elements.length - 1; i >= 0; i--) {
            stringBuilder.append(elements[i]).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return "[" + stringBuilder + "] ";
    }
}
