package test.array;

import probs.array.ArrayProblem;

public class ArrayProblemTest {
    ArrayProblemTest(){}

    public static void testRemoveElement() {
        int[] nums = {3, 2, 2, 3}; // Input array
        int val = 3; // Value to remove
        int[] expectedNums = {2, 2}; // The expected answer with correct length.
        int removeElement = ArrayProblem.removeElement(nums, val);
        System.out.println("RESULT: " + removeElement);
    }
}
