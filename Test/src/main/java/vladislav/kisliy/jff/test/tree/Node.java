/*
 * Copyright (C) 2016 vlad
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
package vladislav.kisliy.jff.test.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vlad
 */
public class Node<T> {

    private final List<Node<T>> children = new ArrayList<Node<T>>();
    private Node<T> parent = null;
    private T data = null;
    private Integer level = 0;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
//        parent.addChild(this);
        this.parent = parent;
    }

    public void addChild(T data) {
        Node<T> child = new Node<T>(data);
        addChild(child);
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
//        child.setIndex(children.size());
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if (this.children.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public void removeParent() {
        this.parent = null;
    }

//    public Integer getIndex() {
//        return index;
//    }
//
//    public void setIndex(Integer index) {
//        this.index = index;
//    }
    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
