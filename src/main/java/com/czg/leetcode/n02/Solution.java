package com.czg.leetcode.n02;


/**
 * @author 陈泽功<br />
 * @ClassName: Solution <br/>
 * @date: 2020-08-25 16:47<br/>
 * @Description: <br/>
 */
public class Solution {


    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int Base1 = 0;
        int Base2 = 0;
        int sum = 0;
        ListNode var1 = l1;
        ListNode var2 = l2;
        ListNode varResult = null;

        while (var1 != null || var2 != null) {
            if (var1 != null) {
                sum += var1.val * Math.pow(10, Base1++);
                var1 = var1.next;
            }
            if (var2 != null) {
                sum += var2.val * Math.pow(10, Base2++);
                var2 = var2.next;
            }
        }

        int mo = 1;
        int pow = 10;
        int mode = sum % pow;
        sum = sum - mode;

        varResult = new ListNode(mode);
        while (mo > 0) {
            mo++;
            pow = (int) Math.pow(10, mo);
            mode = sum % pow;
            sum = sum - mode;
            varResult.next = new ListNode(mode);

        }


        return varResult;
    }

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(2);
        listNodeA.next = new ListNode(4);
        listNodeA.next.next = new ListNode(3);

        ListNode listNodeB = new ListNode(5);
        listNodeB.next = new ListNode(6);
        listNodeB.next.next = new ListNode(4);

        ListNode listNode = new Solution().addTwoNumbers(listNodeA, listNodeB);
        System.out.println(listNode);

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val) + next;
        }
    }
}
