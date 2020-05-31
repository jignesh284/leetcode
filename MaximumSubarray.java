/**********
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

```
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
```

Follow up:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
***********/

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];                        // Max continous value so for
        int cm_min = (nums[0] > 0) ? 0 : nums[0]; // Minimum cumulative value till index i.
        int cm = nums[0];                         //cumulative value till index i
        for(int i=1; i<nums.length; i++) {
            cm += nums[i];
            int temp_max = cm - cm_min;
            if(temp_max > max) max = temp_max;
            if(cm < cm_min) cm_min = cm;
        }
        return max;
    }
}
