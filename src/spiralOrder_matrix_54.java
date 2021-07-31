import java.util.ArrayList;
import java.util.List;
//将矩阵螺旋输出
public class spiralOrder_matrix_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();

        int top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, left = 0;//上下左右四条边
        int count = (matrix[0].length) * (matrix.length), total = 0;
        while(total < count){
            //上边，从左到右
            for(int i = left; i < right; i++){//顶点元素容易加重复
                list.add(matrix[top][i]);
                total += 1;
            }
            top++;
            //右边，从上到下
            for(int i = top; i < bottom; i++){
                list.add(matrix[i][right]);
                total+=1;
            }
            right--;
            //下边，从右到左
            for(int i = right; i > left; i--){
                list.add(matrix[bottom][i]);
                total+=1;
            }
            bottom--;
            //左边，从下到上
            for(int i = bottom; i > top; i--){
                list.add(matrix[i][left]);
                total+=1;
            }
            left++;
        }
        return list;
    }
}
