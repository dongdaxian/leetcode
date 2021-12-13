package below600.problem566;

public class Test {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if(m * n != r * c)
            return nums;
        int[][] res = new int[r][c];
        int size = r * c;
        for(int i = 0; i < size; i++) {
            res[i / c][i % c] = nums[i / n][i % n];
        }
        return res;
    }

}
