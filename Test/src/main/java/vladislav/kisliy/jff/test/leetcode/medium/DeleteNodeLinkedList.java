package vladislav.kisliy.jff.test.leetcode.medium;

import vladislav.kisliy.jff.test.leetcode.ListNode;

public class DeleteNodeLinkedList {

    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;

        nextNode.next = null;
    }
}
