import java.util.*;
/*
- n개의 칸, ai부터 bi까지 각각 블럭을 1번 쌓기
- 블럭의 개수 오름차순 정렬

[시도1] 이중포문
[시도2] 검색 - 카운트 정렬
1. 값의 개수를 세어 다시 넣기
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] blocks = new int[n+1];
        for(int i = 0; i < k; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(int j = a; j <= b; j++){
                blocks[j] += 1;
            }    
        }
        // Arrays.sort(blocks);
        // System.out.println(Arrays.toString(blocks));

        // Count Sorting
        int[] cnt = new int[n+1];
        for(int i = 1; i <= n; i++){
            cnt[blocks[i]] += 1;
        }
        // System.out.println(Arrays.toString(cnt));
        
        int idx = 0;
        int[] answer = new int[n+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j < cnt[i]; j++){
                answer[idx] = i;
                idx += 1;
            }
        }
        // System.out.println(Arrays.toString(answer));
        System.out.println(answer[n/2]);
    }
}