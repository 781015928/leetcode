package com.czg.leetcode.n01;


import java.util.HashMap;

/**
 * @author 陈泽功<br />
 * @ClassName: Solution <br/>
 * @date: 2020-08-25 16:47<br/>
 * @Description: <br/>
 */
public class Solution {


    /**
     * 执行用时：
     * 88 ms
     * , 在所有 Java 提交中击败了
     * 14.97%
     * 的用户
     * 内存消耗：
     * 39.8 MB
     * , 在所有 Java 提交中击败了
     * 73.16%
     * 的用户
     *
     * <p>
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * </p>
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> integers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (integers.containsKey(target - nums[i])) {
                return new int[]{i, integers.get(target - nums[i])};
            }
            integers.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] data = {2, 7, 11, 15, 13};
        Solution solution = new Solution();
        int target = 9;
        int[] ints = solution.twoSum(data, target);
        System.out.println(data[ints[0]] + data[ints[1]] == target);

    }
}
