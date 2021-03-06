package com.app.medium;

/**
 * @author t0k02w6 on 11/04/22
 * @project ds-algo-2021
 */
public class BattleshipInABoardLeetcode419 {
    private static int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'X') {
                    if(i - 1 >= 0 && board[i - 1][j] == 'X')
                        continue;
                    if(j - 1 >= 0 && board[i][j - 1] == 'X')
                        continue;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
