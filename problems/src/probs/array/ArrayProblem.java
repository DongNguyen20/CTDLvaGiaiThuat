package probs.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayProblem {
    ArrayProblem(){}

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public int singleNumber(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i : nums){
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }
        return maps.keySet().stream().mapToInt(i -> i).filter(i -> maps.get(i) == 1).findFirst().orElse(-1);
    }

    public int maxProfit(int[] prices) {
        if(prices.length > 0) {
            int minPrice = prices[0];
            int maxProfit = 0;
            for(int i = 1; i < prices.length; i++) {
                minPrice = Math.min(minPrice, prices[i]);
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
            return maxProfit;
        }
        return 0;
    }

    public static int numOfSubarrays(int[] arr) {
//        List<List<Integer>> subArrays = new ArrayList<>();
        List<Integer> listOddSum = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
//            List<List<Integer>> rows = new ArrayList<>();
            List<Integer> currentList = new ArrayList<>();
            int countNumberOfOdd = 0;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] % 2 != 0) {
                    countNumberOfOdd++;
                }
                currentList.add(arr[j]);
                List<Integer> item = new ArrayList<>(currentList);
//                rows.add(item);
                if(countNumberOfOdd % 2!= 0) {
                    listOddSum.add(item.stream().mapToInt(Integer::intValue).sum());
                }
            }
//            subArrays.addAll(rows);
        }

//        List<Integer> listOddSum = subArrays.stream()
//                .filter(l -> countOddNumber(l) % 2 != 0)
//                .map(l -> l.stream().mapToInt(Integer::intValue).sum())
//                .toList();
        return listOddSum.size();
    }

    public static int numOfSubarrays2(int[] arr) {
        int countOdd = 0, result = 0, mod = 1_000_000_007;
        HashMap<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1); // Khởi tạo với tổng chẵn ban đầu

        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num % 2; // Chỉ quan tâm số lẻ
            result = (result + freq.getOrDefault(1 - prefixSum % 2, 0)) % mod;
            freq.put(prefixSum % 2, freq.getOrDefault(prefixSum % 2, 0) + 1);
        }

        return result;
    }

    public static boolean checkPowersOfThree(int n) {
        int current= 0;
        int i = n/3;
        while(i >= 0){
            current = (int) Math.pow(3, i);
            if(current <= n) {
                n -= current;
            }
            i--;
        }
        return n == 0;
    }

    private static int countOddNumber(List<Integer> list) {
        return (int) list.stream().filter(i -> i % 2!= 0).count();
    }

    public static long aVeryBigSum(List<Long> ar) {
        return ar.stream().mapToLong(Long::longValue).sum();
    }

    public static int superDigit(String n, int k) {
        // Write your code here
        String input = xString(n, k);
        return sumDigit(input, k);
    }

    public static String xString(String n, int k) {
        return n.repeat(k);
    }

    public static int sumDigit(String n, int k) {
        int sum = 0;
        if (k == 1 || n.length() == 1) return Integer.parseInt(n);
        for (char c : n.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sumDigit(String.valueOf(sum), k-1);
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        for(int i : nums){
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }
        return maps.keySet().stream().mapToInt(i -> i).filter(i -> maps.get(i) > nums.length/2).findFirst().orElse(-1);
    }

    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int j = 0;
        for(int i = 0; i < length; i++){
            if(nums[i]!=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }

    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0, windowSum = 0;
        for(int i = 0; i < k; i++){
            windowSum += nums[i];
        }
        maxSum = windowSum;

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return (double) maxSum/k;
    }

    public int longestOnes(int[] nums, int k) {
        int count = 0, maxCount = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) count++;
            while (count > k) {
                if (nums[left] == 0) count--;
                left++;
            }
            maxCount = Math.max(maxCount, right - left + 1);
        }
        return maxCount;
    }

    public boolean isSubsequence(String s, String t) {
        int count= 0;
        int indexChecking = 0;
        for (int i =0; i < s.length(); i++) {
            for (int j = indexChecking; j < t.length(); j++) {
                if (t.charAt(j) == s.charAt(i)) {
                    count++;
                    indexChecking = j + 1;
                    break;
                }
            }
        }
        return count == s.length();
    }

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, maxArea = 0;
        while(left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static int pivotIndex(int[] nums) {
        int index = -1;
        int sumBefore = 0;
        int sumAfter = 0;
        int mid = nums.length/2 - 1;
        sumBefore = sumArrange(nums, 0, mid);
        sumAfter = sumArrange(nums, mid + 1, nums.length - 1);

        while(sumBefore != sumAfter) {
            if(sumAfter == 0 || sumBefore == 0) return 0;
            if(mid == 0 || mid == nums.length - 1) {
                break;
            }
            index = mid;
            if(Math.abs(sumBefore) < Math.abs(sumAfter)) {
                mid++;
                sumAfter -= nums[mid];
            }else {
                mid--;
                sumBefore -= nums[mid];
            }
        }
        return index;
    }

    public int maxOperations(int[] nums, int k) {
        return 1;
    }

    private static int sumArrange(int[] nums, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += nums[i];
        }
        return sum;
    }

    // Two pointers
    public static int findMiddleNumber(List<Integer> listNumbers){
        int slowP = 0, fastP = 0;
        while(fastP < listNumbers.size()){
            slowP ++;
            fastP += 2;
        }
        return listNumbers.get(slowP - 1);
    }

    //merge interval
    public static  int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            }else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
