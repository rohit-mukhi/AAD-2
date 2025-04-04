import java.util.Arrays;

public class Quick_Sort {
    public static void Swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static int PARTITION(int[] A, int p, int r) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i++;
                Swap(A, i, j);
            }
        }
        Swap(A, i + 1, r);
        return i + 1;
    }

    public static void QUICK_SORT(int[] A, int p, int r) {
        if (p < r) {
            int q = PARTITION(A, p, r);
            QUICK_SORT(A, p, q - 1);
            QUICK_SORT(A, q + 1, r);
        }
    }

    public static void main(String args[]) {
        int[] a = {5, 2, 4, 6, 1, 3};
        int p = 0;
        int r = a.length - 1;
        QUICK_SORT(a, p, r);
        System.out.println(Arrays.toString(a));
    }
}
