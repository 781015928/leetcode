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
    final static int[] sizeTable = {10, 100, 1000, 10000, 100000, 1000000, 10000000,
            100000000, 1000000000, Integer.MAX_VALUE};

    // Requires positive x
    int size(int x) {
        for (int i = 0; ; i++)
            if (x <= sizeTable[i])
                return i == 0 ? 1 : sizeTable[i - 1];
    }

    public int reverse(int x) {
        int i1 = x * -1;
        if (x - i1 != x * 2) {
            return 0;
        }

        int i = (x > 0) ? 1 : -1;
        int reverse = 0;
        int remainder = x % 10;
        int bit = size(x);

        if (bit / 10 * remainder > Integer.MAX_VALUE / 10) {
            return 0;
        }
        reverse += (remainder * bit);


        while ((x - remainder) / 10 > 0) {
            x = (x - remainder) / 10;
            remainder = x % 10;
            bit = bit / 10;
            reverse += (remainder * bit);
        }

        return i * reverse;
    }


    public static void main(String[] args) {
        //  System.out.println(new Solution().convert2("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        //  System.out.println(new Solution().reverse(21) == 12);
        // System.out.println(new Solution().reverse(211) == 112);
        //  System.out.println(new Solution().reverse(210) == 12);
        ///  System.out.println(new Solution().reverse(3210) == 123);
        System.out.println(new Solution().reverse(-3210) == -123);
        System.out.println(new Solution().reverse(Integer.MAX_VALUE));
        System.out.println(new Solution().reverse(Integer.MIN_VALUE));
        System.out.println(Integer.MIN_VALUE);


    }


}
