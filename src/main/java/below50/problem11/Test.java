package below50.problem11;

public class Test {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Test().maxArea(height));
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int leftmax = height[i], rightmax = height[j];
        int max = 0;
        while (i < j) {
            if (height[i] > leftmax) leftmax = height[i];
            if (height[j] > rightmax) rightmax = height[j];
            if (leftmax < rightmax) {
                max = Math.max(max, leftmax * (j - i));
                i++;
            } else {
                max = Math.max(max, rightmax * (j - i));
                j--;
            }
        }
        return max;
    }

}
