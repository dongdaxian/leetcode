package below750.problem705;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    static final int INITALSIZE = 512;
    List<Integer>[] table;
    int size;
    int sizemask;
    int used;

    public MyHashSet() {
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
        List<Integer>[] tmp = new LinkedList[realSize];
        for(int i = 0; i < realSize; i++) {
            tmp[i] = new LinkedList<>();
        }
        this.sizemask = realSize - 1;
        for(int i = 0; i < this.size; i++) {
            for(int key: table[i]) {
                int index = Integer.hashCode(key) & this.sizemask;
                tmp[index].add(key);
            }
        }
        this.size = realSize;
        this.table = tmp;
    }

    public void add(int key) {
        int index = Integer.hashCode(key) & sizemask;
        for(int tmp: this.table[index]) {
            if(tmp == key)
                return;
        }
        this.table[index].add(key);
        used++;
        double ratio = used / size;
        if(ratio > 1) {
            expand(used * 2);
        }
    }

    public void remove(int key) {
        int index = Integer.hashCode(key) & sizemask;
        Iterator<Integer> it = this.table[index].iterator();
        while(it.hasNext()) {
            if(it.next() == key) {
                it.remove();
                used--;
                expand(used);
                return;
            }
        }

    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = Integer.hashCode(key) & sizemask;
        List<Integer> ls = this.table[index];
        for(int tmp: ls) {
            if(tmp == key) {
                return true;
            }
        }
        return false;
    }
}
