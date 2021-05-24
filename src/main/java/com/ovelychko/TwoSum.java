/**
 * Two Sum
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * https://leetcode.com/problems/two-sum/
 */
package com.ovelychko;

import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int[] res = {-1, -1};
        HashMap<Integer, Integer> hmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (hmap.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = hmap.get(target - nums[i]);
                return res;
            } else {
                hmap.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{2, 7, 11, 15}, 22);
        System.out.println(res[0] + " " + res[1]);
    }
}
