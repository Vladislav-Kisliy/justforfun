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
package vladislav.kisliy.jff.test.codewars;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class OrdersSummary {

    public static String balanceStatements(String lst) {
        double buyAmount = 0;
        double sellAmount = 0;
        System.out.println("Input line ="+lst);
        List<String> errorList = new ArrayList<>();
        if (lst != null && !lst.trim().isEmpty()) {
            String[] lines = lst.split(",");
            List<Order> list = new ArrayList<>();
            for (String line : lines) {
                list.add(new Order(line.trim()));
            }
            for (Order order : list) {
                switch (order.type) {
                    case BUY:
                        buyAmount += order.cost;
                        break;
                    case SELL:
                        sellAmount += order.cost;
                        break;
                    default:
                        errorList.add(order.originLine);
                        break;
                }
            }
        }
        StringBuilder strBuilder = new StringBuilder("Buy: ");
        strBuilder.append(Math.round(buyAmount))
                .append(" Sell: ")
                .append(Math.round(sellAmount));
        if (errorList.size() > 0) {
            strBuilder.append("; Badly formed ")
                    .append(errorList.size())
                    .append(": ");
            errorList.forEach((line) -> {
                strBuilder.append(line)
                        .append(" ;");
            });
        }
        return strBuilder.toString();
    }

    public enum Type {
        BUY, SELL, INCORRECT
    };

    public static class Order {

        public String originLine;
        private int quantity;
        private double price;
        private double cost;
        private Type type = Type.INCORRECT;

        public Order(String line) {
            originLine = line;
            String[] splitLine = line.split(" ");
            if (splitLine.length == 4 &&
                    splitLine[2].contains(".")) {
                try {
                    quantity = Integer.valueOf(splitLine[1]);
                    price = Double.valueOf(splitLine[2]);
                    cost = price * quantity;
                    if ("B".equals(splitLine[3])) {
                        type = Type.BUY;
                    }
                    if ("S".equals(splitLine[3])) {
                        type = Type.SELL;
                    }
                } catch (NumberFormatException ex) {
                }
            }
        }

        public double getCost() {
            return cost;
        }
    }
}
