public class rotate_matrix_48 {
    //将矩阵旋转90度
    //先上下翻转，再对角线交换即可
    public void rotate(int[][] matrix) {
        //上下翻转
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row / 2; i++){
            for(int j = 0; j < col; j++ ){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[row - i - 1][j];
                matrix[row - i - 1][j] = tmp;
            }
        }

        //对角线翻转
        for(int i = 0; i < row; i++){
            for(int j = i; j < col; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
