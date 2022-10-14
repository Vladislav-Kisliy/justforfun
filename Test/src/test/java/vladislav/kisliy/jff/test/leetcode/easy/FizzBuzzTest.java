package vladislav.kisliy.jff.test.leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    @Test
    public void fizzBuzz() {
        FizzBuzz target = new FizzBuzz();

        List<String> expected = new ArrayList<>();
        expected.add("1");
        expected.add("2");
        expected.add("Fizz");
        assertEquals(expected, target.fizzBuzz(3));

        expected.add("4");
        expected.add("Buzz");
        assertEquals(expected, target.fizzBuzz(5));

        expected.add("Fizz");
        expected.add("7");
        expected.add("8");
        expected.add("Fizz");
        expected.add("Buzz");
        expected.add("11");
        expected.add("Fizz");
        expected.add("13");
        expected.add("14");
        expected.add("FizzBuzz");
        assertEquals(expected, target.fizzBuzz(15));
    }
}