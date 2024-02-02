package List;


public class LinkedListTest {
    public static void main(String[] args) {
        initialPush();

    }

    public static void initialTest() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
    }

    public static void initialPush() {
        LinkedList<String> list = new LinkedList<>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.addFirst("q");
        list.add("v");
        list.removeLast();
        list.removeFirst();
        list.remove(1);

        System.out.println(list);

    }
}
