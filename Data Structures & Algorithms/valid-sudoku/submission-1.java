class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Check all 9 rows
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    if (set.contains(num)) return false;
                    set.add(num);
                }
            }
        }
        
        // Check all 9 columns
        for (int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char num = board[j][i];
                if (num != '.') {
                    if (set.contains(num)) return false;
                    set.add(num);
                }
            }
        }
        
        // Check all 9 sub-boxes (3x3)
        for (int box = 0; box < 9; box++) {
            HashSet<Character> set = new HashSet<>();
            int startRow = (box / 3) * 3;
            int startCol = (box % 3) * 3;
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char num = board[startRow + i][startCol + j];
                    if (num != '.') {
                        if (set.contains(num)) return false;
                        set.add(num);
                    }
                }
            }
        }
        
        return true;  // If no duplicates found in any row, column, or box
    }
}