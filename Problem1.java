class Solution {
    public int[] twoSum(int[] nums, int target) {

       Map<Integer, Integer> numberByIndex = new HashMap<>();

       for (int i = 0 ; i < nums.length ; i++) {
           Integer index = numberByIndex.get(nums[i]);
           if (!Objects.isNull(index)) {
               return new int[] {index, i};
           }
            numberByIndex.put(target - nums[i], i);

       }
        return null;

    }
}
