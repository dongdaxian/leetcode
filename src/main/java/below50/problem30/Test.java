package below50.problem30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        //String s = "wordgoodgoodgoodbestword";
        //String[] words = new String[]{"word", "good", "best", "good"};
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};
        List<Integer> rs = new Test().findSubstring2(s, words);
        for (Integer a : rs) {
            System.out.println(a);
        }

    }

    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null || words == null || words.length == 0 || words[0].length() == 0) return null;
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        int slen = s.length(), arrlen = words.length, wordlen = words[0].length();
        for (int i = 0; i < arrlen; i++)
            map1.put(words[i], map1.getOrDefault(words[i], 0) + 1);
        List<Integer> rs = new ArrayList<Integer>();

        //ʱ�临�Ӷ���O(wordlen * (slen / wordlen))��O(slen)��ʹ���˻������ڵ�˼��
        //ʵ�����������wordLen���������Ļ���hash�����е�equals()ʱ�临�Ӷ���O(wordLen)��ʱ�临�ӶȲ�Ӧ����O(slen)
        for (int i = 0; i < wordlen; i++) {
            int count = 0;                                                        //��¼����map2��word����
            for (int end = i, beg = i; end + wordlen <= slen; end += wordlen) {
                String temp = s.substring(end, end + wordlen);

                if (map1.containsKey(temp)) {
                    while (map2.getOrDefault(temp, 0) + 1 > map1.get(temp)) {
                        String begstr = s.substring(beg, beg + wordlen);
                        map2.put(begstr, map2.get(begstr) - 1);
                        beg += wordlen;
                        count--;
                    }
                    map2.put(temp, map2.getOrDefault(temp, 0) + 1);
                    count++;
                    if (count == arrlen) {
                        rs.add(beg);
                        count--;
                        String begstr = s.substring(beg, beg + wordlen);
                        map2.put(begstr, map2.get(begstr) - 1);
                        beg += wordlen;
                    }
                } else {
                    beg = end + wordlen;
                    map2.clear();
                    count = 0;
                }
            }
            map2.clear();
        }
        return rs;
    }

    public List<Integer> findSubstring2(String s, String[] words) {
        if (s == null || words == null || words.length == 0 || words[0].length() == 0) return null;
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        int slen = s.length(), arrlen = words.length, wordlen = words[0].length();
        for (int i = 0; i < arrlen; i++)
            map1.put(words[i], map1.getOrDefault(words[i], 0) + 1);
        List<Integer> rs = new ArrayList<Integer>();


        for (int i = 0; i < wordlen; i++) {
            int count = 0;
            for (int end = i, beg = i; end + wordlen <= slen; end += wordlen) {
                String temp = s.substring(end, end + wordlen);

                if (map2.getOrDefault(temp, 0) + 1 > map1.getOrDefault(temp, 0)) {
                    String begstr = s.substring(beg, beg + wordlen);
                    if (map2.containsKey(begstr)) {
                        map2.put(begstr, map2.get(begstr) - 1);
                        count--;
                    }
                    beg += wordlen;
                    if (beg <= end)
                        end -= wordlen;
                    continue;
                }
                map2.put(temp, map2.getOrDefault(temp, 0) + 1);
                count++;
                if (count == arrlen) {
                    rs.add(beg);
                    count--;
                    String begstr = s.substring(beg, beg + wordlen);
                    map2.put(begstr, map2.get(begstr) - 1);
                    beg += wordlen;
                }

            }
            map2.clear();
        }
        return rs;
    }

}
