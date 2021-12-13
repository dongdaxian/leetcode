package below350.problem341;

import java.util.List;

public class MyNestedInteger implements NestedInteger{

    int atri;
    List<NestedInteger> atrl;

    public MyNestedInteger(int i) {
        atri = i;
    }

    public MyNestedInteger(List<NestedInteger> ls) {
        atrl = ls;
    }

    @Override
    public boolean isInteger() {
        return atrl == null;
    }

    @Override
    public Integer getInteger() {
        return atri;
    }

    @Override
    public List<NestedInteger> getList() {
        return atrl;
    }
}
