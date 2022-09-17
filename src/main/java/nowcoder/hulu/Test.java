package nowcoder.hulu;


import java.util.*;

//hulu  2022.9.16
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            System.out.print(-1);
            return;
        }
        sc.nextLine();
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] array = input.split(" ");
            map.putIfAbsent(array[1], new HashSet<>());
            map.get(array[1]).add(array[0]);
        }
        int standard = sc.nextInt();
        List<String> ls = new ArrayList<>(map.keySet());
        Collections.sort(ls);
        List<List<String>> neighLs = new ArrayList<>();
        neighLs.add(new ArrayList<>());
        neighLs.get(0).add(ls.get(0));
        for (int i = 1; i < ls.size(); i++) {
            if (!isNext(ls.get(i), ls.get(i - 1))) {
                neighLs.add(new ArrayList<>());
            }
            neighLs.get(neighLs.size() - 1).add(ls.get(i));
        }
        int res = -1;
        for (List<String> tmp: neighLs) {
            int ret = getNum(tmp, map, standard);
            if (ret != -1) {
                if (res != -1) {
                    res = Math.min(res, ret);
                } else {
                    res = ret;
                }
            }
        }
        System.out.print(res);

    }

    public static int getNum(List<String> ls, Map<String, Set<String>> map, int standard) {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < ls.size(); i++) {
            Set<String> set = new HashSet<>();
            for (int j = i; j < ls.size(); j++) {
                set.addAll(map.get(ls.get(j)));
                if (set.size() >= standard) {
                    ret = Math.min(j - i + 1, ret);
                }
            }
        }
        if (ret == Integer.MAX_VALUE) {
            return -1;
        }
        return ret;
    }

    public static boolean isNext(String date2, String date1) {
        int day1 = (date1.charAt(8) - '0') * 10 + (date1.charAt(9) - '0');
        int day2 = (date2.charAt(8) - '0') * 10 + (date2.charAt(9) - '0');
        int month1 = (date1.charAt(5) - '0') * 10 + (date1.charAt(6) - '0');
        int month2 = (date2.charAt(5) - '0') * 10 + (date2.charAt(6) - '0');
        if (month1 == month2 && day2 - day1 == 1) {
            return true;
        } else if (month2 == 2 && month1 == 1 && day1 == 31 && day2 == 1) {
            return true;
        } else if (month2 == 3 && month1 == 2 && day1 == 28 && day2 == 1) {
            return true;
        } else if (month2 == 4 && month1 == 3 && day1 == 31 && day2 == 1) {
            return true;
        } else if (month2 == 5 && month1 == 4 && day1 == 30 && day2 == 1) {
            return true;
        } else if (month2 == 6 && month1 == 5 && day1 == 31 && day2 == 1) {
            return true;
        } else if (month2 == 7 && month1 == 6 && day1 == 30 && day2 == 1) {
            return true;
        } else if (month2 == 8 && month1 == 7 && day1 == 31 && day2 == 1) {
            return true;
        } else if (month2 == 9 && month1 == 8 && day1 == 31 && day2 == 1) {
            return true;
        } else if (month2 == 10 && month1 == 9 && day1 == 30 && day2 == 1) {
            return true;
        } else if (month2 == 11 && month1 == 10 && day1 == 31 && day2 == 1) {
            return true;
        } else if (month2 == 12 && month1 == 11 && day1 == 30 && day2 == 1) {
            return true;
        }
        return false;
    }


}
