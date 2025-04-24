package MyLinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        initialPush();
        initialTest();

    }

    public static void initialTest() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        System.out.println(list);
    }

    public static void initialPush() {
        LinkedList<String> list = new LinkedList<String>();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.addFirst("q");
        list.add("v");
        list.removeLast();
        list.removeFirst();
        list.remove(1);

        System.out.println(list.search(3));

    }
}
