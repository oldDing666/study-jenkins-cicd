package com.interview.cicd.leetcode;

/**
 * @author: afuya
 * @program: study-jenkins-cicd
 * @date: 2024/8/20 08:53
 */
public class LC027 {
    public int removeElement(int[] nums, int val) {
        int index = nums.length - 1;
        int res = 0;
        for (int i = 0; i <= index; i++) {
            if (nums[i] == val) {
                nums[i] = nums[i] + nums[index];
                nums[index] = nums[i] - nums[index];
                nums[i] = nums[i] - nums[index];
                i--;
                index--;
            } else {
                res++;
            }
        }
        return res;
    }
}
