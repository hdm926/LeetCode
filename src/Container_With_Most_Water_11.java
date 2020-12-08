//两个对撞指针，每移动一次都判断一次是否乘积最大
public class Container_With_Most_Water_11 {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0;
        int end = height.length - 1;
        int area = 0;

        while(start < end){
            area = (end - start) * Math.min(height[start], height[end]);

            if(area > max){
                max = area;
            }
            if(height[start] < height[end]){
                start++;
            }else{
                end--;
            }
        }
        return max;
    }
}
