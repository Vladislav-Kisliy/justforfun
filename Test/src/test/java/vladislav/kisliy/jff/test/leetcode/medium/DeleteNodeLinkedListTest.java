package vladislav.kisliy.jff.test.leetcode.medium;

import org.junit.Test;
import vladislav.kisliy.jff.test.leetcode.ListNode;

import static org.junit.Assert.*;

public class DeleteNodeLinkedListTest {

    @Test
    public void deleteNode() {
        ListNode forthNode = new ListNode(9);
        ListNode thirdNode = new ListNode(1, forthNode);
        ListNode secondNode = new ListNode(5, thirdNode);
        ListNode rootNode = new ListNode(4, secondNode);

        DeleteNodeLinkedList target = new DeleteNodeLinkedList();
        target.deleteNode(secondNode);
        System.out.println(rootNode);
    }
}