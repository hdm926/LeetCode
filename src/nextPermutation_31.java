import java.io.PrintStream;

public class nextPermutation_31 {
    public static void nextPermutation(int[] nums) {
        int i , j = 0;
        for(i = nums.length - 1; i > 0; i--){
            if(i - 1 >= 0 && nums[i - 1] < nums[i]){
                i= i-1;
                break;
            }
        }
        int flag = 0;

        for(j = nums.length - 1; j > i; j--){
            if(nums[j] > nums[i]){
                flag = 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                break;
            }
        }

        int idx = 0;
        if (flag == 0)
            idx = i;
        else
            idx = i + 1;

        for(i = idx, j = nums.length - 1; i < j ; i++, j--){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
        }
    }
    public static void main(String args[]){
        int[] nums = new int[]{3,2,1};
        nextPermutation(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.print(nums[i]);
    }
}


