package MyPriorityQueue;

public class MyPriorityQueue<Element> {
    private NodeForPriorityQueue currentNode;
    private NodeForPriorityQueue previousNode;
    private int size;

    private enum priority {
        LOW,
        MEDIUM,
        HIGH
    }

    private class NodeForPriorityQueue<Element> {
        private Element element;
        private int priority;
        private NodeForPriorityQueue nextNode;

    }

    public MyPriorityQueue() {
        this.currentNode = null;
        this.previousNode = null;
        this.size = 0;
    }

    public Boolean isEmpty() {
        return currentNode == null;
    }

    public void enqueue(Element element, int priority) {
        NodeForPriorityQueue newNode = new NodeForPriorityQueue();
        newNode.element = element;
        newNode.priority = priority;
        newNode.nextNode = null;

        if (isEmpty()) {
            currentNode = newNode;
        } else if (priority > currentNode.priority) {
            newNode.nextNode = currentNode;
            currentNode = newNode;
        } else {
            NodeForPriorityQueue tempNode = currentNode;
            NodeForPriorityQueue prevNode = null;

            while (tempNode != null && priority <= tempNode.priority) {
                prevNode = tempNode;
                tempNode = tempNode.nextNode;
            }

            if (prevNode != null) {
                prevNode.nextNode = newNode;
            }
            newNode.nextNode = tempNode;

            if (tempNode == null) {
                previousNode = newNode;
            }
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

        NodeForPriorityQueue tempNode = currentNode;
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
        MyPriorityQueue<Integer> myPriorityQueue = new MyPriorityQueue<Integer>();

        myPriorityQueue.enqueue(1, 1);
        myPriorityQueue.enqueue(2,1);
        myPriorityQueue.enqueue(5, 4);
        myPriorityQueue.enqueue(3, 1);
        myPriorityQueue.enqueue(4, 3);

        System.out.println(myPriorityQueue);
    }
}
