import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class add_4_num_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        int a, b, c, d;
        int len = nums.length;
        Arrays.sort(nums);

        for(a = 0; a <= len -4; a++){
            if(a > 0 && nums[a] == nums[a-1]) continue;//去除重复a
            for (b = a + 1; b <= len - 3; b++){
                if(b > a + 1 && nums[b] == nums[b - 1])continue;//去除重复b

                c = b + 1;
                d = len - 1;
                while(c < d){
                    if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        d--;
                    }else if(nums[a] + nums[b] + nums[c] + nums[d] < target){
                        c++;
                    }else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        lists.add(list);
                        while(c + 1 < d && nums[c + 1] == nums[c]){
                            c++; //去掉重复c
                        }
                        while (c < d && nums[d] == nums[d - 1]){
                            d--;
                        }
                        c++;
                        d--;
                    }
                }
            }
        }
        return lists;
    }
}
