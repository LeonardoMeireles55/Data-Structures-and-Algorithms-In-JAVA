package MyStack;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack<Integer> myStack = new MyStack<Integer>();

        myStack.push(10);
        myStack.push(10);

        myStack.pop();

        myStack.push(12);

        System.out.println(myStack);

        myStack.push(14);

        System.out.println(myStack.peek());

        System.out.println(myStack);
    }
}
