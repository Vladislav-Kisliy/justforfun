package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;
import vladislav.kisliy.jff.test.leetcode.ListNode;

import static org.junit.Assert.*;

public class PalindromeLinkedListTest {

    @Test
    public void isPalindrome() {
        PalindromeLinkedList target = new PalindromeLinkedList();

        ListNode forthNode = new ListNode(1);
        ListNode thirdNode = new ListNode(2, forthNode);
        ListNode secondNode = new ListNode(2, thirdNode);
        ListNode rootNode = new ListNode(1, secondNode);

        assertTrue(target.isPalindrome(rootNode));
        secondNode.next = null;
        assertFalse(target.isPalindrome(rootNode));

        secondNode.val = 1;
        secondNode.next = thirdNode;
        assertFalse(target.isPalindrome(rootNode));
    }
}
