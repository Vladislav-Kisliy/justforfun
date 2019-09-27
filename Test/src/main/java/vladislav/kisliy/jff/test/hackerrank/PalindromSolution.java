package vladislav.kisliy.jff.test.hackerrank;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 20.09.19.
 */
public class PalindromSolution {

    private Deque<Character> deque = new LinkedList<>();
    private Deque<Character> queue = new LinkedList<>();

    void pushCharacter(char c) {
        queue.push(c);
    }

    public void enqueueCharacter(char c) {
        deque.addLast(c);
    }

    public char popCharacter() {
        return queue.pop();
    }

    public char dequeueCharacter() {
        return deque.pop();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        PalindromSolution p = new PalindromSolution();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length / 2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println("The word, " + input + ", is "
                + ((!isPalindrome) ? "not a palindrome." : "a palindrome."));
    }


}
