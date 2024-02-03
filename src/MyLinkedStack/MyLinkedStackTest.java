package MyLinkedStack;

public class MyLinkedStackTest {
    public static void main(String[] args) {
        MyLinkedStack<Integer> myLinkedStack = new MyLinkedStack<Integer>();

        myLinkedStack.push(1);
        myLinkedStack.push(2);
        myLinkedStack.push(3);
        myLinkedStack.push(4);
        myLinkedStack.push(5);
        myLinkedStack.push(6);
        myLinkedStack.push(7);
        myLinkedStack.pop();

        System.out.println(myLinkedStack);

    }
}
