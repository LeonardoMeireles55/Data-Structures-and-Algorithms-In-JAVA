package MyStack;

public class FixedSizeStackTest {
    public static void main(String[] args) {
        FixedSizeStack fixedSizeStack = new FixedSizeStack<Integer>(4);

        fixedSizeStack.push(10);
        fixedSizeStack.push(10);
        fixedSizeStack.push(10);
        fixedSizeStack.push(14);

        fixedSizeStack.pop();

        fixedSizeStack.push(15);


        System.out.println(fixedSizeStack);
    }
}
