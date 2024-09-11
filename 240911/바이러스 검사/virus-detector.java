import java.util.*;
/*
- N개의 식당에 있는 고객들 체온 재기
- 가게 당 팀장1 팀원 00
- 팀장 : a 명 검사 가능 / 팀원 : b 명 검사 가능

1. 팀장은 가게 수만큼 필요
2. 팀장이 커버할 수 있는 인원 제외하고 필요한 팀원 계산하기

3. (힌트) 자료형 long으로 설정하기
*/
public class Main {
    public static void main(String[] args) {
        long answer = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rests = new int[n];
        for(int i = 0; i < n; i++){
            int p = sc.nextInt();
            rests[i] = p;
        }

        int a = sc.nextInt();
        int b = sc.nextInt();;

        // 팀장 1명 씩
        answer += n;

        // 팀원 ?명
        for(int i = 0; i < n; i++){
            int current_p = rests[i] - a;

            if(current_p <= 0){
                break;
            }

            if(current_p % b == 0){
                answer += (current_p / b);
            }
            else{
                answer += (current_p / b) + 1;
            }
        }
        System.out.println(answer);
    }
}