package com.app.easy;

/**
 * @author t0k02w6 on 21/03/22
 * @project ds-algo-2021
 */
public class NumbersSmallerThanCurrentNumberLeetcode1365 {
    private static int[] smallerNumbersThanCurrent(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Integer.max(max, nums[i]);
        }

        int[] count = new int[max + 1];
        for(int i = 0; i < nums.length; i++) {
            int k = nums[i];
            count[k]++;
        }

        for(int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for(int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if(k == 0) {
                nums[i] = 0;
            } else {
                nums[i] = count[k - 1];
            }
        }
        return nums;
    }

    public static void main(String[] args) {

    }
}
