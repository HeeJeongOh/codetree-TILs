import java.util.*;
/*
- 2*n 격자 위 각 칸에 물건을 놓되 인접한 두 칸에 모두 물건이 올려져있으면 안된다.
- 아무것도 배치하는 것도 하나의 경우의 수

[시도1]
- 무지성 점화식 시도

[해설]
- 경우의 수 나누기
    dp[i][0]: i 번째 열에 아무것도 배치하지 않은 경우의 수
    dp[i][1]: i 번째 열의 첫 번째 행에만 물건을 배치한 경우의 수
    dp[i][2]: i 번째 열의 두 번째 행에만 물건을 배치한 경우의 수

- 점화식 만들기
    dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]
    dp[i][1] = dp[i-1][0] + dp[i-1][2]
    dp[i][2] = dp[i-1][0] + dp[i-1][1]

*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[][] dp = new long[n+1][3];

        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for(int i = 1; i <= n; i++){    
            // System.out.println(Arrays.toString(dp[i-1]));
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 10007;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 10007;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 10007;
        }

        // System.out.println(Arrays.toString(dp[n]));

        long answer = dp[n][0];
        System.out.println(answer);
    }
}