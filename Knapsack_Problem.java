// This code may not be correct
// This will be re-examined

import java.util.Arrays;

public class Fractional_Knapsack {
    private class Items implements Comparable<Items>{
        int p, w;
        double d;

        public Items(int p, int w) {
            this.p = p;
            this.w = w;
            this.d = (double) p / w;
        }

        @Override
        public int compareTo(Items other) {
            return Double.compare(other.d, this.d);
        }

        public double maximizeProfit(int[] p, int[] w, int W) {
            double maxProfit = 0;
            int n = w.length;
            Items[] itemList = new Items[n];
            for (int i = 0; i < n; i++) {
                itemList[i] = new Items(p[i], w[i]);
            }
            Arrays.sort(itemList);
            for (int i = 0; i < n; i++) {
                if (W - itemList[i].w >= 0) {
                    W = W - itemList[i].w;
                    maxProfit += itemList[i].p;
                } else {
                    maxProfit += (itemList[i].d * W);
                    break;
                }
            }
            return maxProfit;
        }
    }

    public double maximizeProfit(int[] p, int[] w, int W) {
        return new Items(0, 0).maximizeProfit(p, w, W);
    }
    public static void main(String[] args) {
        int[] p = {60, 40, 90, 120};
        int[] w = {10, 40, 20, 30};
        int W = 50;
        Fractional_Knapsack obj = new Fractional_Knapsack();
        System.out.println("Maximum Profit: " + obj.maximizeProfit(p, w, W));
    }
}
