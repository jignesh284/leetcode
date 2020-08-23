class Solution {
    public void sortColors(int[] nums) {
        int iZero = 0;
        int iOne = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                nums[i] = nums[iOne];
                nums[iOne] = nums[iZero];
                nums[iZero] = 0;
                iOne++;
                iZero++;
            } else if(nums[i] == 1) {
                nums[i] = nums[iOne];
                nums[iOne] = 1;
                iOne++;
            } 
        }
        
    }
}
