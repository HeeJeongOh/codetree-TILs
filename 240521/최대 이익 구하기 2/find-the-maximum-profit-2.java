import java.util.*;
/*
n일 동안 하루에 하나씩 일 지급
- 하루에 하나씩, 모든 일은 n일안에
- i일에 지급 받은 일은 i일에만 수행 가능

[시도1]
1. 먼저 들어온 일을 우선으로 처리하니 최대가 안나옴
[시도2] 
ㄴ 문법 오류를 검색했더니 답안 발견
1. (i + t[i] > n) 조건으로 일하지 못하는 날 제외
2. 역순으로 탐색하는 이유; 최댓값을 얻기 위해
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] t = new int[n];
        int[] p = new int[n];
        
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        
        int[] dp = new int[n + 1];
        // 최대 이익을 위해 역순으로 탐색
        for (int i = n - 1; i >= 0; i--) {
            if (i + t[i] > n) {
                dp[i] = dp[i + 1];
            } else {
                // 일 안 받기 vs 일 받기
                // dp[i+t[i]] : 일을 수행한 후 미래가 결정되어 있음
                dp[i] = Math.max(dp[i + 1], p[i] + dp[i + t[i]]);
            }
            // System.out.println(Arrays.toString(dp));
        }
        
        System.out.println(dp[0]);
    }
}