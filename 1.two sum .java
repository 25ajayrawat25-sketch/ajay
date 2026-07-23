import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Map to store number as key and its index as value
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // If complement exists in map, we found the pair
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }

            // Otherwise, store current element and index
            numMap.put(nums[i], i);
        }

        // Return empty array if no solution is found (though problem guarantees one)
        return new int[] {};
    }
}
