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
package vladislav.kisliy.jff.test.codewars;

import java.util.ArrayList;
import java.util.List;

public class Josephus {

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> result = new ArrayList<>();
        List<Integer> indexList = generateIndexList(items.size(), k);
        for (Integer index : indexList) {
            result.add(items.get(index));
        }
        return result;
    }

    private static List<Integer> generateIndexList(int size, int k) {
        List<Integer> positionList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            positionList.add(i);
        }
        List<Integer> resultList = new ArrayList<>();
        int counter = 1;
        if (k > 1) {
            while (positionList.size() > 1) {
                for (Integer index : positionList) {
                    if (counter == k) {
                        resultList.add(index);
                        counter = 0;
                    }
                    counter++;
                }
                positionList.removeAll(resultList);
            }
        }
        resultList.addAll(positionList);
        return resultList;
    }
    
    
//    public static <T> List<T> josephusPermutation(final List<T> items,
//      final int k) {
//    int len = items.size();
//    int n = len;
//    
//    int[] indexArr = new int[len];
//    int m =k-1;//start from 0,not 1
//    //f(m,i)=(((m%(n-i)+k)%(n-i+1)+k)%(n-i+2)+k...)%n
//    for (int i = 0; i < len; i++) {
//      indexArr[i]=m%(len-i);
//    }
//    int j = 1;
//    while (j <len) {
//      for (int i = 0; i<len-j; i++) {
//        indexArr[i+j] = (indexArr[i+j]+k) % (len-i);
//      }
//      j++;
//    }
////    System.out.println(Arrays.toString(indexArr));
//    return Arrays.stream(indexArr)
//        .mapToObj(i -> items.get(i))
//        .collect(Collectors.toList());
//
//  }
    
//    public static Collection<Object> josephusPermutation(final List<Object> items, final int k) {
//    Collection<Object> permutation = new ArrayList<Object>();
//    int position = 0;
//        while (items.size() > 0) {
//            position = (position + k - 1) % items.size();
//            permutation.add(items.remove((int) position));
//        }
//        return permutation;
//    }

}
