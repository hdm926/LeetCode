public class searchRange_34 {
    //二分搜索返回的是第一个>=target的下标，那其实等同于进行两次二分，一次搜索target,一次搜索target+1
    public static int[] searchRange(int[] nums, int target) {
        int low = 0, hight = nums.length - 1, mid = (low + hight) / 2;
        int flag = 0;
        while(low <= hight) {
            if (target == nums[mid]) {
                flag= 1;
                break;
            }
            if (target > nums[mid])
                low = mid + 1;
            else
                hight = mid - 1;

            mid = (low + hight) / 2;
            //System.out.print(mid);
        }

        if (flag == 0)
            return new int[]{-1, -1};

        int range = 1;
        while(low >= 0 && mid - range >=0){
            if(nums[mid - range] < target){
                low = mid - range + 1;
                break;
            }
            range++;
        }

        range = 1;
        while(hight < nums.length && mid + range < nums.length){
            if(nums[mid + range] > target){
                hight = mid + range - 1;
                break;
            }
            range++;
        }
        int[] result = new int[]{low, hight};
        System.out.print(result[0] + " "+result[1]);
        return result;

    }

    public static void main(String args[]){
        int[] nums = new int[]{0,0,1,2,2};
        searchRange(nums,2);
    }

}
