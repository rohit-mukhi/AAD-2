import java.util.Arrays;

public class Merge_Sort {

    public static void MERGE(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;
        int[] L = new int[n1 + 1], R = new int[n2 + 1];

        for (int i = 0; i < n1; i++) {
            L[i] = A[p + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = A[q + i + 1];
        }

        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }

    public static void MERGE_SORT(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;
            MERGE_SORT(A, p, q);
            MERGE_SORT(A, q + 1, r);
            MERGE(A, p, q, r);
        }
    }

    public static void main(String args[]) {
        int[] a = {5, 2, 4, 6, 1, 3};
        int p = 0;
        int r = a.length - 1;
        MERGE_SORT(a, p, r);
        System.out.println(Arrays.toString(a));
    }
}
