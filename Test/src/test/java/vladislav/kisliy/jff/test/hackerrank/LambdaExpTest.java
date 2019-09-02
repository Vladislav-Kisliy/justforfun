package vladislav.kisliy.jff.test.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 02.09.19.
 */
public class LambdaExpTest {

    @Test
    public void testPalindrom() {
        LambdaExp lambdaExp = new LambdaExp();
        assertTrue(lambdaExp.isPalindrome(22));
        assertTrue(lambdaExp.isPalindrome(848));
        assertTrue(lambdaExp.isPalindrome(8845488));
        assertTrue(lambdaExp.isPalindrome(3333));
    }

    @Test
    public void testPrime() {
        LambdaExp lambdaExp = new LambdaExp();
//        assertTrue(lambdaExp.isPrime(17));
//        assertTrue(lambdaExp.isPrime(1289));
//        assertTrue(lambdaExp.isPrime(1609));
//        assertTrue(lambdaExp.isPrime(107));

        assertFalse(lambdaExp.isPrime(22));
        assertFalse(lambdaExp.isPrime(2232));
        assertFalse(lambdaExp.isPrime(25));
        assertFalse(lambdaExp.isPrime(2858));
    }

    @Test
    public void testOdd() {
        LambdaExp lambdaExp = new LambdaExp();
        assertFalse(lambdaExp.isOdd(2232));
        assertTrue(lambdaExp.isOdd(25));
    }

}