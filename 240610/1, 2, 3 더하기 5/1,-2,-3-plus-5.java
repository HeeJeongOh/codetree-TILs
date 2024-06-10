import java.util.*;
/*
- 경우의 수를 사전순으로 정렬
- 순서가 달라도 다른 경우의 수

유형 - 백트래킹
1.  1 1 1 1 1 (o)
    
    1 1 1 2 0 (o)

    1 1 1 0 0
          1 0 (o)
    
    1 2 0 0 0
    1 2 1 0 0
*/
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        String answer = "";
        ArrayList<String> expressions = findAllExpressions(n);
        Collections.sort(expressions);
        
        for (String expression : expressions) {
            k -= 1;
            if(k == 0){
                answer = expression;
                break;
            }
        }

        int i;
        for(i = 0; i < answer.length()-1; i++){
            System.out.print(answer.charAt(i)+ "+");
        }
        System.out.print(answer.charAt(i));
    }
    
    public static ArrayList<String> findAllExpressions(int n) {
        ArrayList<String>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add("");
        
        for (int i = 1; i <= n; i++) {
            dp[i] = new ArrayList<>();
            if (i >= 1) {
                for (String expr : dp[i - 1]) {
                    dp[i].add(expr + "1");
                }
            }

            if (i >= 2) {
                for (String expr : dp[i - 2]) {
                    dp[i].add(expr + "2");
                }
            }

            if (i >= 3) {
                for (String expr : dp[i - 3]) {
                    dp[i].add(expr + "3");
                }
            }
            // System.out.println(i + " " + dp[i]);
        }
        return dp[n];
    }
}