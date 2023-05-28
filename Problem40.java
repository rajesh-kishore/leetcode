class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         
         Arrays.sort(candidates);
         List<List<Integer>> results = new LinkedList<>();
         int prev = -1;
                for (int i = 0; i < candidates.length; i++) {
                    if (prev == candidates[i]) {
                        continue;
                    }
                    prev = candidates[i];
                      // try forming combination with each element as starting node
                    Deque<Integer> intermediateReult = new LinkedList<>();
                    intermediateReult.offerLast(candidates[i]); // consider the current element
                    getCombination(candidates, target - candidates[i], i + 1, intermediateReult, results);
                }
                return results;
    }


     // startIndex - since we need to move froward , we need to give startIndex
    void getCombination(int[] candidates, int target, int startIndex, Deque<Integer> intermediateReult, List<List<Integer>> results)  {

        if (target < 0) { // no point moving adding more calculation since numbers are positive
            return;
        }
       
       if (target == 0) { // we got the number
                 if (!results.contains(intermediateReult)) {
                        results.add(new LinkedList<>(intermediateReult)); // add to original list
                 }
                 return;
        }

        // always move forward , hence start from existing index
        for (int i = startIndex; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) { // if sum is less than or equal to sum , then only consider 
                intermediateReult.offerLast(candidates[i]);
                // fixing the current number and trying looking for combination further
                getCombination(candidates, target - candidates[i], i + 1, intermediateReult, results);
                intermediateReult.pollLast(); // exclude current element
            }
        }

    }
}
