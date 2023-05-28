class Solution {
    public int removeDuplicates(int[] nums) {
       int lastIndex = 0;
       for (int i = 1; i < nums.length ; i++) {
           if (nums[i] != nums[lastIndex]) {
               nums[++lastIndex] = nums[i];
           } else {

           }
        }
        return lastIndex + 1;
    }
}
