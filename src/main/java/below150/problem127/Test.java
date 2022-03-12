package below150.problem127;

import java.util.*;

public class Test {

    public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(new Test().ladderLength5(beginWord, endWord, wordList));
//        String beginWord = "qa";
//        String endWord = "sq";
//        String[] wordList = new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "sq", "ye"};
//        System.out.println(new Test().ladderLength(beginWord, endWord, new ArrayList<>(Arrays.asList(wordList))));

    }

    //dfs的方式，会超时
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) return 1;
        if (!wordList.contains(endWord)) return 0;
        List<String> ls = getNeighbors(beginWord, wordList);
        int len = Integer.MAX_VALUE;
        for (String temp : ls) {
            wordList.remove(temp);
            int num = ladderLength(temp, endWord, wordList);
            if (num != 0)
                len = Integer.min(len, num);
            wordList.add(temp);   //dfs的方式，必须把temp添加回去
        }
        if (len == Integer.MAX_VALUE)
            return 0;
        return len + 1;
    }

    public List<String> getNeighbors(String beginWord, List<String> wordList) {
        List<String> ls = new ArrayList<>();
        for (String temp : wordList) {
            int diff = 0;
            for (int i = 0; i < beginWord.length() && diff < 2; i++) {
                if (temp.charAt(i) != beginWord.charAt(i))
                    diff++;
            }
            if (diff < 2)
                ls.add(temp);
        }
        return ls;
    }

    //bfs不缩减wordList大小，会超时
    public int ladderLength5(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        Map<String, List<String>> map = getNeighbors(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int diff = 1;
        int maxDiff = wordList.size();
        while (!queue.isEmpty()) {
            int size = queue.size();
            diff++;
            if (diff > maxDiff) {
                break;
            }
            for (int i = 0; i < size; i++) {
                String beg = queue.poll();
                for (String tmp : map.get(beg)) {
                    if (tmp.equals(endWord)) {
                        return diff;
                    } else {
                        queue.offer(tmp);
                    }
                }
            }
        }

        return 0;
    }
    public Map<String, List<String>> getNeighbors(List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Map<String, List<String>> ret = new HashMap<>();
        for (String tmp : set) {
            ret.putIfAbsent(tmp, new ArrayList<>());
            for (int i = 0; i < tmp.length(); i++) {
                char[] chars = tmp.toCharArray();
                char pre = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    if (ch == pre) {
                        continue;
                    }
                    chars[i] = ch;
                    if (set.contains(String.valueOf(chars))) {
                        ret.get(tmp).add(String.valueOf(chars));
                    }
                }
            }
        }

        return ret;
    }


    //bfs
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        Set<String> set = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 0;
        while (!reached.contains(endWord)) {
            Set<String> nextReached = new HashSet<>();
            for (String temp : reached) {
//				for(String toadd: wordList) {
//					int diff = 0;
//					for(int i = 0; i < len && diff < 2; i++) {
//						if(temp.charAt(i) != toadd.charAt(i))
//							diff++;
//					}
//					if(diff < 2) {
//						nextReached.add(toadd);
//						wordList.remove(toadd);		//会抛出异常
//					}
//				}
                for (int i = 0; i < temp.length(); i++) {
                    char[] chars = temp.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (set.contains(word)) {    //如果wordList定义成ArrayList或者Set，remove是有返回值的，可以作为条件
                            nextReached.add(word);
                            set.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (nextReached.size() == 0) return 0;
            reached = nextReached;
        }
        return distance + 1;
    }

    //方法2每次都要创建一个新的Set，如果使用Queue则不必
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        int distance = 0;
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {        //用queue判断contains(endWord)会比较慢，所以改成在加入集合时先判断是否与endWord相同
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String temp = queue.poll();
                for (int i = 0; i < temp.length(); i++) {
                    char[] chars = temp.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (set.contains(word)) {
                            if (word.equals(endWord))
                                return distance + 2;
                            queue.offer(word);
                            set.remove(word);
                        }
                    }
                }
            }
            distance++;
        }
        return 0;
    }


    //双向搜索，对于这道题，降低了时间复杂度
    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        int distance = 1;
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> beginQue = new LinkedList<>(), endQue = new LinkedList<>();
        Queue<String> temp;
        beginQue.offer(beginWord);
        endQue.offer(endWord);
        while (!beginQue.isEmpty() && !endQue.isEmpty()) {
            if (beginQue.size() > endQue.size()) {
                temp = beginQue;
                beginQue = endQue;
                endQue = temp;
            }
            int size = beginQue.size();
            for (int j = 0; j < size; j++) {
                String word = beginQue.poll();
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String toadd = new String(chars);
                        if (endQue.contains(toadd))            //因为这里有一个搜索操作，所以最好用HashSet(即使这样会导致创建额外的HashSet)
                            return distance + 1;
                        if (set.remove(toadd))
                            beginQue.offer(toadd);
                    }
                }
            }
            distance++;
        }
        return 0;
    }
}
