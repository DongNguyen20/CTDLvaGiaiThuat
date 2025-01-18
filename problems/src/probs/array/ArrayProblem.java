package probs.array;

import java.util.HashMap;
import java.util.Map;

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
}
