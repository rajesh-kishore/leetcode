class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
               List<List<Integer>> results = new LinkedList<>();

               results.add(new LinkedList<>()); // include nothing

                for (int i = 0; i < nums.length; i++) {
                        // try forming combination with each element as starting node
                        Deque<Integer> intermediateReult = new LinkedList<>();
                        intermediateReult.offerLast(nums[i]);
                        getCombination(nums, i + 1, intermediateReult, results);
                   
                }
                return results;
    }

    
     void getCombination(int[] candidates, int startIndex, Deque<Integer> intermediateReult, List<List<Integer>> results)  {

        results.add(new LinkedList<>(intermediateReult)); // add to original list
      
        // always move forward , hence start from existing index
        for (int i = startIndex; i < candidates.length; i++) {
                intermediateReult.offerLast(candidates[i]);
                // fixing the current number and trying looking for combination further
                getCombination(candidates, i + 1, intermediateReult, results);
                intermediateReult.pollLast(); // exclude current element
        }
    }

}
