class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         
       Arrays.sort(candidates);
       List<List<Integer>> result = new LinkedList<>();
      // for (int i = 0; i < candidates.length; i++) {
       Set<Integer> startIngSequence = new HashSet<>();   
            generateCombinations(candidates, 0, 0, new ArrayList<>(), target , result);
       //}    
       return result;
    }


    void generateCombinations(int[] candidates, int index, int sumSoFar, List<Integer> intermediateResult, int target, List<List<Integer>> result) {
            
         // [1,2,2,2,5] TARGET 5

            if (sumSoFar == target) {
                List<Integer> rs = new LinkedList<>(intermediateResult);
                if (!result.contains((rs))) {
                  result.add(rs);

                }
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                if (sumSoFar +  candidates[i] > target) {
                    return;// since array is already sorted
                }
                if (i > index && candidates[i-1] == candidates[i]) { // for the cases where 2,2,2,3
                            continue; // with prev index as 2 , its evaluated , so no point of evaluating further
                } 

    
                intermediateResult.add(candidates[i]);
                generateCombinations(candidates, i + 1, sumSoFar + candidates[i], intermediateResult, target, result);
                intermediateResult.removeLast();
            }

    }
}
