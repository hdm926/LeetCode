import java.util.HashMap;

public class first_missing_positive_41 {
    public int firstMissingPositive(int[] nums) {
        int first = 1;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0;i < nums.length; i++ ){
            map.put(nums[i], i);
        }
        while(true){
            if(!map.containsKey(first)){
                return first;
            }
            first++;
        }
    }
}
