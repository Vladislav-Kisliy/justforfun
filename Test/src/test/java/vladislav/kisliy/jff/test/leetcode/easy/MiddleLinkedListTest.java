package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;
import vladislav.kisliy.jff.test.leetcode.ListNode;

import static org.junit.Assert.*;

public class MiddleLinkedListTest {

    @Test
    public void middleNode() {
        MiddleLinkedList target = new MiddleLinkedList();

        ListNode fifthNode = new ListNode();
        fifthNode.val = 5;
        ListNode forthNode = new ListNode();
        forthNode.val = 4;
        forthNode.next = fifthNode;
        ListNode thirdNode = new ListNode();
        thirdNode.val = 3;
        thirdNode.next = forthNode;
        ListNode secondNode = new ListNode();
        secondNode.val = 2;
        secondNode.next = thirdNode;
        ListNode startNode = new ListNode();
        startNode.val = 1;
        startNode.next = secondNode;

        assertEquals(thirdNode, target.middleNode(startNode));
    }
}