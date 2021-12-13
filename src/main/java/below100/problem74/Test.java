package below100.problem74;

public class Test {
//    可以分别对行列使用二分查找
//    也可以只用一次二分查找，此时right = m * n
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0])
            return false;
        int[] record = null;
        for (int i = 0; i < matrix.length; i++) {
            if (i + 1 == matrix.length || target < matrix[i + 1][0]) {
                record = matrix[i];
                break;
            }
        }
        if (record == null)
            return false;
        int left = 0, right = record.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (record[mid] == target) {
                return true;
            } else if (record[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
