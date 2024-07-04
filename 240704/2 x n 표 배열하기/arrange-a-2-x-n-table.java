import java.util.*;
/*
- 2*n 격자 위 각 칸에 물건을 놓되 인접한 두 칸에 모두 물건이 올려져있으면 안된다.
- 아무것도 배치하는 것도 하나의 경우의 수

n = 1 : 3 = 1 + 2
n = 2 : 7 = 1 + 4 + 2
n = 3 : 17 = 1 + 6 + 8 + 2
    k = 2 : 8 = 6 + 2
    1 0 0   1 0 0   0 1 0  0 1 0   0 0 1   0 0 1   1 0 1   0 0 0
    0 1 0   0 0 1   1 0 0  0 0 1   0 1 0   1 0 0   0 0 0   1 0 1
n = 4 : 41 = 1 + 8 + (00) + (00) + 2
n = 5 : 99 = 1 + 10 + (00) + (00) + (00) + 2;
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 2*n;
        for(int k = 2; k < n; k++){
            dp[k] = (dp[k-1] - k) * 2;
        }
        dp[n] = 2;
        // System.out.println(Arrays.toString(dp));

        int answer = 0;
        for(int i = 0; i <= n; i++){
            answer += dp[i];
        }
        System.out.println(answer);
    }
}