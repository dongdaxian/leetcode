package below350.problem341;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    List<NestedInteger> nestedList;
    Iterator<NestedInteger> iterator;
    NestedIterator sub;
    NestedInteger record;


    public static void main(String[] args) {
        NestedInteger n1 = new MyNestedInteger(1);
        NestedInteger n2 = new MyNestedInteger(1);
        NestedInteger n3 = new MyNestedInteger(Arrays.asList(n1, n2));
        NestedInteger n4 = new MyNestedInteger(2);
        NestedInteger n5 = new MyNestedInteger(1);
        NestedInteger n6 = new MyNestedInteger(1);
        NestedInteger n7 = new MyNestedInteger(Arrays.asList(n5, n6));
        NestedIterator nt = new NestedIterator(Arrays.asList(n3, n4, n7));
        while (nt.hasNext()) {
            System.out.println(nt.next());
        }
    }

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        iterator = nestedList.iterator();
        sub = null;
    }

    @Override
    public Integer next() {
        if (record != null) {
            int tmp = record.getInteger();
            record = null;
            return tmp;
        }
        return sub.next();
    }

    //元素NestedInteger可能是空List，所以hasNext预先取出了next()将要返回元素，与平常hasNext逻辑不同
    @Override
    public boolean hasNext() {
        if (record != null)
            return true;
        boolean flag = (sub == null || !sub.hasNext());
        while (flag && iterator.hasNext()) {
            NestedInteger tmp = iterator.next();
            if (tmp.isInteger()) {
                record = tmp;
                return true;
            }
            sub = new NestedIterator(tmp.getList());
            flag = !sub.hasNext();
        }
        return !flag;
    }
}
