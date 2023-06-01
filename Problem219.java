class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        Map<Integer, Integer> indicesByNum = new HashMap<>();
        indicesByNum.put(nums[0], 0);

        for (int i = 1 ; i < nums.length ;i++) {
            int existingIndex = indicesByNum.getOrDefault(nums[i], -1);
            if (existingIndex > -1 && i - existingIndex <= k) {
                return true;
            }
            indicesByNum.put(nums[i], i);
        }
        
        return false;
    }
}
