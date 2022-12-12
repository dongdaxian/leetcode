package nowcoder.renshou;

import java.util.*;

public class Test3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        List<int[]> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            employees.add(new int[] {sc.nextInt(), sc.nextInt()});
        }
        employees.sort((o1, o2) -> {if (o1[0] != o2[0]) return o1[0] - o2[0]; else return o2[1] - o1[1];});
        int day = 0;
        int reach = 0;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (employees.get(i)[0] <= day + 1) {
                reach = Math.max(reach, employees.get(i)[1]);
            } else if (reach == day || reach >= t) {
                break;
            } else {
                i--;
                ret++;
                day = reach;
            }
        }
        if (reach >= t) {
            System.out.print(ret + 1);
        } else {
            System.out.print(-1);
        }

    }


}
