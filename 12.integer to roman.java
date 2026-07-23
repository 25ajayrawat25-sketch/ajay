class Solution {
    public String intToRoman(int num) {
        // Mapping of values to their corresponding Roman numeral symbols in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        // Loop through all value-symbol pairs
        for (int i = 0; i < values.length; i++) {
            // Append symbol while num is greater than or equal to current value
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
