class Solution {
    public boolean squareIsWhite(String coordinates) {
        // Extract column character ('a' to 'h') and row character ('1' to '8')
        char col = coordinates.charAt(0);
        char row = coordinates.charAt(1);

        // Sum the ASCII / numeric values. 
        // If the sum is odd, the square is white; if even, it's black.
        return (col + row) % 2 != 0;
    }
}
