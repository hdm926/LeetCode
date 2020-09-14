import java.util.HashMap;
import java.util.Map;

public class two_sum_1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();//元素和下标的映射
        for(int i = 0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[] {map.get(target - nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }
        return null;
    }
}
