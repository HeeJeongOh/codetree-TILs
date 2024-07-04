import java.util.*;
/*
- 2*n 격자 위 각 칸에 물건을 놓되 인접한 두 칸에 모두 물건이 올려져있으면 안된다.
- 아무것도 배치하는 것도 하나의 경우의 수

n = 3 => 17 = 1 + 6 + 8 + 2
k = 0
    0 0 0
    0 0 0
k = 1
    1 0 0   0 1 0   0 0 1   0 0 0   0 0 0   0 0 0 
    0 0 0   0 0 0   0 0 0   1 0 0   0 1 0   0 0 1
k = 2
    1 0 1   1 0 0   1 0 0   0 1 0   0 1 0   0 0 1   0 0 1   0 0 0
    0 0 0   0 1 0   0 0 1   1 0 0   0 0 1   1 0 0   0 1 0   1 0 1
k = 3
    1 0 1   0 1 0
    0 1 0   1 0 1

n = 4 - 1 + 8 + 30(10 + 20) + 2
k = 0 : 1
k = 1 : 8
k = 2 : 9
    1 0 0 0
    0 0 0 0
k = 3 : 
k = 4 : 2
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 2*n;

        int answer = dp[0] + dp[1];


        for(int k = 2; k < n; k++){
            int sum = 0;
            for(int i = 0; i < k; i++){
                sum += dp[i];
            }
            dp[k] = sum+1;
            answer += dp[k];
        }
        answer += 2;
        // System.out.println(Arrays.toString(dp));
        System.out.println(answer % 10007);

    }
}