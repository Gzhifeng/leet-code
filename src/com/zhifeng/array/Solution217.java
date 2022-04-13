package com.zhifeng.array;

import java.util.*;

/**
 * 217. 存在重复元素
 * @author ganzhifeng
 * @date 2022/4/10
 */
public class Solution217 {

    /**
     * 使用hash表
     * @param nums
     * @return
     */
    public static boolean containsDuplicate1(int[] nums) {

        Map<Integer, Object> map = new HashMap<>(nums.length);
        boolean boo = false;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                boo = true;
                break;
            } else {
                map.put(num, null);
            }
        }

        return boo;
    }

    /**
     * 使用hash表
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums) {

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用排序
     * @param nums
     * @return
     */
    public static boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int[] nums = {1,2,3,4};
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate3(nums));
    }
}
