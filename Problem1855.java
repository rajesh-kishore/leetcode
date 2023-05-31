class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
      // the idea is keep increasing ith index as long as you are getting nums[i] > nums[j]  because as per problem statement you want to ignore those 
      //  the moment we got nums[i] <= nums[j] , the will calculate the difference


    int n1 = nums1.length;
    int n2 = nums2.length;

    int i = 0;
    int j = 0;

    int max = 0;
    while (i < n1 && j < n2) {

        if (nums1[i] > nums2[j]) {
            i++; // we need to ignore such cases
        } else {
            if (i <= j) { // as long as the jth index is greater than ith index, calculate diff j - i
                max = Math.max(max, j - i);
            }
            j++;
        }
    }
      return max;
    }
}
