package vladislav.kisliy.jff.test.leetcode.easy;

import vladislav.kisliy.jff.test.leetcode.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class MiddleLinkedList {

    private Deque<ListNode> queue = new LinkedList<>();

    public ListNode middleNode(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null) {
            queue.push(currentNode);
            currentNode = currentNode.next;
        }

        int size = queue.size();
        int counter = 0;
        int halfSize = size / 2;
        int mid = (size % 2 == 0) ? halfSize : halfSize + 1;
        while (counter < mid) {
            currentNode = queue.pop();
            counter++;
        }

        return currentNode;
    }

}
