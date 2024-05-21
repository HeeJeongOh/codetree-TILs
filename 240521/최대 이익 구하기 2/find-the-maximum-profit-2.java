import java.util.*;
/*
n일 동안 하루에 하나씩 일 지급
- 하루에 하나씩, 모든 일은 n일안에
- i일에 지급 받은 일은 i일에만 수행 가능
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int answer = 0;

        int n = sc.nextInt();
        int isWorking = 0;

        for(int i = 0; i < n; i++){
            int t = sc.nextInt();
            int p = sc.nextInt();
            // System.out.println(isWorking + " " + i + " " + t);
            if(isWorking == 0 && i+t <= n){
                answer += p;
                isWorking = t+1;
            }
            isWorking--;
        }

        System.out.println(answer);
        // 여기에 코드를 작성해주세요.
    }
}