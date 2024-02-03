package MyStack;

public class MyStack<T> {

    private T[] elements;
    private int stackSize;

    public T[] getElements() {
        return elements;
    }

    public int getStackSize() {
        return this.stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }



    public MyStack() {
        elements = (T[]) new Object[2];
        stackSize = 0;
    }

    //[2] -> lista com 1 elemento;
    //[2]  -> lista com 2 elementos;
    //[4] -> lista com 3 elementos;
    //[4] -> lista com 4 elementos;
    //[8] -> lista com 5 elementos;
    private void resize(int max) {
        T[] auxStack;
        auxStack = (T[]) new Object[max];
        for (int i = 0; i < stackSize; i++) {
            auxStack[i] = elements[i];
        }
        elements = auxStack;
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
            resize(2 * elements.length);
        }
        elements[stackSize++] = t;
    }

    public T pop() {
        if(isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T t = elements[--stackSize];
        if (stackSize > 0 && stackSize == elements.length / 4) {
            resize(elements.length / 2);
        }
        return t;
    }



    @Override
    public String toString() {
        if (this.stackSize == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        MyStack myStack = new MyStack<T>();

        for (int i = 0; i < this.stackSize; i++) {
            elements[i] = getElements()[i];
            stringBuilder.append(elements[i]).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        return "[" + stringBuilder.toString() + "] ";
    }
}