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

import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

/**
 *
 * @author vlad
 */
public class TreeProcess {

    private final List<TreeType> plainList;
//    private final Node<TreeType> parentNode;
    private final Tree<TreeType> tree;

    public TreeProcess(List<TreeType> plainList) {
        this.plainList = plainList;
        this.tree = new Tree<TreeType>(new TreeType(1l, null, "_"));
    }

    public Tree<TreeType> getParentNode() {
        initParentNode();
        return tree;
    }

    private void initParentNode() {
        for (TreeType type : plainList) {
            if (type.getParentModelDetailId() == null) {
                tree.addLeaf(type);
            } else {
                tree.addLeaf(new TreeType(type.getParentModelDetailId(), null, "@@"), type);
            }
        }
    }

}
