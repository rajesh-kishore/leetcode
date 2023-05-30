class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        /*
                    2
                    3    4 
                    6    5    7
                    4    1    8   3
        */


        for (int i = triangle.size() - 2 ; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                
                    int k;
                    int x = triangle.get(i).get(j) + triangle.get(i+1).get(j); // get next row same colum value
                    int y = triangle.get(i).get(j) + triangle.get(i+1).get(j+1);// get next row colum + 1 value
                    k = x > y ? y : x;
                    triangle.get(i).set(j, k); // keep updating the min value calculated for that row and column
            }
        }

        return triangle.get(0).get(0);

    }
}
