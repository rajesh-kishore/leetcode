class Solution {
    public int[] twoSum(int[] numbers, int target) {
        

            int startIndex = 0;
            int endIndex = numbers.length - 1;
            // 2 3 4        5. 
            while (startIndex < endIndex) {

                    int sum = numbers[startIndex] + numbers[endIndex];

                    if (sum == target) {
                        return new int[] {startIndex + 1, endIndex + 1};
                    } else if (sum > target) {
                        endIndex--;
                    } else {
                        startIndex++;
                    }

            }

            return null;

    }
}
