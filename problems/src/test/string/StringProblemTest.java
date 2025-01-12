package test.string;

import probs.string.StringProblem;

public class StringProblemTest {
    StringProblemTest(){}

    public static void testPalindromeNumber() {
        int x = -121;
        boolean result = StringProblem.isPalindrome(x);
        System.out.println("RESULT: " + result);
    }
}
