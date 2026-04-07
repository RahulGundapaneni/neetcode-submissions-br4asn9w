class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length - 1;
        int colLength = matrix[0].length - 1;

        int leftRow = 0;
        int rightRow = rowLength;

        while (leftRow <= rightRow) {
            int midRow = leftRow + (rightRow - leftRow) / 2;

            if (target < matrix[midRow][0]) {
                rightRow = midRow - 1;
            }
            else if (target > matrix[midRow][colLength]) {
                leftRow = midRow + 1;
            }
            else {
                int low = 0;
                int high = colLength;

                while (low <= high) {
                    int midCol = low + (high - low) / 2;

                    if (matrix[midRow][midCol] == target) {
                        return true;
                    }
                    else if (matrix[midRow][midCol] > target) {
                        high = midCol - 1;
                    }
                    else {
                        low = midCol + 1;
                    }
                }
                return false;
            }
        }
        return false;
    }
}
