class Solution {
    public boolean canJump(int[] nums) {
        
            int lastValidPos = nums.length - 1;  // this position defines if we are able to reach to this postion then we can reach to last

            for (int i = nums.length - 2; i >= 0 ; i--) {
                if (i + nums[i] >=  lastValidPos) { // if current position and maximum allowed jump for that pos surpasses last valid postion then consider the current position as next minim valid position
                    lastValidPos = i;
                }     
            }

            return lastValidPos == 0;

    }
}
