/**
 * Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.
 * An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
 * Note: a + b is the concatenation of strings a and b.
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * 
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 * 
 * Input: s1 = "", s2 = "", s3 = ""
 * Output: true
 */

package com.ovelychko;

import java.util.HashSet;

public class InterleavingString {
    
    private static HashSet<String> hset;

    public static boolean isInterleave(String s1, String s2, String s3) {
        hset = new HashSet<>();
        if (s1.length() + s2.length() + s3.length() == 0)
            return true;

        if (s1.length() + s2.length() != s3.length())
            return false;

        if (s1.length() > 0 && s3.length() > 0 &&
                s3.charAt(0) == s1.charAt(0) &&
                isInterleave(s1, 1, s2, 0, s3, 1))
            return true;

        if (s2.length() > 0 && s3.length() > 0 &&
                s3.charAt(0) == s2.charAt(0) &&
                isInterleave(s1, 0, s2, 1, s3, 1))
            return true;

        return false;
    }

    public static boolean isInterleave(String s1, int i1, String s2, int i2, String s3, int i3) {
        String key = s1.substring(i1) + "+" + s2.substring(i2);
        if (hset.contains(key)) return false;

        if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length())
            return true;

        if (s1.length() + s2.length() != s3.length()) {
            hset.add(s1 + s2);
            return false;
        }

        if (s1.length() > i1 && s3.length() > i3 &&
                s3.charAt(i3) == s1.charAt(i1) &&
                isInterleave(s1, i1 + 1, s2, i2, s3, i3 + 1))
            return true;

        if (s2.length() > i2 && s3.length() > i3 &&
                s3.charAt(i3) == s2.charAt(i2) &&
                isInterleave(s1, i1, s2, i2 + 1, s3, i3 + 1))
            return true;

        hset.add(key);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("InterleavingString");
    }
}
