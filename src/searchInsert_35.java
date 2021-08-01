public class searchInsert_35 {
    public static int searchInsert(int[] nums, int target) {
        int low = 0, hight = nums.length - 1, mid = (low + hight) / 2;
        while (low <= hight) {
            if (target == nums[mid]) {
                return mid;
            }
            if (target > nums[mid])
                low = mid + 1;
            else
                hight = mid - 1;

            mid = (low + hight) / 2;
        }
        return low;
    }
    public static void main(String args[]){
        int[] nums = new int[]{0,2,2,3};
        int idx =searchInsert(nums,1);
        System.out.print(idx);
    }

}
