package MyLeetCode;

import MyLinkedList.LinkedList;
import MyLinkedList.NodeForList;

public class AddTwoNumbers {

    public LinkedList<Integer> solution(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        NodeForList<Integer> currentNode1 = l1.initialNodeForList;
        NodeForList<Integer> currentNode2 = l2.initialNodeForList;

        int carry = 0;
        LinkedList<Integer> result = new LinkedList<>();

        while (currentNode1 != null || currentNode2 != null) {
            int x = (currentNode1 != null) ? currentNode1.getElement() : 0;
            int y = (currentNode2 != null) ? currentNode2.getElement() : 0;

            int sum = carry + x + y;
            carry = sum / 10;
            result.add(sum % 10);

            if (currentNode1 != null) {
                currentNode1 = currentNode1.getNext();
            }
            if (currentNode2 != null) {
                currentNode2 = currentNode2.getNext();
            }
        }

        if (carry > 0) {
            result.add(carry);
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();

        list1.add(2);
        list1.add(4);
        list1.add(3);

        list2.add(5);
        list2.add(6);
        list2.add(6);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        LinkedList<Integer> result = addTwoNumbers.solution(list1, list2);

        System.out.println(result);
    }
}
