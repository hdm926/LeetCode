import java.lang.management.BufferPoolMXBean;

public class isValidSudoku_36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] col = new int[9][9];
        int[][] row = new int[9][9];
        int[][] box = new int[9][9];
        int num = -1;
        for(int i = 0; i < board.length; i++ ) //遍历行
        {
            for (int j = 0; j < board[0].length; j++)//遍历列
            {
                int idx_box = (i / 3) * 3 + (j / 3); //第几个小方块，*3是每行过来能有三个小方块
                if (board[i][j] != '.')
                {
                    num = board[i][j] - '1'; //字符转int,并且棋盘是1-9，对应的数组下标是0-8
                    if (col[j][num] == 1 || row[i][num] == 1 || box[idx_box][num] == 1)
                        return false;
                    else
                    {
                        col[j][num] = 1; //第j列出现了数字num
                        row[i][num] = 1; //第i行出现了数字num
                        box[idx_box][num] = 1; //第idx_box个小方块出现了数字num
                    }
                }
            }
        }
        return true;
    }
}
