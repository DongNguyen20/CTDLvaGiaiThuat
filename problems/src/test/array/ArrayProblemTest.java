package test.array;

import probs.array.ArrayProblem;

import java.util.LinkedList;
import java.util.List;

public class ArrayProblemTest {
    ArrayProblemTest(){}

    public static void testRemoveElement() {
        int[] nums = {3, 2, 2, 3}; // Input array
        int val = 3; // Value to remove
        int[] expectedNums = {2, 2}; // The expected answer with correct length.
        int removeElement = ArrayProblem.removeElement(nums, val);
        System.out.println("RESULT: " + removeElement);
    }

    public static void testFindMiddleNumber() {
        List<Integer> list = new LinkedList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(4);
        int midNum = ArrayProblem.findMiddleNumber(list);
        System.out.println("RESULT: " + midNum);
    }

    public static void testMergeIntervals() {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}}; // Input array
        int[][] mergedIntervals = ArrayProblem.mergeIntervals(intervals);
        System.out.println("RESULT: " );
        for (int[] interval : mergedIntervals) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }

    public static void testMoveZeroes() {
        int[] nums = {0, 1, 0, 3, 12}; // Input array
        ArrayProblem.moveZeroes(nums);
        System.out.println("RESULT: " );
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void testPivotIndex() {
        int[] nums = {1,7,3,6,5,6};
        int[] nums2 = {2,1,-1};
        int[] nums3 = {1,2,3};
        int[] nums4 = {-1,-1,-1,-1,-1,0};
        System.out.println(ArrayProblem.pivotIndex(nums4));
    }

    public static void testNumOfSubArray() {
        int[] nums = {1,2,3,4,5,6,7};
        System.out.println(ArrayProblem.numOfSubarrays2(nums));
    }

    public static void testCheckPowersOfThree(){
        System.out.println(ArrayProblem.checkPowersOfThree(91));
    }

    public static void testSuperDigit() {
        System.out.println(ArrayProblem.superDigit("9875", 4));
    }
}
