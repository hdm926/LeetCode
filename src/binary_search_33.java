public class binary_search_33 {
    public static int search(int[] nums, int target) {
        int low = 0, hight = nums.length - 1, mid = (low + hight) / 2;
        int flag = 0; // 0:left is in order,1:right is in order
        while (low <= hight) {
            if (nums[mid] == target)
                return mid;

            if(nums[mid] >= nums[low])
                flag = 0;
            else
                flag = 1;

            if (flag == 0 && target >= nums[low] && target < nums[mid])//左边有序,且包含target
                hight = mid - 1;//只有满足这三个条件，target才会出现在左边，否则去右边找
            else if (flag == 1 && target > nums[mid] && target <= nums[hight])
                low = mid + 1;
            else if(flag == 0) //前两个条件不满足，说明target在无序的那一边
                low = mid + 1;
            else
                hight = mid - 1;

            mid = (low + hight) / 2;
        }
        return -1;
    }

    public static void main(String args[]){
        int[] nums = new int[]{1,3};
        int result = search(nums, 3);
        System.out.println(result);
    }
}
