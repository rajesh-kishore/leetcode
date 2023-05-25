class Solution {
    public boolean isHappy(int n) {
//23 -> 7 -> 

            HashSet<Integer> duplicates = new HashSet<>(); 
         while (n != 0 && !duplicates.contains(n)) {

            duplicates.add(n);// we need to add this because we might end up processing same number again and again   

           // we start summing up square of number form last digit of number
           int sum = 0;
           while (n != 0) {
               int remainder = n % 10; // identify last digit by doing mod operation
               sum += remainder * remainder; 
               n = n/10;
           }

           n = sum; // repeat the process again

         }

        return n == 1;
    }
}
