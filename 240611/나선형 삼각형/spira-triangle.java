import java.util.*;
/*
수열 - dp
1. p(n) : 정삼각형의 한 변의 길이를 순서대로 모아놓은 수열
2. n에 따라 p(n)
3. n : 
*/

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dp = new int[n+1];
        
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
    
        for(int i = 4; i <= n; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
        System.out.println(dp[n]);
    }
}