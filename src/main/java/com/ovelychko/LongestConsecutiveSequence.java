/**
 * Longest Consecutive Sequence
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * 
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * 
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 */
package com.ovelychko;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    
    public static int longestConsecutive(int[] nums) {
        
        if (nums.length < 2) return nums.length;
        
        Arrays.sort(nums);
            
        int maxLength = 1;
        int currLength = 1;
        int prev = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) continue;
            
            if (nums[i] - 1 == prev) {
                currLength++;
            } else {
                maxLength = Math.max(maxLength, currLength);
                currLength = 1;
            }
            
            prev = nums[i];
        }
        
        return Math.max(maxLength, currLength);
    }

    public static void main(String[] args) {
        System.out.println("LongestConsecutiveSequence");
    }
}
