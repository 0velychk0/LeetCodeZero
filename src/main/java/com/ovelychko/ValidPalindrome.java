/**
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * https://leetcode.com/problems/valid-palindrome/
 */

package com.ovelychko;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (right > left && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.isLetterOrDigit(s.charAt(left)) && Character.isLetterOrDigit(s.charAt(right))) {
                if (!s.substring(left, left + 1).equalsIgnoreCase(s.substring(right, right + 1)))
                    return false;
            } else if (Character.isLetterOrDigit(s.charAt(left)) || Character.isLetterOrDigit(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
        /*System.out.println(isPalindrome(".,"));
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("a aDaa "));*/
    }
}
