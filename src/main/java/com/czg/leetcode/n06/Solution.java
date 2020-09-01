package com.czg.leetcode.n06;


/**
 * @author 陈泽功<br />
 * @ClassName: Solution <br/>
 * @date: 2020-08-28 16:47<br/>
 * @Description: <br/>
 */
public class Solution {


    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"  length = 16
     * 解释:
     * <p>
     * L  D  R    0 +groupCount    0    6     12
     * E OE II                     1  5 7  11 13
     * EC IH N                     2 4  8 10  14
     * T  S  G                     3    9     15
     * <p>
     *
     * @return
     */
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        int groupCount = numRows * 2 - 2;
        if (groupCount == 0) {
            groupCount = 1;
        }
        int remainder = s.length() % groupCount;
        int group = s.length() / groupCount;
        int remainderWidth = 0;
        if (remainder > 0) {
            if (remainder > numRows) {
                remainderWidth = (remainder - numRows) * 2;
            } else {
                remainderWidth = 1;
            }

        }
        int groupColumn = numRows - 1;//算空格
        if (groupColumn == 0) {
            groupColumn = 1;
        }
        int height = numRows;
        int width = group * groupColumn + remainderWidth;
        StringBuilder result = new StringBuilder(width * height);

        char[][] table = new char[width][height];

        int x = 0, y = 0;
        boolean down = true;
        for (int i = 0; i < chars.length; i++) {
            if (x < table.length && y < table[x].length) {
                table[x][y] = chars[i];
            }


            if (down) {

                y++;
                if (y == table[x].length) {
                    down = false;
                    y = 0;
                    x++;
                    continue;
                }

                if (numRows - 1 == 0) {
                    continue;
                }


                down = y % (numRows - 1) != 0;
            } else {

                x++;
                y--;
                if (y < 0) {
                    y = 0;
                }

                down = y == 0;
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (table[j][i] != 0) {
                    result.append(table[j][i]);
                } else {
                }
            }
        }
        return result.toString();
    }

    /**
     * * L  D  R    0 +groupCount    0    6     12
     * * E OE II                     1  5 7  11 13
     * * EC IH N                     2 4  8 10  14
     * * T  S  G                     3    9     15
     * * <p>
     *
     * @param s
     * @param numRows
     * @return
     */
    public String convert2(String s, int numRows) {
        int groupCount = 2 * numRows - 2;
        if (groupCount == 0) {
            groupCount = 1;
        }
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                for (int j = 0; j+ i < chars.length; j += groupCount) {
                    result.append(chars[j + i]);
                }
                continue;
            }


            if (i == numRows - 1) {
                for (int j = 0; j+ i < chars.length; j += groupCount) {
                    result.append(chars[j + i]);
                }
                continue;
            }
            int aCount = 2 * (numRows - i) - 2;
            int bCount = groupCount - aCount;
            boolean isA = false;
            for (int j = 0; j + i < chars.length; j += (isA ? aCount : bCount)) {
                isA = !isA;
                result.append(chars[j + i]);

            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //  System.out.println(new Solution().convert2("LEETCODEISHIRING", 4).equals("LDREOEIIECIHNTSG"));
        System.out.println(new Solution().convert2("A", 1).equals("A"));
        System.out.println(new Solution().convert2("A", 2).equals("A"));
        System.out.println(new Solution().convert2("AA", 2).equals("AA"));
        System.out.println(new Solution().convert2("AAA", 3).equals("AAA"));
        //  System.out.println(new Solution().convert2("A", 2).equals("A"));


    }


}
