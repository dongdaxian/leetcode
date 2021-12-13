package below750.problem721;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	public static void main(String[] args) {
		String[][] ary = new String[][] {{"Hanzo","Hanzo2@m.co","Hanzo3@m.co"},{"Hanzo","Hanzo4@m.co","Hanzo5@m.co"},{"Hanzo","Hanzo0@m.co","Hanzo1@m.co"},{"Hanzo","Hanzo3@m.co","Hanzo4@m.co"},{"Hanzo","Hanzo7@m.co","Hanzo8@m.co"},{"Hanzo","Hanzo1@m.co","Hanzo2@m.co"},{"Hanzo","Hanzo6@m.co","Hanzo7@m.co"},{"Hanzo","Hanzo5@m.co","Hanzo6@m.co"}};
		List<List<String>> ls = Arrays.stream(ary).map(k -> Arrays.stream(k).collect(Collectors.toList())).collect(Collectors.toList());
		new Test().accountsMerge(ls);
	}
	
//	����ⷨ�Ǵ���ġ�����List������a��b��b��c����ʱa��b��һ��sp��c����һ��sp������sp��ָ��set��ͬ�����������һ��List��c��d����ôֻ���޸�cָ���spָ���set��
//	��a��bָ���spָ���set���䡣��̬����û�������ã�ԭ���ǲ��ܱ�֤ʹ��ͬһ���������
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, SetProxy> map = new HashMap<>();
        Map<String, String> email2name = new HashMap<>(); 
        Set<Set<String>> ress = new HashSet<>(); 
        Set<SetProxy> proset = new HashSet<>();
        for(List<String> ls: accounts) {
            String name = ls.get(0);
            Set<String> set = new HashSet<>(ls);
            set.remove(name);
            SetProxy sp = new SetProxy(set);
            proset.add(sp);
            Set<String> set2 = new HashSet<>(set);
            for(String email: set2) {
            	email2name.put(email, name);
            	if(map.containsKey(email)) {
            		SetProxy tempSp = map.get(email);
            		if(ress.contains(tempSp.set))
            			ress.remove(tempSp.set);
            		set.addAll(tempSp.set);
            		tempSp.changeSet(set);
            		
            	} else {
            		map.put(email, sp);
            	}
            }
            ress.add(set);
        }
        
        List<List<String>> res = new ArrayList<>();
        for(Set<String> set: ress) {
        	String name = email2name.get(set.iterator().next());
        	List<String> ls = new ArrayList<>(set);
        	Collections.sort(ls);
        	ls.add(0, name);
        	res.add(ls);
        }
        return res;
    }
	
//	�����������飬����ͨͼ���⣬�ò��鼯�����
//	���䲻ͬ�������϶���ͬ������ֱ����������key����������<���䣬����>
	public List<List<String>> accountsMerge2(List<List<String>> accounts) {
        Map<String, String> email2name = new HashMap<>();
        UnionFind uf = new UnionFind();
        for(List<String> ls: accounts) {
            String name = ls.get(0);
            String firstEmail = ls.get(1);
            uf.find(firstEmail);
            email2name.put(firstEmail, name);
            for(int i = 2; i < ls.size(); i++) {
                String email = ls.get(i);
                email2name.put(email, name);
                uf.union(email, firstEmail);
            }
        }
        Map<String, List<String>> preRes = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        Set<String> set = uf.getKeySet();
        for(String temp: set) {
            String par = uf.find(temp);
            preRes.computeIfAbsent(par, k -> new ArrayList<>()).add(temp);
        }
        for(String email: preRes.keySet()) {
            List<String> temp = preRes.get(email);
            Collections.sort(temp);
            temp.add(0, email2name.get(email));
            res.add(temp);
        }
        return res;
    }
	
	
}

class SetProxy {
	public Set<String> set;
	public SetProxy(Set<String> set) {
		this.set = set;
	}
	public void changeSet(Set<String> set) {
		this.set = set;
	}
}

class UnionFind {
    private Map<String, String> parent;
    public UnionFind() {
        parent = new HashMap<>();
    }

    public String find(String child) {
        if(!parent.containsKey(child)) {
            parent.put(child, child);
        } else if(!parent.get(child).equals(child)) {
            parent.put(child, find(parent.get(child)));
        }
        return parent.get(child);
    }

    public void union(String t1, String t2) {
        String t1p = find(t1);
        String t2p = find(t2);
        if(!t1p.equals(t2p)) {
            parent.put(t1p, t2p);
        }
    }

    public Set<String> getKeySet() {
        return this.parent.keySet();
    }

}

