package nowcoder.jianzhi;

import java.util.Arrays;

public class Solution51 {

    public static void main(String[] args) {
        System.out.print(new Solution51().InversePairs(new int[]{7, 5, 6, 4, 3}));
    }

    //暴力方法其实就是选择排序，此处是归并排序
    public int InversePairs(int[] array) {
        if (array.length < 2) {
            return 0;
        }
        return InversePairs(array, 0, array.length - 1);
    }
    public int InversePairs(int[] array, int left, int right) {
        if (left == right)
            return 0;
        int mid = left + (right - left) / 2;
        int leftCount = InversePairs(array, left, mid);
        int rightCount = InversePairs(array, mid + 1, right);
        int crossCount = mergeAndCount(array, left, mid, right);
        return leftCount + rightCount + crossCount;
    }

    public int mergeAndCount(int[] array, int left, int mid, int right) {
        int i = 0, j = mid - left + 1;
        int count = 0;
        int[] tmp = Arrays.copyOfRange(array, left, right + 1);
        for (int k = 0; k < right - left + 1; k++) {
            if (i == (mid - left + 1)) {
                array[left + k] = tmp[j++];
            } else if (j == (right - left + 1)) {
                array[left + k] = tmp[i++];
            } else if (tmp[i] <= tmp[j]) {
                array[left + k] = tmp[i++];
            } else {
                array[left + k] = tmp[j++];
                count += (mid - left - i + 1);
            }
        }
        return count;
    }
}
