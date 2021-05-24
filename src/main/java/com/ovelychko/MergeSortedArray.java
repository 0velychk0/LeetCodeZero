/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has a size equal to m + n such that it has enough space
 * to hold additional elements from nums2.
 * https://leetcode.com/problems/merge-sorted-array/
 */
package com.ovelychko;

public class MergeSortedArray {
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m + n];
        int id1 = 0;
        int id2 = 0;

        while (id1 < m || id2 < n) {
            if (id1 < m && id2 < n) {
                if (nums1[id1] > nums2[id2]) {
                    res[id1 + id2] = nums2[id2];
                    id2++;
                } else {
                    res[id1 + id2] = nums1[id1];
                    id1++;
                }
            } else if (id1 >= m) {
                res[id1 + id2] = nums2[id2];
                id2++;
            } else {
                res[id1 + id2] = nums1[id1];
                id1++;
            }
        }

        return res;
    }

    public static void mergeIntoNums1(int[] nums1, int m, int[] nums2, int n) {
        int id1 = m - 1;
        int id2 = n - 1;
        int idR = n + m - 1;

        while (id1 > -1 || id2 > -1) {
            if (id1 > -1 && id2 > -1) {
                if (nums2[id2] > nums1[id1]) {
                    nums1[idR] = nums2[id2];
                    id2--;
                } else {
                    nums1[idR] = nums1[id1];
                    id1--;
                }
            } else if (id1 == -1) {
                nums1[idR] = nums2[id2];
                id2--;
            } else {
                nums1[idR] = nums1[id1];
                id1--;
            }
            idR--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};
        System.out.println(merge(a, a.length, b, b.length));

        int[] c = {1, 3, 5, 7, 10, 100, 100, 100};
        int[] d = {2};
        mergeIntoNums1(c, (c.length - d.length), d, d.length);
        System.out.println(c);
    }
}
