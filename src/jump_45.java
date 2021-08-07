public class jump_45 {
    //贪心算法，记录从每一个当前位置可以到达的最远下标
    //在[i, i+nums[i]]之间，不需要计算具体是从哪个位置跳过去的，只需要知道从这区间能到达的最远下标即可
    public int jump(int[] nums) {
        int step = 0, max_pos = 0, end_pos = 0;
        for(int i = 0; i < nums.length - 1; i++){ //因为i=0的时候，step就是1了，如果访问最后一个元素会增加一次不必要的跳跃
            max_pos = Math.max(max_pos, i + nums[i]); //i到end之间所能到达的最远位置下标
            if(max_pos >= nums.length - 1) //当发现当前位置能跳到最后一个位置，直接跳
            {
                step ++ ;
                return step;
            }
            if(i == end_pos){
                end_pos = max_pos; //到达边界，将这一段区间里所能到达的最远位置设为新的边界
                step ++;//从最远边界开始下一跳
            }
        }
        return step;
    }
}
