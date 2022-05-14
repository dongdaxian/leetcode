package below400.problem381;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RandomizedCollection {
    List<Integer> ls;
    Map<Integer, Set<Integer>> map;

    public RandomizedCollection() {
        ls = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        ls.add(val);
        Set<Integer> set = map.getOrDefault(val, new HashSet<Integer>());
        set.add(ls.size() - 1);
        map.put(val, set);
        return set.size() == 1;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        Set<Integer> set = map.get(val);
        int temp = set.iterator().next();
        set.remove(temp);
        int lastElement = ls.get(ls.size() - 1);
        ls.set(temp, lastElement);
        map.get(lastElement).remove(ls.size() - 1);
        if (temp != ls.size() - 1)
            map.get(lastElement).add(temp);
        if (map.get(val).size() == 0)
            map.remove(val);
        ls.remove(ls.size() - 1);
        return true;
    }

    public int getRandom() {
        return ls.get((int) (Math.random() * ls.size()));
    }
}
