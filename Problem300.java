class Solution {
    public int lengthOfLIS(int[] nums) {

        if (nums.length == 1) {
            return 1;
        }
        
        int dp[] = new int[nums.length];
        dp[nums.length - 1] = 1; // start from last , there is only subsequnce

        int overAllMaxSubsequnce = -1;

        
        for (int i = nums.length - 2; i >= 0; i--) { 

            int max = 1;
            //dp[i] = 1; // atleast one subsequnce
            // we need to iterate to the end to determine if number is lesser than CURRENT  one
            for (int j = i + 1 ; j < nums.length; j++) { 
                if (nums[i] < nums[j]) {
                    max =  Math.max(max , 1 + dp[j]);
                } 
            }
            dp[i] = max;
           //overAllMaxSubsequnce =  overAllMaxSubsequnce > max ? overAllMaxSubsequnce : max;
        }

        //int max = -1;
        for (int i = 0 ; i < dp.length ; i++) {
            overAllMaxSubsequnce = Math.max(overAllMaxSubsequnce, dp[i]);
        }

        
        return overAllMaxSubsequnce;

    }
}
