class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Row Comparision

        for(int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                char curr = board[i][j];
                if(curr != '.') {
                    if(set.contains(board[i][j])) return false;
                    set.add(board[i][j]);
                }
            }
        }
        
        // Column 
        for(int i = 0; i < 9; i++) {
            HashSet<Character> set = new HashSet<>();
            for(int j = 0; j < 9; j++) {
                char curr = board[j][i];
                if(curr != '.') {
                    if(set.contains(board[j][i])) return false;
                    set.add(board[j][i]);
                }
            }
        }

        // 3 * 3 comparision

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
        return true;
    }
}
