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

import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void testFib0() {
        testFib(0, 0);
    }

    @Test
    public void testFib1() {
        testFib(1, 1);
    }

    @Test
    public void testFib2() {
        testFib(1, 2);
    }

    @Test
    public void testFib3() {
        testFib(2, 3);
    }

    @Test
    public void testFib4() {
        testFib(3, 4);
    }

    @Test
    public void testFib5() {
        testFib(5, 5);
    }
    
    @Test
    public void testFib6() {
        testFib(8, 6);
    }
    
    @Test
    public void testFibMinus6() {
        testFib(-8, -6);
    }
    
    @Test
    public void testFib10() {
        testFib(55, 10);
    }
    
    @Test
    public void testFib15() {
        testFib(610, 15);
    }
    
    @Test
    public void testFib20() {
        testFib(6765, 20);
    }
    
    @Test
    public void testFibMinus25() {
        testFib(75025, -25);
    }
    
    @Test
    public void testFib100() {
        BigInteger found = Fibonacci.fib(BigInteger.valueOf(100));
        assertEquals(new BigInteger("354224848179261915075"), found);
    }
    
    @Test
    public void testFib200() {
        BigInteger found = Fibonacci.fib(BigInteger.valueOf(200));
        assertEquals(new BigInteger("280571172992510140037611932413038677189525"), found);
    }

    private static void testFib(long expected, long input) {
        BigInteger found;
        try {
            found = Fibonacci.fib(BigInteger.valueOf(input));
        } catch (Throwable e) {
            // see https://github.com/Codewars/codewars.com/issues/21
            throw new AssertionError("exception during test: " + e, e);
        }
        assertEquals(BigInteger.valueOf(expected), found);
    }
    
    @Test
    public void example1(){
        assertEquals(Fibonacci.getFibNumb(193150), 5);
    }


    @Test
    public void example2(){
        assertEquals(Fibonacci.getFibNumb(300), 0);
    }
    
    @Test
    public void example3(){
        assertEquals(Fibonacci.getFibNumb(20001), 6);
    }
//    private static void testFib(long expected, long input) {
//        long found;
//        try {
//            found = Fibonacci.fib(input);
//        } catch (Throwable e) {
//            // see https://github.com/Codewars/codewars.com/issues/21
//            throw new AssertionError("exception during test: " + e, e);
//        }
//        assertEquals(expected, found);
//    }

}
