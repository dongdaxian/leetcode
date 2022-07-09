package below500.problem452;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println(new Test().findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (int[] o1, int[] o2) -> {
            if (o1[0] <= o2[0]) return -1;
            else return 1;
        });
//        List<int[]> ls = new ArrayList<>();
//        for(int[] temp: points){
//            if(ls.size() == 0){
//                ls.add(temp);
//            } else {
//                int[] lastArr = ls.remove(ls.size() - 1);
//                if(lastArr[1] >= temp[0])
//                    ls.add(new int[]{temp[0], Math.min(lastArr[1], temp[1])});
//                else{
//                    ls.add(lastArr);
//                    ls.add(temp);
//                }
//            }
//        }
//        return ls.size();

        //ls的作用是保存上一个数组和记录数组总数，可以用一个int[]和int变量起相同作用，而保存int数组可以优化为保存int值
        int bound = Integer.MAX_VALUE;
        int res = 1;
        for (int[] temp : points) {
            if (temp[0] <= bound) {
                bound = Math.min(bound, temp[1]);
            } else {
                bound = temp[1];
                res++;
            }
        }
        return res;
    }

    //如果使用右端排序，就杜绝了左边数组完全包含右边数组的情况，此时不再需要取最小值
    public int findMinArrowShots2(int[][] points) {
        Arrays.sort(points, (int[] o1, int[] o2) -> {
            if (o1[1] <= o2[1]) return -1;
            else return 1;
        });
        int bound = Integer.MIN_VALUE;
        int res = 0;
        for (int[] temp : points) {
            if (temp[0] > bound) {
                bound = temp[1];
                res++;
            }
        }
        return res;
    }
}
