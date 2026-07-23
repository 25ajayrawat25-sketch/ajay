import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        
        // Array to store the last seen index of each ASCII character
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            
            // If the character was seen inside the current window, move the left pointer
            if (lastSeen[currentChar] >= left) {
                left = lastSeen[currentChar] + 1;
            }
            
            // Update last seen index of current character
            lastSeen[currentChar] = right;
            
            // Calculate maximum window length so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
