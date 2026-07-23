class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            // Calculate width and lower height between the two pointers
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            
            // Calculate current area and update max
            int currentArea = width * minHeight;
            maxWater = Math.max(maxWater, currentArea);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
