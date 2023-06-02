class Solution {
    public int minSubArrayLen(int target, int[] nums) {

            int lastLeftIndex = 0;
            int currentSum = 0;

            int minSubbaryALength = nums.length + 1; // assume there i
            for (int i = 0 ; i < nums.length ; i++) {
                    
                    currentSum += nums[i]; // keep adding into current sum

                    while (currentSum >= target) { // keep decrementing last left index until this condition remains true
                            minSubbaryALength = Math.min(minSubbaryALength, i - lastLeftIndex + 1); // keep calculating min subarray length
                            currentSum -=  nums[lastLeftIndex]; 
                            lastLeftIndex++; // keep incrementing last left index
                    }
            }

            return minSubbaryALength == nums.length + 1 ? 0 : minSubbaryALength;
    }
}
