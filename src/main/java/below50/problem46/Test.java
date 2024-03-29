package below50.problem46;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4};
        List<List<Integer>> res = new Test().permute(num);
        System.out.println(res.size());
        for (List<Integer> ls : res) {
            for (Integer i : ls)
                System.out.print(i + " ");
            System.out.println();
        }

    }

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        List<Integer> ls = new ArrayList<>();

		backtrack_insert(nums, res, new ArrayList<>(), 0);

//        res.add(ls);
//        backtrack_insert2(nums, res, 0);

//        backtrack_choose(nums, res, new ArrayList<>());

//        backtrack_swap(nums, res, 0);

        return res;
    }

    // 采用DFS/回溯的插入
    public void backtrack_insert(int[] num, LinkedList<List<Integer>> res, List<Integer> ls, int pos) {
        if (pos == num.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for (int i = 0; i <= pos; i++) {
            ls.add(i, num[pos]);
            backtrack_insert(num, res, ls, pos + 1);
            ls.remove(i);
        }
    }

    // 采用BFS的插入
    public void backtrack_insert2(int[] num, LinkedList<List<Integer>> res, int pos) {
        if (pos == num.length)
            return;
        int size = res.size();
        for (int i = 0; i < size; i++) {
            List<Integer> temp = res.removeFirst();
            for (int j = 0; j <= pos; j++) {
                temp.add(j, num[pos]);
                res.addLast(new ArrayList<>(temp));
                temp.remove(j);
            }
        }
        backtrack_insert2(num, res, pos + 1);
    }


    // 采用DFS/回溯的选择（与选择排序无关）
    public void backtrack_choose(int[] num, List<List<Integer>> res, List<Integer> ls) {
        if (ls.size() == num.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        for (int i : num) {
            if (ls.contains(i)) continue;  //也可以用一个boolean数组来判断是否已经选择过
            ls.add(i);
            backtrack_choose(num, res, ls);
            ls.remove(ls.size() - 1);
        }
    }

    // 采用DFS/回溯的交换
    public void backtrack_swap(int[] num, List<List<Integer>> res, int pos) {
        if (pos == num.length) {
//			res.add(new ArrayList<>(Arrays.asList(num)));   //int[]数组不支持Arrays.asList(),它认为num是列表中一个元素
            res.add(Arrays.stream(num).boxed().collect(Collectors.toList()));
            return;
        }
        //for (int i = pos; i > -1; i--) {    //也行
        for (int i = pos; i < num.length; i++) {
            int temp = num[i];
            num[i] = num[pos];
            num[pos] = temp;
            backtrack_swap(num, res, pos + 1);
            temp = num[i];
            num[i] = num[pos];
            num[pos] = temp;
        }
    }

}
