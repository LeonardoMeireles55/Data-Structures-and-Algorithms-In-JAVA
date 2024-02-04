package MyStack;

public class FixedSizeStackTest {
    public static void main(String[] args) {
        FixedSizeStack<Integer> fixedSizeStack = new FixedSizeStack<Integer>(4);

        fixedSizeStack.push(10);
        fixedSizeStack.push(11);
        fixedSizeStack.push(12);
        fixedSizeStack.push(13);

        fixedSizeStack.pop();
        fixedSizeStack.pop();
        fixedSizeStack.push(13);
        fixedSizeStack.pop();



        System.out.println(fixedSizeStack);
    }
}
