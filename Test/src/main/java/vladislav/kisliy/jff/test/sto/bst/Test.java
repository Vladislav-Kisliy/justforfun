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

import java.util.HashMap;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class Test {

    public static void main(String[] args) {

        //CREATION
        System.out.println("CREATION");
        BinarySearchTree tree = new BinarySearchTree();

        int[] a = {54, 32, 76, 7, 44, 63, 99};

        tree.createBST(a);

        System.out.println();
        System.out.print("The root of the tree is: ");
        System.out.println();

        System.out.print("Maximum Node is: ");
        tree.inorder(tree.maximum(tree.getRoot()));
        System.out.println();

        System.out.print("Minimum Node is: ");
        tree.inorder(tree.minimum(tree.getRoot()));
        System.out.println();

        //INSERTION
        System.out.println("INSERTION");
        tree.insert(new Node(25));
        tree.inorder(tree.getRoot());

        tree.insert(new Node(485));
        System.out.println();
        tree.inorder(tree.getRoot());

        tree.insert(new Node(12));
        System.out.println();
        tree.inorder(tree.getRoot());
        
        Node node5 = new Node(5);
        tree.insert(node5);
        System.out.println();
        tree.inorder(tree.getRoot());

        tree.insert(new Node(9985));
        System.out.println();
        tree.inorder(tree.getRoot());

        System.out.println();
        System.out.print("Maximum Node is: ");
        tree.inorder(tree.maximum(tree.getRoot()));
        System.out.println();

        System.out.print("Minimum Node is: ");
        tree.inorder(tree.minimum(tree.getRoot()));
        System.out.println();

        //SEARCH
        System.out.println("SEARCH");
        tree.inorder(tree.search(tree.getRoot(), 32));
        System.out.println();

        //DELETION
        System.out.println("DELETION");
        tree.delete(node5);
        System.out.println();
        tree.inorder(tree.getRoot());
        new HashMap();
        
    }

}
