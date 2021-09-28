package com.spezdmtest.javacore.leetcode.Two_Sum;

import java.util.*;

//O(n2)
public class Solution {
    public int [] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length;i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution for defined input date");
    }
}
//O(1)
class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for(int i = 0; i < nums.length; i++) {
            int requiredNumber = target - nums[i];

            if(map.containsKey(requiredNumber) && map.get(requiredNumber) != i){
                return new int[] {i,map.get(requiredNumber)};
            }
        }
        throw new IllegalArgumentException("No solution for defined input date");
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = {2,7,11,15};

        System.out.println(Arrays.toString(solution.twoSum(nums,9)));

        Solution2 solution2 = new Solution2();
        int nums2[] = {2,7,11,15};
        solution2.twoSum(nums2,26);
    }
}
