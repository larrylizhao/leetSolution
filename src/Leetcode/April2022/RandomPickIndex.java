package Leetcode.April2022;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/*
    398. 随机数索引
 */
public class RandomPickIndex {
    /*
        给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。
        int[] nums = new int[] {1,2,3,3,3};
        Solution solution = new Solution(nums);

        // pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
        solution.pick(3);

        // pick(1) 应该返回 0。因为只有nums[0]等于1。
        solution.pick(1);
     */
    HashMap<Integer, ArrayList<Integer>> map;
    Random random;
    public RandomPickIndex(int[] nums) {
        map = new HashMap<>();
        random = new Random();
        for(int i = nums.length-1 ; i >= 0;i--){
            int key = nums[i];
            ArrayList<Integer> list = map.get(key);
            if(list == null){
                list = new ArrayList<>();
                list.add(i);
                map.put(key,list);
            }else{
                list.add(i);
            }
        }
    }

    public int pick(int target) {
        ArrayList<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
