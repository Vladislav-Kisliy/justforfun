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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vladislav Kislyi <vladislav.kisliy@gmail.com>
 */
public class OrdersSummaryTest {

    @Test
    public void test1() {
        String l = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B";
        assertEquals("Buy: 29499 Sell: 0",
                OrdersSummary.balanceStatements(l));
        
        l = "ZNGA 1300 2.66 B, CLH15.NYM 50 56.32 B, OWW 1000 11.623 B, OGG 20 580.1 B,"
                + "INCORRECT 20 D1DD S";
        assertEquals("Buy: 29499 Sell: 0; Badly formed 1: INCORRECT 20 D1DD S ;",
                OrdersSummary.balanceStatements(l));
        
        l = "  ";
        assertEquals("Buy: 0 Sell: 0",
                OrdersSummary.balanceStatements(l));
        
        l = "GOOG 300 542.93 B, CLH15.NYM 50 56.32 S, CSCO 250 29.46 B, OGG 20 580.1 B";
        assertEquals("Buy: 181846 Sell: 2816",
                OrdersSummary.balanceStatements(l));
        
        l = "CAP 1300 .2 B, CLH16.NYM 50 56 S, OWW 1000 11 S, OGG 20 580.1 S";
        assertEquals("Buy: 260 Sell: 11602; Badly formed 2: CLH16.NYM 50 56 S ;OWW 1000 11 S ;",
                OrdersSummary.balanceStatements(l));
        
    }

}
