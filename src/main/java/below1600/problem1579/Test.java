package below1600.problem1579;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {

    public static void main(String[] args) {
        new Test().maxNumEdgesToRemove(4, new int[][] {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}});
    }


    public int maxNumEdgesToRemove(int n, int[][] edges) {
//        Arrays.sort(edges, (k1, k2) -> k2[0] - k1[0]);
//        UnionFind uf = new UnionFind(n);
//        for(int[] temp: edges){
//            uf.union(temp);
//        }

//        只要求temp[0] == 3的在前面，可以不用排序
        UnionFind uf = new UnionFind(n);
        for(int[] temp: edges){
            if(temp[0] == 3)
                uf.union(temp);
        }
        for(int[] temp: edges){
            if(temp[0] != 3)
                uf.union(temp);
        }
        if(uf.setCountA != 1 || uf.setCountB != 1)
            return -1;
//        if(!uf.ifBind()) {
//            return -1;
//        }
        return uf.getToMins();
    }

}

class UnionFind {
    private int[] parentA;
    private int[] parentB;
    private int toMins;
    int setCountA;
    int setCountB;
    public UnionFind(int n) {
        toMins = 0;
        setCountA = n;
        setCountB = n;
        parentA = IntStream.rangeClosed(0, n).toArray();
        parentB = IntStream.rangeClosed(0, n).toArray();
    }
    public int findA(int k) {
        if(parentA[k] != k) {
            parentA[k] = findA(parentA[k]);
        }
        return parentA[k];
    }
    public int findB(int k) {
        if(parentB[k] != k) {
            parentB[k] = findB(parentB[k]);
        }
        return parentB[k];
    }
    public int getToMins() {
        return this.toMins;
    }
    public boolean ifBind() {
        int target = findA(parentA[1]);
        for(int i = 2; i < parentA.length; i++) {
            if(findA(parentA[i]) != target) {
                return false;
            }
        }
        target = findB(parentB[1]);
        for(int i = 2; i < parentB.length; i++) {
            if(findB(parentB[i]) != target) {
                return false;
            }
        }
        return true;
    }
    public void union(int[] temp) {
        int rooti = 0;
        int rootj = 0;
        boolean flag = false;
        if((temp[0] & 2) == 2) {
            rooti = findB(parentB[temp[1]]);
            rootj = findB(parentB[temp[2]]);
            if(rooti != rootj) {
                parentB[rooti] = rootj;
                setCountB--;
                flag = true;
            }
        }
        if((temp[0] & 1) == 1) {
            rooti = findA(parentA[temp[1]]);
            rootj = findA(parentA[temp[2]]);
            if(rooti != rootj) {
                parentA[rooti] = rootj;
                setCountA--;
                flag = true;
            }
        }
        if(!flag)
            toMins++;
    }
}
