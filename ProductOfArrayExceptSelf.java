/******
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
******/


//Solution 1
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod =1;
        int[] result = new int[nums.length];
        int count = 0;
        for (int i:nums) {
            if(i == 0) { 
                count++;
            } else {
                prod *= i;  
            }
             
        }
        System.out.println(prod);
        for(int i=0; i<nums.length; i++) {
            if(count == 0) {
                result[i] = prod/nums[i];  
            } else if(count == 1) {
                if(nums[i] == 0) result[i] = prod;
            } else {
               return result; 
            }
            
        }
        return result;
    }
}




//Solution 2
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productBefore = new int[nums.length];
        int[] productAfter = new int[nums.length];
        productBefore[0] = 1;
        productAfter[nums.length-1] = 1;
        
        int product = 1;
        for (int i = 1; i < nums.length; i++) {
            productBefore[i] = productBefore[i-1] * nums[i-1];
        }
        
        product = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            productAfter[i] = productAfter[i+1] * nums[i+1];
        }
        
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = productBefore[i] * productAfter[i];
        }
        
        return output;
    }
}
