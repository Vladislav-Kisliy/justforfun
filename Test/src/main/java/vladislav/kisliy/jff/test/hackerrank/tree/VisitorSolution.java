package vladislav.kisliy.jff.test.hackerrank.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
    private int leavesCounter = 0;
    private int nodesCounter = 0;

    public int getResult() {
        return counter;
    }

    public void visitNode(TreeNode node) {
        nodesCounter++;
        System.out.println("Skip node: " +
                node.getValue() + ", level: " + node.getDepth() + ", color: " + node.getColor() +
                ". nodes =" + nodesCounter);
    }

    public void visitLeaf(TreeLeaf leaf) {
        counter += leaf.getValue();
        leavesCounter++;
        System.out.println("Add leaf value: " +
                leaf.getValue() + ", level: " + leaf.getDepth() + ", color: " + leaf.getColor() +
                ", counter =" + counter + ", leaves =" + leavesCounter);
    }
}

class ProductOfRedNodesVisitor extends TreeVis {

    private long counter = 1;
    private final int M = 1000000007;

    public int getResult() {
        return (int) counter;
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
            counter = (counter * elementValue) % M;
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
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            leavesSum += leaf.getValue();
        }
    }
}

public class VisitorSolution {

    public static Tree solve() throws FileNotFoundException {
//        397762
//        584910388
//        157653
//        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/input05.txt")));

//        24
//        40
//        15
//        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/input00.txt")));


//        45136
//        56618427
//        14333
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/input01.txt")));

//        41684
//        76092041
//        16795
//        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/input02.txt")));

//        InputStream in = new FileInputStream("/home/vlad/work/projects/gits/justforfun/Test/src/main/resources/input00.txt");
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(in);
        int N = sc.nextInt();

        int[] nodesValues = new int[N];

        Map<Integer, Set<Integer>> links = new HashMap<>(N);

        Color[] colorValues = new Color[N];
        for (int i = 0; i < N; i++) {
            nodesValues[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            colorValues[i] = sc.nextInt() == 0 ? Color.RED : Color.GREEN;
        }

        for (int i = 0; i < N - 1; i++) {
            int parent = sc.nextInt();
            int child = sc.nextInt();

            /* !!! Edges are undirected */
            Set<Integer> parentNeighbors = links.get(parent);
            if (parentNeighbors == null) {
                parentNeighbors = new HashSet<>();
                links.put(parent, parentNeighbors);
            }
            parentNeighbors.add(child);

            /* !!! Edges are undirected */
            Set<Integer> childNeighbors = links.get(child);
            if (childNeighbors == null) {
                childNeighbors = new HashSet<>();
                links.put(child, childNeighbors);
            }
            childNeighbors.add(parent);
        }
        sc.close();

        if (N == 1) {
            return new TreeLeaf(nodesValues[0], colorValues[0], 0);
        }

        TreeNode root = new TreeNode(nodesValues[0], colorValues[0], 0);
        addChildren(root, 1, links, nodesValues, colorValues);

        return root;
    }

    private static void addChildren(TreeNode parent, Integer parentNum,
                                    Map<Integer, Set<Integer>> links,
                                    int[] nodesValues, Color[] colorValues) {
        for (Integer treeNum : links.get(parentNum)) {
            links.get(treeNum).remove(parentNum);

            Set<Integer> grandChildren = links.get(treeNum);
            boolean shouldBeNode = (grandChildren != null && !grandChildren.isEmpty());
            Tree tree;
            if (shouldBeNode) {
                tree = new TreeNode(nodesValues[treeNum - 1], colorValues[treeNum - 1], parent.getDepth() + 1);
                addChildren((TreeNode) tree, treeNum, links, nodesValues, colorValues);
                parent.addChild(tree);
            } else {
                tree = new TreeLeaf(nodesValues[treeNum - 1], colorValues[treeNum - 1], parent.getDepth() + 1);
                parent.addChild(tree);
            }
        }
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
