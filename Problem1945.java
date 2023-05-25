class Solution {
    public int getLucky(String s, int k) {
        

        int sum = 0;

        // intial conversion from letter to number
        for (int i = 0 ; i < s.length(); i++) {
            int  num = (s.charAt(i) - 96); 
            if (num < 10) {
                sum += num;
            } else {
                // max it will be two digit because 'z' - 96 so no need for loop
                sum += (num % 10); 
                num = num / 10;
                sum += num; 
            }
        }

        if (k == 1) {
            return sum;
        }
        int count = 1; // first time conversion and sum done already
        
        int num = sum;
        while (count < k) {
            sum = 0;
            while (num != 0) {
                sum = sum + num % 10;
                num = num / 10;
            }
            count++;
            num = sum;
        }
        return sum;

    }
}
