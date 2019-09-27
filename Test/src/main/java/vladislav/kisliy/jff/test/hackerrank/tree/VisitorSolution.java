package vladislav.kisliy.jff.test.hackerrank.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 16.09.19.
 */

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);

    @Override
    public String toString() {
        return "Tree{" +
                "value=" + value +
                ", color=" + color +
                ", depth=" + depth +
                '}';
    }
}

class TreeNode extends Tree {

    private List<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + getValue() +
                ", color=" + getColor() +
                ", depth=" + getDepth() +
                ", children=" + children.size() +
                '}';
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    private int counter = 0;

    public int getResult() {
        return counter;
    }

    public void visitNode(TreeNode node) {
//        System.out.println("Skip node: " +
//                node.getValue() + ", level: " + node.getDepth() + ", color: " + node.getColor());
    }

    public void visitLeaf(TreeLeaf leaf) {
//        System.out.println("Add leaf value: " +
//                leaf.getValue() + ", level: " + leaf.getDepth() + ", color: " + leaf.getColor());
        counter += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private int counter = 1;

    public int getResult() {
        return counter;
    }

    public void visitNode(TreeNode node) {
        calcTree(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
        calcTree(leaf);
    }

    private void calcTree(Tree treeElement) {
        if (treeElement.getColor() == Color.RED) {
            int elementValue = treeElement.getValue();
            if (elementValue == 0) {
                elementValue = 1;
            }
            counter = counter * elementValue;
        }
    }
}

class FancyVisitor extends TreeVis {
    int nodesSum = 0;
    int leavesSum = 0;

    public int getResult() {

        return Math.abs(nodesSum - leavesSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nodesSum += node.getValue();
//            System.out.println("Even node: " +
//                    node.getValue() + ", level: " + node.getDepth() + ", color: " + node.getColor() + ". acc =" + nodesSum);
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            leavesSum += leaf.getValue();
//            System.out.println("Gree leaf: " +
//                    leaf.getValue() + ", level: " + leaf.getDepth() + ", color: " + leaf.getColor() + ". acc =" + leavesSum);
        }
    }
}

class TreeAggr {

    private int type;
    private int value;
    private Color color;
    private int depth;

    public TreeAggr(int type, int value, Color color) {
        this.type = type;
        this.value = value;
        this.color = color;
    }

    public int getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}

public class VisitorSolution {

    private static Queue<TreeAggr> queue = new LinkedList<>();

    public static void display01(TreeAggr head) {
        if (head == null) {
            while (!queue.isEmpty()) {
                TreeAggr start = queue.poll();
                if (start.getType() == 1) {
                    System.out.print("Node: ");
                } else {
                    System.out.print("Leaf: ");
                }

                System.out.print(start.getValue());
//                )
//                queue.addAll(start.)

            }
        } else {
            queue.add(head);
//            display(null);
        }

        TreeAggr start = head;
        while (start != null) {
            if (start.getType() == 1) {
                System.out.print("Node: ");
            } else {
                System.out.print("Leaf: ");
            }

            System.out.print(start.getValue());
        }
    }

    public static void display(TreeAggr[] list) {
        for (TreeAggr node : list) {
            if (node.getType() == 1) {
                System.out.print("Node value: ");
            } else {
                System.out.print("Leaf value:  ");
            }

            System.out.println(node.getValue() + ", level: " + node.getDepth() + ", color: " + node.getColor());
        }

    }

    public static Tree solve() throws FileNotFoundException {
//        397762
//        584910388
//        157653

//        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/input05.txt")));


//        45136
//        56618427
//        14333
//        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/input01.txt")));

//        41684
//        76092041
//        16795
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/input02.txt")));

//        InputStream in = new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/input00.txt");
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);
        int N = sc.nextInt();

        int[] nodeValues = new int[N];
        int counter = 0;
        while (N-- > 0) {
            int value = sc.nextInt();
            nodeValues[counter] = value;
            counter++;
        }

        counter = 0;
        N = nodeValues.length;
        Color[] colorValues = new Color[N];
        while (N-- > 0) {
            int value = sc.nextInt();
            if (value == 0) {
                colorValues[counter] = Color.RED;
            } else {
                colorValues[counter] = Color.GREEN;
            }
            counter++;
        }
        Map<Integer, List<Integer>> links = new HashMap<>();

        while (sc.hasNext()) {
            int parent = sc.nextInt() - 1;
            int child = sc.nextInt() - 1;
            List<Integer> integers = links.get(parent);
            if (integers == null) {
                List<Integer> elements = new ArrayList<>();
                elements.add(child);
                links.put(parent, elements);
            } else {
                integers.add(child);
            }
        }
        TreeAggr[] treeAggrs = new TreeAggr[nodeValues.length];

        for (int i = 0; i < treeAggrs.length; i++) {
            if (links.containsKey(i)) {
                treeAggrs[i] = new TreeAggr(1, nodeValues[i], colorValues[i]);
            } else {
                treeAggrs[i] = new TreeAggr(0, nodeValues[i], colorValues[i]);
            }
        }
//        System.out.println("links =" + links);
        for (Map.Entry<Integer, List<Integer>> entry : links.entrySet()) {
            TreeAggr element = treeAggrs[entry.getKey()];
            for (Integer nodeIndex : entry.getValue()) {
                treeAggrs[nodeIndex].setDepth(element.getDepth() + 1);
            }
        }

//        display(treeAggrs);

        Tree[] trees = new Tree[nodeValues.length];
        for (int i = 0; i < treeAggrs.length; i++) {
            TreeAggr element = treeAggrs[i];
            if (element.getType() == 1) {
                trees[i] = new TreeNode(element.getValue(), element.getColor(), element.getDepth());
            } else {
                trees[i] = new TreeLeaf(element.getValue(), element.getColor(), element.getDepth());
            }
        }

//        System.out.println("before linking =" + Arrays.toString(trees));

        for (Map.Entry<Integer, List<Integer>> entry : links.entrySet()) {
            TreeNode treeNone = (TreeNode) trees[entry.getKey()];
            for (Integer nodeIndex : entry.getValue()) {
                treeNone.addChild(trees[nodeIndex]);
            }
        }

//        System.out.println("after linking =" + Arrays.toString(trees));

        return trees[0];
    }

    public static void main(String[] args) throws FileNotFoundException {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();
        System.out.println("---------");
        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
