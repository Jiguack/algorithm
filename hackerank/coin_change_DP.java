import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long makeChange(int[] coins, int money) {
        int subSum;
        if (money == 0)
            return 1;
        else
            if (money < 0)
                return 0;
            else {
                subSum = 0;
                for (int i=0; i < coins.length; i++) {
                     subSum += makeChange(coins, money - coins[i]);
                }
                return subSum;
            }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
