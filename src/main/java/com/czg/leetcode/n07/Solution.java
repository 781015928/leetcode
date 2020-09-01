package com.czg.leetcode.n07;


/**
 * @author 陈泽功<br />
 * @ClassName: Solution <br/>
 * @date: 2020-08-28 16:47<br/>
 * @Description: <br/>
 */
public class Solution {


    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * 示例 1:
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * 输入: 120
     * 输出: 21
     * 注意:
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
     *
     * @return
     */
    public int reverse(int x) {
        int reverse = 0;
        int remainder = x % 10;
        int bit = x / 10;

        reverse += (remainder * bit);
        while ((x - remainder) / 10 > 0) {
            x = (x - remainder) / 10;
            remainder = x % 10;
            bit = x / 10;
            reverse += (remainder * bit);
        }
        System.out.println(reverse);
        return reverse;
    }


    public static void main(String[] args) {
        //  System.out.println(new Solution().convert2("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        System.out.println(new Solution().reverse(21) == 12);
        System.out.println(new Solution().reverse(211) == 112);
        System.out.println(new Solution().reverse(210) == 12);
        System.out.println(new Solution().reverse(3210) == 123);


    }


}
