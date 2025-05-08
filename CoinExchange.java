import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinExchange {

    public static Result minCoins(int[] denominations, int amount) {
        if (amount < 0) {
            return new Result(-1, new HashMap<>());
        }
        if (amount == 0) {
            return new Result(0, new HashMap<>());
        }

        int[] dp = new int[amount + 1];
        int[] lastCoin = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        Arrays.fill(lastCoin, -1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : denominations) {
                if (i - coin >= 0 && dp[i - coin] != amount + 1 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                    lastCoin[i] = coin;
                }
            }
        }

        if (dp[amount] > amount) {
            return new Result(-1, new HashMap<>());
        }

        Map<Integer, Integer> selectedDenominations = new HashMap<>();
        int currentAmount = amount;
        while (currentAmount > 0) {
            int coin = lastCoin[currentAmount];
            if (coin == -1) {
                break;
            }
            selectedDenominations.put(coin, selectedDenominations.getOrDefault(coin, 0) + 1);
            currentAmount -= coin;
        }

        return new Result(dp[amount], selectedDenominations);
    }

    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 2000};
        int amount = 1400;
        Result result = minCoins(denominations, amount);

        if (result.minCoins != -1) {
            System.out.println("Minimum number of denominations required for " + amount + ": " + result.minCoins);
            System.out.println("Selected denominations and their quantities: " + result.selectedDenominations);
        } else {
            System.out.println("The amount " + amount + " cannot be formed using the given denominations.");
        }
    }

    static class Result {
        int minCoins;
        Map<Integer, Integer> selectedDenominations;

        public Result(int minCoins, Map<Integer, Integer> selectedDenominations) {
            this.minCoins = minCoins;
            this.selectedDenominations = selectedDenominations;
        }
    }
}
