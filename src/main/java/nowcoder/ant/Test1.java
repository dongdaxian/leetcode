package nowcoder.ant;


import java.util.Scanner;

// 蚂蚁2022.09.15
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int level = 0;
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            if (num % 2 == 1) {
                sb.append(getCharFromLevel(level));
            }
            num = num / 2;
            level++;
        }
        System.out.print(sb.toString());
    }

    public static char getCharFromLevel(int level) {
        return (char)('a' + level);
    }

}
