package MyQueue;

import MyStack.FixedSizeStack;
import MyStack.MyStack;

import java.util.Arrays;

public class FixedSizeQueue<T> {
    private T[] elements;

    private int currentElement;

    private int nextElement;

    private int tail;

    int queueSize;


    public FixedSizeQueue(int size) {
        elements = (T[]) new Object[size];
        currentElement = 0;
        nextElement = 0;
        queueSize = 0;
        tail = 0;
     }

     public void enqueue(T t) {
         if(nextElement == elements.length) {
             nextElement = 0;
         }
         if(tail == elements.length) {
             tail = 0;
         }
        if(queueSize == 0) {
            elements[currentElement] = t;
        } else if (elements[tail] == null) {
            elements[tail] = t;
        } else if (currentElement == elements.length-1) {
            nextElement = 0;
            elements[nextElement++] = t;
        } else {
            elements[++nextElement] = t;
        }
         queueSize++;
     }



    public void dequeue() {
        if(currentElement == elements.length) {
            currentElement = 0;
        }
        if(queueSize == 1) {
            throw new IllegalArgumentException();
        }
        tail = currentElement;
        elements[currentElement] = null;
        currentElement++;
        queueSize--;
    }
    @Override
    public String toString() {
        if (queueSize == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        FixedSizeQueue<T> fixedSizeQueue = new FixedSizeQueue<T>(elements.length);

        for (int i = elements.length - 1; i >= 0; i--) {
            stringBuilder.append(elements[i]).append(", ");
        }
        stringBuilder.setLength(stringBuilder.length() - 2);
        System.out.println(elements.length);
        return "[" + stringBuilder + "] ";
    }

    public static void main(String[] args) {
        FixedSizeQueue<Integer> fixedSizeQueue = new FixedSizeQueue<Integer>(3);
        fixedSizeQueue.enqueue(1);
        fixedSizeQueue.enqueue(2);
        fixedSizeQueue.enqueue(3);
        System.out.println(fixedSizeQueue); // Deve imprimir [1, 2, 3]
        fixedSizeQueue.dequeue();
        System.out.println(fixedSizeQueue); // Deve imprimir [2, 3]
        fixedSizeQueue.enqueue(4);
        System.out.println(fixedSizeQueue); // Deve imprimir [2, 3, 4]





















        System.out.println(fixedSizeQueue);
        System.out.println(fixedSizeQueue.currentElement);
        System.out.println(fixedSizeQueue.tail);
        System.out.println(fixedSizeQueue.nextElement);
        System.out.println(fixedSizeQueue.queueSize);
    }

}
