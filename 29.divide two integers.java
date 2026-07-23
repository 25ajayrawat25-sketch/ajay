class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow edge case: Integer.MIN_VALUE / -1 = 2^31 (overflows 32-bit signed int)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both inputs to negative to avoid overflow with Integer.MIN_VALUE
        // (as -Integer.MIN_VALUE exceeds Integer.MAX_VALUE)
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Perform division using exponential search (bit shifting)
        while (a <= b) {
            int tempDivisor = b;
            int count = 1;

            // Double the divisor until it exceeds 'a'
            // Watch out for overflow: tempDivisor << 1 must remain negative and <= a
            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && a <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                count <<= 1;
            }

            a -= tempDivisor;
            quotient += count;
        }

        return negative ? -quotient : quotient;
    }
}
