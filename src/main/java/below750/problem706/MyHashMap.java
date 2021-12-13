package below750.problem706;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


class MyHashMap {

    static final int INITALSIZE = 512;
    List<int[]>[] table;
    int size;
    int sizemask;
    int used;

    /** Initialize your data structure here. */
    public MyHashMap() {
        size = INITALSIZE;
        sizemask = INITALSIZE - 1;
        used = 0;
        table = new LinkedList[size];
        for(int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    public int nextPower(int size) {
        int ret = INITALSIZE;
        while(true) {
            if(ret > size)
                return ret;
            ret = ret * 2;
        }
    }

    public void expand(int tmpSize) {
        int realSize = nextPower(tmpSize);
        if(realSize == this.size) {
            return;
        }
        List<int[]>[] tmp = new LinkedList[realSize];
        for(int i = 0; i < realSize; i++) {
            tmp[i] = new LinkedList<>();
        }
        this.sizemask = realSize - 1;
        for(int i = 0; i < this.size; i++) {
            for(int[] key: table[i]) {
                int index = Integer.hashCode(key[0]) & this.sizemask;
                tmp[index].add(key);
            }
        }
        this.size = realSize;
        this.table = tmp;
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = Integer.hashCode(key) & sizemask;
        for(int[] tmp: this.table[index]) {
            if(tmp[0] == key) {
                tmp[1] = value;
                return;
            }
        }
        this.table[index].add(new int[]{key, value});
        used++;
        double ratio = used / size;
        if(ratio > 1) {
            expand(used * 2);
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = Integer.hashCode(key) & sizemask;
        List<int[]> ls = this.table[index];
        for(int[] tmp: ls) {
            if(tmp[0] == key) {
                return tmp[1];
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = Integer.hashCode(key) & sizemask;
        Iterator<int[]> it = this.table[index].iterator();
        while(it.hasNext()) {
            if(it.next()[0] == key) {
                it.remove();
                used--;
                expand(used);
                return;
            }
        }
    }
}
