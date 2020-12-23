public class max_sub_array_53 {
    //贪心
    public int maxSubArray(int[] nums) {
        int sum = 0;//表示当前子序列中的最大和
        int ans = nums[0];//不能初始化为0，当nums=[-1]的时候，会返回错误

        for(int i = 0; i < nums.length; i++){
            if(sum <= 0){
                sum = nums[i]; // 当子序列为负数的时候，再加上任何数都会使得最后的子序列更小
            }else{
                sum += nums[i];
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
