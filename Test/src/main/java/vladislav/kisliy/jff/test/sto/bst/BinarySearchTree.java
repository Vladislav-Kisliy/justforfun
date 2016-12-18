/*
 * Copyright (C) 2016 Vladislav Kislyi <vladislav.kisliy@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package vladislav.kisliy.jff.test.sto.bst;

public class BinarySearchTree {

//Properties
    private Node root;

//Getters and Setters
    Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

//Search Method
    public Node search(Node x, int k) {
        if (x == null || k == x.getKey()) {
            return x;
        }
        if (k < x.getKey()) {
            return search(x.getLeft(), k);
        } else {
            return search(x.getRight(), k);
        }
    }

//Insertion Method
    public void insert(Node z) {
        Node y = null;
        Node x = getRoot();
        while (x != null) {
            y = x;
            if (z.getKey() < x.getKey()) {
                x = x.getLeft();
            } else {
                x = x.getRight();
            }
        }
        z.setParent(y);
        if (y == null) {
            setRoot(z);
        } else if (z.getKey() < y.getKey()) {
            y.setLeft(z);
        } else {
            y.setRight(z);
        }

    }

//Printer Method
    public void inorder(Node x) {
        if (x != null) {
            inorder(x.getLeft());
            System.out.print(x.getKey() + " ");
            inorder(x.getRight());
        }
    }

//Transplant Method
    public void transplant(Node u, Node v) {
        if (u.getParent() == null) {
            setRoot(v);
        } else if (u == u.getParent().getLeft()) {
            u.getParent().setLeft(v);
        } else {
            u.getParent().setRight(v);
        }
        if (v != null) {
            v.setParent(u.getParent());
        }
    }

//Deletion Method
    public void delete(Node x) {
        if (x.getLeft() == null) {
            transplant(x, x.getRight());
        } else if (x.getRight() == null) {
            transplant(x, x.getLeft());
        } else {
            Node y = minimum(x.getRight());
            if (y.getParent() != x) {
                transplant(y, y.getRight());
                y.setRight(x.getRight());
                y.getRight().setParent(y);
            }
            transplant(x, y);
            y.setLeft(x.getLeft());
            y.getLeft().setParent(y);
        }
    }

//Maximum Finder
    public Node maximum(Node x) {
        while (x.getRight() != null) {
            x = x.getRight();
        }
        return x;
    }

//Minimum Finder
    public Node minimum(Node x) {
        while (x.getLeft() != null) {
            x = x.getLeft();
        }
        return x;
    }

//Example Tree Constructor
    public void createBST(int[] a) {

        for (int i = 0; i < a.length; i++) {
            Node nodeToBeAdded = new Node(a[i]);
            insert(nodeToBeAdded);
        }
        inorder(root);
    }

}
