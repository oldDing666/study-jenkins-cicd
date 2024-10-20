package com.interview.cicd.leetcode;

import java.util.Arrays;

/**
 * @author: afuya
 * @program: study-jenkins-cicd
 * @date: 2024/8/19 23:16
 */
public class LC088 {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[nums1.length + nums2.length];
        int i1 = 0, i2 = 0;
        for (int i = 0; i < res.length; i++) {
            if (nums1[i1] <= nums2[i2] && i1 < nums1.length) {
                res[i] = nums1[i1];
                i1++;
            } else if (nums1[i1] > nums2[i2] && i2 < nums2.length) {
                res[i] = nums2[i2];
                i2++;
            }
        }
        nums1 = res;
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
