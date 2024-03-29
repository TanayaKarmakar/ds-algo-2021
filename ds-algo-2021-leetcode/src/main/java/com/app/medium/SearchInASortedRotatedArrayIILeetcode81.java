package com.app.medium;

/**
 * @author t0k02w6 on 02/07/23
 * @project ds-algo-2021-leetcode
 */
public class SearchInASortedRotatedArrayIILeetcode81 {
  private static boolean search(int[] nums, int target) {
    int n = nums.length;
    int start = 0;
    int end = (n - 1);

    while(start <= end) {
      int mid = (start + end) >> 1;
      if(nums[mid] == target)
        return true;
      else if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
        start++;
        end--;
      }
      else if(nums[start] <= nums[mid]) {
        if(target >= nums[start] && target < nums[mid]) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if(target >= nums[mid + 1] && target <= nums[end]) {
          start = mid + 1;
        } else {
          end = mid -1 ;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = {2,5,6,0,0,1,2};
    int target = 0;

    System.out.println(search(nums, target));

    target = 3;
    System.out.println(search(nums, target));
  }
}
