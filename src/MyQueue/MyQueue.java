package MyQueue;

public class MyQueue<Element> {
    private NodeForQueue currentNode;
    private NodeForQueue previousNode;
    private int size;

    private class NodeForQueue {
        private Element element;
        private NodeForQueue nextNode;
    }

    public Boolean isEmpty() {
        return currentNode == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(Element element) {
        NodeForQueue auxNode = previousNode;
        previousNode = new NodeForQueue();
        previousNode.element = element;
        previousNode.nextNode = null;
        if (isEmpty()) {
            currentNode = previousNode;
        } else {
            auxNode.nextNode = previousNode;
        }
        size++;
    }

    public void dequeue() {
        currentNode = currentNode.nextNode;
        size--;
        if(isEmpty()) {
            previousNode = null;
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        NodeForQueue tempNode = currentNode; 
        while (tempNode != null) {
            stringBuilder.append(tempNode.element).append(", ");
            tempNode = tempNode.nextNode; 
        }

        if (stringBuilder.length() > 1) {
            stringBuilder.setLength(stringBuilder.length() - 2);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<Integer>();

        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.dequeue();


        System.out.println(myQueue);
    }
}
