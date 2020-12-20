import jdk.nashorn.internal.ir.WhileNode;

import javax.swing.plaf.basic.BasicSplitPaneUI;

public class trap_42 {
    public int trap(int[] height) {
        //在某个位置i处，它能存的水，取决于它左右两边的最大值中较小的一个。
        //当我们从左往右处理到left下标时，左边的最大值left_max对它而言是可信的，
        // 但right_max对它而言是不可信的。
        //因为由于中间状况未知，对于left下标而言，right_max未必就是它右边最大的值
        //对于位置left而言，它左边最大值一定是left_max，右边最大值“大于等于”right_max，
        // 这时候，如果left_max<right_max成立，那么它就知道自己能存多少水了。
        // 无论右边将来会不会出现更大的right_max，都不影响这个结果。
        // 所以当left_max<right_max时，我们就希望去处理left下标，
        // 反之，我们希望去处理right下标。
        int left = 0, right = height.length - 1, left_max = 0, right_max = 0, ans = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > left_max){
                    left_max = height[left];
                }else {
                    ans+=left_max - height[left];
                }
                left++;
            }else{
                if(height[right] > right_max){
                    right_max = height[right];
                }else{
                    ans+=right_max - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}
