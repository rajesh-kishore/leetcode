class Pair {
    Integer num;
    int frequency;
    
    Pair(int num, int freq) {
        this.num = num;
        frequency = freq;
    }
 
}

class Solution {
    
    public boolean isPossibleDivide(int[] nums, int k) {
        
        Map<Integer, Pair> numsByFrequency = new HashMap<>();

        // collect the frequency of each number
        for (int num : nums) {
            Pair p = numsByFrequency.getOrDefault(num, new Pair(num, 0));
            p.frequency++;      
            numsByFrequency.put(num, p);
         }
        
       
        
        PriorityQueue<Pair> minHeap = new PriorityQueue<>( (p, q) -> Integer.compare(p.num, q.num));
        // prepare the min heap based on number increasing value
        for (Map.Entry<Integer, Pair> entry : numsByFrequency.entrySet()) {
            minHeap.offer(entry.getValue());
        }
        
        numsByFrequency = null;
       
       
        int count = 0;
        
        /* 
            at this minHeap is prepared like 
            {1(3), 2(3), 3(3)}
        
            original request was 1,3,2,1,2,3
        */
        
        while (!minHeap.isEmpty()) {
            
            Pair topElement = minHeap.peek();
            int lastNum = topElement.num;
            lastNum--; // just to compare current number with last number
            List<Pair> intermediateList = new LinkedList<>();
            
            
            // collect k consecutive numbers until heap is not empty
            while (count != k  && !minHeap.isEmpty()) {
                
                Pair currentElement = minHeap.poll();
                
                currentElement.frequency--; // decrease frequency
                
                if (currentElement.frequency > 0) {
                   intermediateList.add(currentElement); // add it so that again after k consequitive numbers its put back to minHeap
                }
            
            
                if (currentElement.num != lastNum + 1) { // test for consequitiveness
                    return false;
                }
            
                count++;
                lastNum = currentElement.num;
            }
            
            if (count != k) {
                return false;
            }
            
            for (Pair p : intermediateList) {
                minHeap.offer(p); // re - add the numbers whose frequency is still more than 0
            }
            
            count = 0; 
        }
        
        return count == 0; 
        
    }
}
