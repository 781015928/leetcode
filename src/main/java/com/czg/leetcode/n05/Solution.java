package com.czg.leetcode.n05;


import java.util.HashMap;

/**
 * @author 陈泽功<br />
 * @ClassName: Solution <br/>
 * @date: 2020-08-28 16:47<br/>
 * @Description: <br/>
 */
public class Solution {


    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * 示例 1：
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * 输入: "cbbd"
     * 输出: "bb"
     * 输入: "abcdefgfedcba"
     * 输出: "abcdefgfedcba"
     * 输出: "bcacdaaaccaaadcacb"
     *
     * @return
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int maxLength = 0;

        int start_pos = 0;
        int end_pos = 0;


        for (int i = 0; i < chars.length; i++) {
            int start = i;
            int end = i;


            if (end + 1 < chars.length && chars[start] == chars[end + 1]) {//和下一位一样的
                end++;
                for (; start >= 0 && end < chars.length; start--, end++) {//中间有一个数的
                    if (chars[start] == chars[end]) {
                        if (end - start > maxLength) {
                            maxLength = end - start;
                            start_pos = start;
                            end_pos = end;
                        }
                        continue;
                    } else {
                        break;
                    }

                }
            }
            for (start = i, end = i; start >= 0 && end < chars.length; start--, end++) {//中间有一个数的
                if (chars[start] == chars[end]) {
                    if (end - start > maxLength) {
                        maxLength = end - start;
                        start_pos = start;
                        end_pos = end;
                    }
                    continue;
                } else {
                    break;
                }

            }


        }
        if (s.length() > 1) {
            return s.substring(start_pos, end_pos + 1);
        }
        return s;
    }
//    public String longestPalindrome(String s) {
//        char[] chars = s.toCharArray();
//        int maxLength = 0;
//
//        int start_pos = 0;
//        int end_pos = 0;
//
//        HashMap<String, String> keys = new HashMap<>();
//        for (int i = 0; i < chars.length; i++) {
//            for (int start = i, end = i; start >= 0 && end < chars.length; start--, end++) {//中间有一个数的
//
//
//
//
//            }
//        }
//        if (s.length() > 1) {
//            return s.substring(start_pos, end_pos + 1);
//        }
//        return s;
//    }

    public static void main(String[] args) {
        // System.out.println(new Solution().longestPalindrome("cbbd").equals("bb"));
        // System.out.println(new Solution().longestPalindrome("babad").equals("bab"));
        // System.out.println(new Solution().longestPalindrome("abcdefgfedcba").equals("abcdefgfedcba"));
        //  System.out.println(new Solution().longestPalindrome("abcdefgfedcba").equals("abcdefgfedcba"));
        //   System.out.println(new Solution().longestPalindrome("aba"));
        // System.out.println(new Solution().longestPalindrome("caabcbade"));
        // System.out.println(new Solution().longestPalindrome("dabad"));

        System.out.println(new Solution().longestPalindrome("ccc"));
        System.out.println(new Solution().longestPalindrome("aaaa"));
        //  System.out.println(new Solution().longestPalindrome("cccc"));
        System.out.println(new Solution().longestPalindrome("bbbcccbbb"));
        System.out.println(new Solution().longestPalindrome("ccccc"));
        System.out.println(new Solution().longestPalindrome("ccccc"));
        System.out.println(new Solution().longestPalindrome("cccc"));
        System.out.println(new Solution().longestPalindrome("accccc"));
        System.out.println(new Solution().longestPalindrome("bvbccccc"));
    }


}
