package below150.problem126;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Test {

    public static void main(String[] args) {
        String beginWord = "maria";
        String endWord = "pearl";
//		List<String> wordList = new ArrayList<>();
//		wordList.add("maris");
//		wordList.add("paris");
//		wordList.add("marks");
//		wordList.add("parks");
        String[] wordList = new String[]{"maria", "perry", "peary", "paris", "parks", "perks", "peaks", "pears", "pearl", "parry", "maris", "marks", "merry"};
//		String beginWord = "a";
//		String endWord = "c";
//		List<String> wordList = new ArrayList<>();
//		wordList.add("a");
//		wordList.add("b");
//		wordList.add("c");

//		String beginWord = "qa";
//		String endWord = "sq";
//		String[] wordList = new String[]{"si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","sq","ye"};

        List<List<String>> ls = new Test().findLadders(beginWord, endWord, new ArrayList<String>(Arrays.asList(wordList)));
        for (int i = 0; i < ls.size(); i++) {
            List<String> temp = ls.get(i);
            for (String str : temp)
                System.out.print(str + " ");
            System.out.println();
        }

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord)) return res;
        dict.remove(endWord);
        dict.remove(beginWord);
        Set<String> beginset = new HashSet<>(), endset = new HashSet<>();
        Set<String> set;
        beginset.add(beginWord);
        endset.add(endWord);
        Map<String, List<String>> map = new HashMap<>();
        boolean flag = false;
        while (!beginset.isEmpty() && !endset.isEmpty()) {
            dict.removeAll(beginset);
            if (beginset.size() > endset.size()) {
                set = beginset;
                beginset = endset;
                endset = set;
                flag = !flag;
            }
            Set<String> visited = new HashSet<>();
            boolean breakout = false;
            for (String word : beginset) {
                //考虑到题目对于word长度的限制，这种方式时间复杂度最低
                for (int i = 0; i < word.length(); i++) {
                    char[] chars = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String toadd = String.valueOf(chars);
                        if (endset.contains(toadd)) {
                            breakout = true;
                            if (flag) {
                                List<String> ls = (map.containsKey(toadd) ? map.get(toadd) : new ArrayList<>());
                                ls.add(word);
                                map.put(toadd, ls);
                            } else {
                                List<String> ls = (map.containsKey(word) ? map.get(word) : new ArrayList<>());
                                ls.add(toadd);
                                map.put(word, ls);
                            }
                        } else if (dict.contains(toadd)) {
//	    					dict.remove(toadd);				//对于只求最短距离可以这么做，但是如果要求所有最短路径，不能这么做
                            visited.add(toadd);
                            if (flag) {
                                List<String> ls = (map.containsKey(toadd) ? map.get(toadd) : new ArrayList<>());
                                ls.add(word);
                                map.put(toadd, ls);
                            } else {
                                List<String> ls = (map.containsKey(word) ? map.get(word) : new ArrayList<>());
                                ls.add(toadd);
                                map.put(word, ls);
                            }
                        }
                    }
                }
            }
            if (breakout)
                break;
            beginset = visited;
        }
        List<String> temp = new ArrayList<>();
        temp.add(beginWord);
        getRes(map, res, temp, beginWord, endWord);
        return res;
    }

    //用回溯/DFS构造出路径
    public void getRes(Map<String, List<String>> map, List<List<String>> res, List<String> temp, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (!map.containsKey(beginWord))
            return;
        for (String word : map.get(beginWord)) {
            temp.add(word);
            getRes(map, res, temp, word, endWord);
            temp.remove(temp.size() - 1);
        }

    }


}
