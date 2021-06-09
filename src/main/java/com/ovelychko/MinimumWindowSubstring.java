/**
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t.
 * If there is no such window in s that covers all characters in t, return the empty string "".
 * <p>
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 * https://leetcode.com/problems/minimum-window-substring/
 */

package com.ovelychko;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        String res = "";

        for (int i = 0; i < (s.length() - t.length() + 1); i++) {

            if (!t.contains(s.substring(i, i + 1)))
                continue;

            int[] count = new int[t.length()];
            int localEnd = i;

            for (int j = 0; j < t.length(); j++) {
                int pos = s.indexOf(t.charAt(j), i);
                if (pos > -1) {
                    count[j]++;
                    localEnd = Math.max(pos, localEnd);
                }
            }

            Boolean valid = true;
            for (int k: count)
                if (k != 1) valid = false;

            if (valid &&
                (res == "" || res.length() > (localEnd - i))) {
                res = s.substring(i, localEnd+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {

        System.out.println(minWindow("AA", "AA"));
        System.out.println(minWindow("B", "B"));
        System.out.println(minWindow("AB", "B"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
