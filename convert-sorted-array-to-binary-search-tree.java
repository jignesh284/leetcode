class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums, 0, nums.length-1);
    }
    
    private TreeNode createBST(int[] nums, int left, int right) {
        if(right < left) {
            return null;
        }
        int mid = (right + left)/2;
        TreeNode leftTree = createBST(nums, left, mid-1);
        TreeNode rightTree = createBST(nums, mid+1, right);
        TreeNode node = new TreeNode(nums[mid], leftTree, rightTree);
        return node;
    }
}
