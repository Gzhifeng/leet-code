package com.zhifeng.array;

import java.util.Arrays;

/**
 * @author ganzhifeng
 * @date 2022/4/13
 */
public class Solution88 {

    /**
     * 合并后直接排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 双指针
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] arr = new int[m + n];
        int curr;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                curr = nums2[p2++];
            } else if (p2 == n) {
                curr = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
            arr[p1 + p2 - 1] = curr;
        }

        for (int i = 0; i < arr.length; i++) {
            nums1[i] = arr[i];
        }
    }

    /**
     * 逆向双指针
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int tail = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p2 >= 0) {
            if (p1 < 0 || nums1[p1] <= nums2[p2]) {
                nums1[tail--] = nums2[p2--];
            } else {
                nums1[tail--] = nums1[p1--];
            }
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {7,8,9,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
//        merge1(nums1, m, nums2, n);
//        merge2(nums1, m, nums2, n);
        merge3(nums1, m, nums2, n);
        System.out.println();
    }
}
