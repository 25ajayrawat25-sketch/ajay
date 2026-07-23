class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // First two points determine the initial slope delta (dx, dy)
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x1 = coordinates[1][0], y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        // Check if all subsequent points maintain the same slope using cross-multiplication
        // dy / dx == (y_i - y0) / (x_i - x0)  ==>  dy * (x_i - x0) == dx * (y_i - y0)
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];

            if (dy * (x - x0) != dx * (y - y0)) {
                return false;
            }
        }

        return true;
    }
}
