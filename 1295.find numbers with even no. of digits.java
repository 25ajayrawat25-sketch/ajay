class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;

        for (int num : nums) {
            // Using constraints (1 <= num <= 10^5) to check digit length directly
            if ((num >= 10 && num <= 99) || 
                (num >= 1000 && num <= 9999) || 
                (num == 100000)) {
                count++;
            }
        }

        return count;
    }
}
