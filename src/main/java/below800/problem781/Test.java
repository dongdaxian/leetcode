package below800.problem781;

import java.util.Arrays;

public class Test {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        int res = 0;
        Arrays.sort(answers);
        for (int i = 0; i < n;) {
            int tmp = answers[i];
            int count = 1;
            for (; i + count < n && answers[i + count] == answers[i]; count++);
            int times = count % (answers[i] + 1);
//            res += count / (answers[i] + 1) * (answers[i] + 1);
//            if(times != 0)
//                res += (answers[i] + 1);
            res += (count + answers[i]) / (answers[i] + 1) * (answers[i] + 1);
            i += count;
        }
        return res;
    }
}
