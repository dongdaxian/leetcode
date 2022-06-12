package below400.problem399;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        equations.add(Arrays.asList(new String[]{"a", "b"}));
        equations.add(Arrays.asList(new String[]{"b", "c"}));

        queries.add(Arrays.asList(new String[]{"a", "c"}));
        queries.add(Arrays.asList(new String[]{"b", "a"}));
        queries.add(Arrays.asList(new String[]{"a", "e"}));
        queries.add(Arrays.asList(new String[]{"a", "a"}));
        queries.add(Arrays.asList(new String[]{"x", "x"}));
    }

    //queries中的每一对，用dfs、bfs都可以
    //并查集
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int len = values.length;
        Map<String, Integer> map = new HashMap<>();
        //按可能的最大长度来
        UnionFind uf = new UnionFind(2 * len);
        double[] res = new double[queries.size()];
        int index = 0;
        for (int i = 0; i < len; i++) {
            List<String> ls = equations.get(i);
            String temp1 = ls.get(0);
            String temp2 = ls.get(1);
            if (!map.containsKey(temp1)) {
                map.put(temp1, index++);
            }
            if (!map.containsKey(temp2)) {
                map.put(temp2, index++);
            }
            int num1 = map.get(temp1);
            int num2 = map.get(temp2);
            uf.union(num1, num2, values[i]);
        }
        index = 0;
        for (List<String> ls : queries) {
            String temp1 = ls.get(0);
            String temp2 = ls.get(1);
            if (!map.containsKey(temp1) || !map.containsKey(temp2)) {
                res[index] = -1;
            } else {
                res[index] = uf.isConnected(map.get(temp1), map.get(temp2));
            }
            index++;
        }

        return res;
    }

    //弗洛伊德算法
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        int index = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> ls : equations) {
            String temp1 = ls.get(0);
            String temp2 = ls.get(1);
            if (!map.containsKey(temp1)) {
                map.put(temp1, index++);
            }
            if (!map.containsKey(temp2)) {
                map.put(temp2, index++);
            }
        }
        int size = map.size();
        double[][] val = new double[size][size];
        for (int i = 0; i < size; i++) {
            Arrays.fill(val[i], -1);
            val[i][i] = 1;
        }

        //如果不在意空间消耗的话，可以把val维度设置成2 * equations.size()，这一步就可以和第一步合并
        int len = values.length;
        for (int i = 0; i < len; i++) {
            List<String> ls = equations.get(i);
            int index1 = map.get(ls.get(0));
            int index2 = map.get(ls.get(1));
            val[index1][index2] = values[i];
            val[index2][index1] = 1 / values[i];
        }
        for (int k = 0; k < size; k++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (val[i][k] > 0 && val[k][j] > 0) {
                        val[i][j] = val[i][k] * val[k][j];
                    }
                }
            }
        }
        index = 0;
        for (List<String> ls : queries) {
            String temp1 = ls.get(0);
            String temp2 = ls.get(1);
            if (!map.containsKey(temp1) || !map.containsKey(temp2)) {
                res[index] = -1;
            } else {
                res[index] = val[map.get(temp1)][map.get(temp2)];
            }
            index++;
        }

        return res;
    }

}

class UnionFind {
    int[] parent;
    double[] val;

    public UnionFind(int n) {
        parent = new int[n];
        val = new double[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        Arrays.fill(val, 1);
    }

    //并查集中，在使用一个元素前一定会更新关系，所以我们用到的元素的val值一定能得到更新
    public int find(int tar) {
        if (parent[tar] != tar) {
            int temp = parent[tar];
            parent[tar] = find(temp);
            val[tar] *= val[temp];
        }
        return parent[tar];
    }

    public void union(int i, int j, double value) {
        int rooti = find(i);
        int rootj = find(j);
        if (rooti != rootj) {
            parent[rooti] = rootj;
            //要使得满足val[i] / val[j] = value
            //先更新父节点，当要用到i节点时再更新val值
            val[rooti] = val[j] * value / val[i];
        }
    }

    public double isConnected(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx != rooty) {
            return 1.0;
        }
        return val[x] / val[y];
    }

}
