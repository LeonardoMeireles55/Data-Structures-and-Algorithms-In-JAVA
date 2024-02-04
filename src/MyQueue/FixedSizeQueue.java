package MyQueue;


public class FixedSizeQueue<T> {
    private T[] elements;

    private int frontQueue;

    private int rearQueue;

    private int tail;

    int queueSize;

    public FixedSizeQueue(int size) {
        elements = (T[]) new Object[size];
        frontQueue = 0;
        rearQueue = -1;
        queueSize = 0;
        tail = 0;
    }

    public void enqueue(T t) {
        if (queueSize == elements.length) {
            throw new IllegalArgumentException();
        }
        rearQueue = (rearQueue + 1) % elements.length;
        elements[rearQueue] = t;
        queueSize++;
    }

    public void dequeue() {
        if (queueSize == 0) {
            throw new IllegalArgumentException("Queue is empty");
        }
        elements[frontQueue] = null;
        frontQueue = (frontQueue + 1) % elements.length;
        queueSize--;
    }

    @Override
    public String toString() {
        if (queueSize == 0) {
            return "[]";
        }
    
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = frontQueue; i != rearQueue; i = (i + 1) % elements.length) {
            stringBuilder.append(elements[i]).append(", ");
        }
        stringBuilder.append(elements[rearQueue]);  
        return "[" + stringBuilder.toString() + "]";
    }

    public static void main(String[] args) {
        FixedSizeQueue<Integer> fixedSizeQueue = new FixedSizeQueue<Integer>(3);
        fixedSizeQueue.enqueue(1);
        fixedSizeQueue.enqueue(2);
        fixedSizeQueue.enqueue(3);
    
        fixedSizeQueue.dequeue();
        fixedSizeQueue.dequeue();

        fixedSizeQueue.enqueue(1);
        fixedSizeQueue.enqueue(2);

        fixedSizeQueue.dequeue();
        fixedSizeQueue.enqueue(2);
        fixedSizeQueue.dequeue();
        fixedSizeQueue.dequeue();

        System.out.println(fixedSizeQueue);
        System.out.println("frontQueue: " + fixedSizeQueue.frontQueue);
        System.out.println("rearQueue: " + fixedSizeQueue.rearQueue);
        System.out.println("tail: " + fixedSizeQueue.tail);
        System.out.println("size: " + fixedSizeQueue.queueSize);
    }

}
