package vladislav.kisliy.jff.test.hackerrank;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 30.08.19.
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class StackSolution {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            System.out.println(checkInput(input));
        }
    }

    public static boolean checkInput(String input) {
        Deque<Character> stack = new LinkedList<>();
        char[] inputBytes = input.toCharArray();
        for (int i = 0; i < inputBytes.length; i++) {
            char arrayChar = inputBytes[i];
            Character charStack = stack.peekFirst();
            if (charStack == null) {
                stack.addFirst(arrayChar);
            } else {
                if (arrayChar == 0x7d) {
                    if (charStack == 0x7b) {
                        stack.removeFirst();
                    } else {
                        break;
                    }
                } else if (arrayChar == 0x29) {
                    if (charStack == 0x28) {
                        stack.removeFirst();
                    } else {
                        break;
                    }
                } else if (arrayChar == 0x5d) {
                    if (charStack == 0x5b) {
                        stack.removeFirst();
                    } else {
                        break;
                    }
                } else {
                    stack.addFirst(arrayChar);
                }
            }


        }

        return stack.isEmpty();
    }
}
