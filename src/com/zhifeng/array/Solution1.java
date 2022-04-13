package com.zhifeng.array;

import java.util.HashMap;

/**
 * 1. 两数之和
 * @author ganzhifeng
 * @date 2022/4/11
 */
public class Solution1 {

    /**
     * 枚举法
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {

        int[] arr = new int[2];
        for (int i = 0; i < nums.length -1; i++) {
            int num1 = nums[i];
            for (int j = (i + 1); j < nums.length; j++) {
                int num2 = nums[j];
                if ((num1 + num2) == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }

        return arr;
    }

    /**
     * hash
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int[] arr = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                arr[0] = map.get(target - nums[i]);
                arr[1] = i;
            }
            map.put(nums[i], i);
        }
        return arr;
    }

    public static void printlnArr(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 22;
        int[] twoSum = twoSum2(nums, target);
        printlnArr(twoSum);
    }
}
