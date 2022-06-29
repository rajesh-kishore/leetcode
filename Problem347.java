class Pair {
    int number;
    int frequency;
    
    Pair(int num, int freq) {
        number = num;
        frequency = freq;
    }
}

class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        
        // first get the frequecny of each unique number
        for (int num : nums) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }
        
        // start adding in minHeap based on frequency increasing order
        PriorityQueue<Pair> minHeap = new PriorityQueue<> ( (p, q) -> p.frequency - q.frequency);
        
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyCount.entrySet()) {
            
            if (count < k) { // until we reach top k , keep adding
                minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() > minHeap.peek().frequency) { // once we reach top k, we have to see if the top element of minHeap has lesser frequency than current frequency count
                minHeap.poll();   // remove uncessary top element 
                minHeap.offer(new Pair(entry.getKey(), entry.getValue())); // add with higher frequency
            }
            count++;
        }
        
        int[] result = new int[minHeap.size()];
        count = 0;
        while (!minHeap.isEmpty()) { // drain out to result.
            result[count++] = minHeap.poll().number;
        }
        
        return result;
    }
}
