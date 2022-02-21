package nowcoder.jianzhi;

public class Solution4 {
    //错误解法，要从右上角开始，且不是只有两个方向
    public boolean Find(int target, int [][] array) {
        int i = 0;
        int j = 0;
        if (array.length == 0 || array[0].length == 0 || array[0][0] > target) {
            return false;
        }
        for (; j < array[0].length && array[0][j] <= target; j++);
        j = j - 1;
        for (; i < array.length; i++) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] > target) {
                break;
            }
        }
        return false;
    }

    public boolean Find2(int target, int [][] array) {

        if (array.length == 0 || array[0].length == 0) {
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j > -1) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }

}
