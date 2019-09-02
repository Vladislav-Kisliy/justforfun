package vladislav.kisliy.jff.test.hackerrank;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Vladislav Kisliy<vkisliy@productengine.com> on 31.08.19.
 */
public class StackSolutionTest {

    @Test
    public void testSolution() {
        // Stage 1
        assertTrue(StackSolution.checkInput("{}"));
        assertTrue(StackSolution.checkInput("()"));
        assertTrue(StackSolution.checkInput("[]"));
        assertTrue(StackSolution.checkInput("{}()"));
        assertTrue(StackSolution.checkInput("({()})"));

        assertFalse(StackSolution.checkInput("{}("));
        assertFalse(StackSolution.checkInput("{}())"));

        //Stage 2
        assertTrue(StackSolution.checkInput("[({})(())]"));
        assertTrue(StackSolution.checkInput("{{}}(()[])"));
        assertTrue(StackSolution.checkInput("((()))[]"));
        assertTrue(StackSolution.checkInput("{}{{{}}}{{{((()))}}}"));
        assertTrue(StackSolution.checkInput("({(){}()})()({(){}()})(){()}{}((()))"));
        assertTrue(StackSolution.checkInput("(){}{{}}()(()){{()()}}"));

        assertFalse(StackSolution.checkInput("(({()})))[["));
        assertFalse(StackSolution.checkInput("{}()))(()()({}}{}"));
        assertFalse(StackSolution.checkInput("}}}}"));
        assertFalse(StackSolution.checkInput("))))"));
        assertFalse(StackSolution.checkInput("{{{"));
        assertFalse(StackSolution.checkInput("((("));
        assertFalse(StackSolution.checkInput("{{{{{{{)))))))))))))))))))"));
        assertFalse(StackSolution.checkInput("{}{}("));
        assertFalse(StackSolution.checkInput("{}}}{}"));
        assertFalse(StackSolution.checkInput("()()()())))"));
        assertFalse(StackSolution.checkInput("(((((()()()"));
    }
}