class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        
        
        /*
        [4, 3, 2, 7, 8, 2, 3, 1]
         0  1  2  3  4  5  6  7
           -3 -2 -7       -3 -1
        
        
        
        */
        
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1]  > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        
        final List<Integer> result = new LinkedList<>();
        
        for (int i = 0; i < nums.length; i++) {
           if (nums[i] > 0) {
               result.add(i+1);
           }    
        }
        
        return result;
    }
}
