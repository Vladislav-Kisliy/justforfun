package vladislav.kisliy.jff.test.hackerrank.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 24.09.19.
 */
class Node {
    Node left, right;
    int data;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BSTSolution {

    public static int getMaxHeight(Node root, int height) {
        int leftHeight = 0, righHeight = 0;
        if (root.right == null && root.left == null) {
            return height;
        }

        if (root.left != null) {
            leftHeight = getMaxHeight(root.left, height + 1);
        }
        if (root.right != null) {
            leftHeight = getMaxHeight(root.right, height + 1);
        }

        int result;
        if (leftHeight > righHeight) {
            result = leftHeight;
        } else {
            result = righHeight;
        }

//        System.out.println("result = " + result);
        return result;
    }

    public static int getHeight(Node root) {
        //Write your code here
        int leftHeight = 0, righHeight = 0;
        if (root.left != null) {
//            System.out.println("Choose left");
            leftHeight = getMaxHeight(root.left, 1);
        }
        if (root.right != null) {
//            System.out.println("Choose right");
            righHeight = getMaxHeight(root.right, 1);
        }
        int result;
        if (leftHeight > righHeight) {
            result = leftHeight;
        } else {
            result = righHeight;
        }
        return result;
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        levelOrder(root);
//        System.out.println(height);
    }


    private static Queue<Node> queue = new LinkedList<>();

    private static void levelOrder(Node root) {
        if (root == null) {
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                System.out.print(node.data + " ");
            }
        } else {
            queue.add(root);
            levelOrder(null);
        }
    }
}
