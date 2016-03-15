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

public class DirReduction {

    public static String[] dirReduc(String[] arr) {
        if (arr == null) {
            return null;
        }
        String[] result = arr;
        if (arr.length > 1) {
            boolean needRefresh;
            List<Direction> directions = stringToEnum(arr);
            do {
                needRefresh = false;
                for (int i = 0; i < directions.size() - 1; i++) {
                    if (directions.get(i).isOpposite(directions.get(i + 1))) {
                        directions.remove(i + 1);
                        directions.remove(i);
                        needRefresh = true;
                    }
                }
            } while (needRefresh);
            result = enumToString(directions);
        }
        return result;
    }

    private static List<Direction> stringToEnum(String[] arr) {
        List<Direction> directions = new ArrayList<>();
        for (String line : arr) {
            directions.add(Direction.valueOf(line));
        }
        return directions;
    }

    private static String[] enumToString(List<Direction> directions) {
        String[] result = new String[directions.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = directions.get(i).name();
        }
        return result;
    }
    
//    public static String[] dirReduc(String[] arr) {
//        final Stack<String> stack = new Stack<>();
//
//        for (final String direction : arr) {
//            final String lastElement = stack.size() > 0 ? stack.lastElement() : null;
//
//            switch(direction) {
//                case "NORTH": if ("SOUTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
//                case "SOUTH": if ("NORTH".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
//                case "EAST":  if ("WEST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
//                case "WEST":  if ("EAST".equals(lastElement)) { stack.pop(); } else { stack.push(direction); } break;
//            }
//        }
//        return stack.stream().toArray(String[]::new);
//    }

    private enum Direction {
        NORTH {
            @Override
            public boolean isOpposite(Direction direction) {
                return direction == SOUTH;
            }
        }, SOUTH {
            @Override
            public boolean isOpposite(Direction direction) {
                return direction == NORTH;
            }
        }, EAST {
            @Override
            public boolean isOpposite(Direction direction) {
                return direction == WEST;
            }
        }, WEST {
            @Override
            public boolean isOpposite(Direction direction) {
                return direction == EAST;
            }
        };
        public boolean isOpposite(Direction direction) {
            return false;
        }
    }
}
