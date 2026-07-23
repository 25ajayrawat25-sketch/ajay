class Solution {
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;

        // Traverse the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = getValue(s.charAt(i));

            // If current value is less than the previous value, subtract it
            if (currValue < prevValue) {
                total -= currValue;
            } else { // Otherwise, add it
                total += currValue;
            }

            prevValue = currValue;
        }

        return total;
    }

    // Helper method to convert Roman character to value
    private int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
