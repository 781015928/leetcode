package com.czg.leetcode.n04;


/**
 * @author 陈泽功<br />
 * @ClassName: Solution <br/>
 * @date: 2020-08-25 16:47<br/>
 * @Description: <br/>
 */
public class Solution {


    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * 你可以假设 nums1 和 nums2 不会同时为空
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int num1_length = nums1 != null ? nums1.length : 0;
        int num2_length = nums2 != null ? nums2.length : 0;
        int[] ints = new int[num1_length + num2_length];
        boolean odd = ints.length % 2 != 0;
        int middleIndex1 = odd ? ints.length / 2 : ints.length / 2 - 1;
        int middleIndex2 = odd ? ints.length / 2 : ints.length / 2;
        if ((nums1 == null || nums1.length == 0) && nums2 != null) {
            return (nums2[middleIndex1] + nums2[middleIndex2]) / 2d;
        }
        if (nums1 != null && (nums2 == null || nums2.length == 0)) {
            return (nums1[middleIndex1] + nums1[middleIndex2]) / 2d;
        }
        int startOffset1 = 0;
        int startOffset2 = 0;
        int endOffset1 = num1_length - 1;
        int endOffset2 = num2_length - 1;
        int resultStartOffset = 0;
        int resultEndOffset = ints.length - 1;
        while ((startOffset1 <= endOffset1 && endOffset1 >= 0) && startOffset1 < num1_length
                || (startOffset2 <= endOffset2 && endOffset2 >= 0) && startOffset2 < num2_length) {

            if (startOffset1 >= nums1.length && startOffset2 < nums2.length) {
                int s2 = nums2[startOffset2];
                ints[resultStartOffset++] = s2;
                startOffset2++;
                continue;
            }
            if (startOffset2 >= nums2.length && startOffset1 < nums1.length) {
                int s1 = nums1[startOffset1];
                ints[resultStartOffset++] = s1;
                startOffset1++;
                continue;
            }
            int s1 = nums1[startOffset1];
            int s2 = nums2[startOffset2];


            if (endOffset1 < 0) {
                int e2 = nums2[endOffset2];
                ints[resultEndOffset--] = e2;
                endOffset2--;
                continue;
            }
            if (endOffset2 < 0) {
                int e1 = nums1[endOffset1];
                ints[resultEndOffset--] = e1;
                endOffset1--;
                continue;
            }

            int e1 = nums1[endOffset1];
            int e2 = nums2[endOffset2];


            if (s1 < s2) {
                ints[resultStartOffset++] = s1;
                startOffset1++;
            } else if (s1 > s2) {
                ints[resultStartOffset++] = s2;
                startOffset2++;
            } else if (s1 == s2) {
                ints[resultStartOffset++] = s1;
                ints[resultStartOffset++] = s2;
                startOffset1++;
                startOffset2++;
            }
            if (e1 > e2) {
                ints[resultEndOffset--] = e1;
                endOffset1--;
            } else if (e1 < e2) {
                ints[resultEndOffset--] = e2;
                endOffset2--;
            } else if (e1 == e2) {
                ints[resultEndOffset--] = e1;
                ints[resultEndOffset--] = e2;
                endOffset1--;
                endOffset2--;
                if (endOffset1 < 0) {
                    endOffset1 = 0;
                }
                if (endOffset2 < 0) {
                    endOffset2 = 0;
                }

            }


        }
        return (ints[middleIndex1] + ints[middleIndex2]) / 2d;
    }

    public static void main(String[] args) {
        //  System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}) == 2);
        //  System.out.println(new Solution().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}) == 2.5);
        //  System.out.println(new Solution().findMedianSortedArrays(null, new int[]{3, 4}) == 3.5);
        //System.out.println(new Solution().findMedianSortedArrays(new int[]{}, new int[]{3, 4}) == 3.5);
        // System.out.println(new Solution().findMedianSortedArrays(new int[]{}, new int[]{1}) == 1);
        //   System.out.println(new Solution().findMedianSortedArrays(new int[]{3}, new int[]{1, 2}) == 2);
        //System.out.println(new Solution().findMedianSortedArrays(new int[]{3}, new int[]{-2, -1}) == -1);
        int[] ints = new int[10000000];
        int[] ints1 = new int[10000000];

        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
            ints1[i] = -i;
        }
        System.out.println(new Solution().findMedianSortedArrays(ints, ints1));
        //  System.out.println(new Solution().findMedianSortedArrays(new int[]{1}, new int[]{1, 2}) == 1);
    }


}
