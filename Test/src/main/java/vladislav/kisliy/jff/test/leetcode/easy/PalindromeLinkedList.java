package vladislav.kisliy.jff.test.leetcode.easy;

import vladislav.kisliy.jff.test.leetcode.ListNode;

import java.util.Deque;
import java.util.LinkedList;

public class PalindromeLinkedList {

    private Deque<Integer> queue = new LinkedList<>();

    public boolean isPalindrome(ListNode head) {
        ListNode currentNode = head;
        while (currentNode != null) {
            queue.push(currentNode.val);
            currentNode = currentNode.next;
        }

        boolean isPalindrome = true;
        int size = queue.size();
        int counter = 0;
        int mid = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);
        currentNode = head;
        while (currentNode != null) {
            if (queue.pop() != currentNode.val && counter < mid) {
                isPalindrome = false;
                break;
            }
            currentNode = currentNode.next;
            counter++;
        }

        return isPalindrome;
    }
}
