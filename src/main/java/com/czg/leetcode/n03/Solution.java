package com.czg.leetcode.n03;


/**
 * @author 陈泽功<br />
 * @ClassName: Solution <br/>
 * @date: 2020-08-25 16:47<br/>
 * @Description: <br/>
 */
public class Solution {


    /**
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int[] array = new int[65535];
        int headOffset = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length + 1; i++) {
            if (maxLength == 0) {
                maxLength = 1;
            }
            int node = array[chars[i - 1]];
            if (node != 0) {
                if(node>headOffset) {
                    headOffset = node;
                }
            }
            if (maxLength < i - headOffset) {
                maxLength = i - headOffset;
            }
            array[chars[i - 1]] = i;
        }
        return maxLength;
    }

    public static void main(String[] args) {

       // System.out.println(new Solution().lengthOfLongestSubstring("au") == 2);


        System.out.println(new Solution().lengthOfLongestSubstring("abba") == 2);
       // System.out.println(new Solution().lengthOfLongestSubstring("pwwkew") == 3);
       // System.out.println(new Solution().lengthOfLongestSubstring(" ") == 1);
    }


    public static class ListNode {
        Object val;
        ListNode next;
        ListNode last;

        ListNode(Object x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val) + (next != null ? next : "");
        }
    }

}
