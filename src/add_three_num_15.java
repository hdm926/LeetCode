import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class add_three_num_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int curr = 0, start= 0, end = nums.length - 1;
        Arrays.sort(nums);

        for(curr = 0; curr < nums.length; curr++){
            if(nums[curr] > 0)
                return lists; //排好序的数组，第一个数 > 0说明不可能再有三个数相加 = 0

            if(curr > 0 && nums[curr] == nums[curr - 1]) //跳过重复元素
                continue;

            for(start = curr + 1; start < nums.length; ++start){
                if(start > curr + 1 &&nums[start] == nums[start - 1]) continue;


                while(start < end && nums[end] > -(nums[curr] + nums[start])){
                    --end;
                }
                if(end == start) break;
                int sum = nums[curr] + nums[start] + nums[end];
                if(start < end && sum == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[curr]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
