package com.zhifeng.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 350. 两个数组的交集 II
 * @author ganzhifeng
 * @date 2022/4/13
 */
public class Solution350 {

    /**
     * hash
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect1(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }

        int[] intersect = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                intersect[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }

        return Arrays.copyOfRange(intersect, 0, index);
    }

    /**
     * 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int p1 = nums1.length;
        int p2 = nums2.length;
        int[] intersect = new int[Math.min(p1, p2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < p1 && index2 < p2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]){
                index2++;
            } else {
                intersect[index++] = nums1[index1];
                index1++;
                index2++;
            }
        }
        return Arrays.copyOfRange(intersect, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
//        int[] nums1 = {4,9,5};
//        int[] nums2 = {9,4,9,8,4};
        int[] intersect = intersect2(nums1, nums2);
        System.out.println();
    }
}
