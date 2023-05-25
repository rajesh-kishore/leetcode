class Solution {
    public int addDigits(int num) {
        
       int n = num;
       while (n > 9) {
            int sum = 0;
            while (n != 0) {
                sum += (n%10);
                n = n/10;
            }
            n = sum;
        }
        
        return n;
    }
}
