// This code may not be correct.

import java.util.Arrays;

public class Interval_Scheduling {
    public static int[] earliestFinishTime(int n, int s[], int f[]) {
        int k = 0;
        int S[] = {};
        for(int j=0; j<n; j++) {
            if(f[k] <= s[j]) {
                s[j] = j;
                k = j;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int s[] = {1, 3, 0, 5, 6, 8, 2, 12};
        int f[] = {0, 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16};
        int n = s.length;
        int S[] = earliestFinishTime(n, s, f);
        System.out.println(Arrays.toString(S));
    }
}
