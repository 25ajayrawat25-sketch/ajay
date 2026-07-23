class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindromes (e.g., -121 -> 121-).
        // 2. Numbers ending in 0 (except 0 itself) are not palindromes (e.g., 10 -> 01).
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        
        // Reverse the second half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // When the length is odd, we can get rid of the middle digit by reversedHalf/10
        // For example when the input is 12321:
        // x = 12, reversedHalf = 123 -> x == reversedHalf / 10
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
