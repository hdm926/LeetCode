import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_sum2_40 {
    List<List<Integer>> res = new ArrayList<>();//全局变量
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); //排序
        List<Integer> path = new ArrayList<>();
        DFS(candidates, target, 0, path);
        return res;
    }

    //begin: 下一次搜索的起点，避免重复解，path:一个可行解
    public void DFS(int[] candidates, int target, int begin, List<Integer> path) {
        if (target < 0) {
            return;
        } else if (target == 0) { //叶节点为0，是目标组合；递归退出条件
            res.add(new ArrayList<Integer>(path)); //重新new一个path
            return;
        }

        for (int i = begin; i < candidates.length; i++) {//target > 0
            if (target - candidates[i] < 0) continue; //剪枝
            //System.out.println("i:" + i);
            if(i > begin && candidates[i] == candidates[i - 1])continue;//与左邻元素相等，说明前面一次已经有过组合了
            path.add(candidates[i]);// 先加当前节点，再往下递归
            //System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            target = target - candidates[i];
            DFS(candidates, target, i + 1, path);
            path.remove(path.size() - 1); //上一句的递归没有退出，说明选的数不合适
            target = target + candidates[i];// 撤销上一步的选择，把target给人家加回去
            //System.out.println("递归之后 => " + path);
        }
    }

    public static void main(String[] args) {
        combination_sum2_40 solution = new combination_sum2_40();
        int[] candidates = new int[]{2,5,2,1,2};//1,2,2,2,5
        int target = 5;
        List<List<Integer>> res = solution.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }
}
