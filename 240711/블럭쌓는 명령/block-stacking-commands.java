import java.util.*;
/*
- n개의 칸, ai부터 bi까지 각각 블럭을 1번 쌓기
- 블럭의 개수 오름차순 정렬

[시도1] 시간초과 - 이중포문 + 내장 정렬
[시도2] 시간초과 - 카운트 정렬
[시도3] 통과 - 누적합 + 카운트정렬
[시도4] 통과 - 누적합 + 내장 정렬
*/
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] blocks = new int[n+2];
        for(int i = 0; i < k; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            blocks[a]++;
            blocks[b+1]--;
        }
        // System.out.println(Arrays.toString(blocks));
        for(int i = 1; i < n+2; i++){
            blocks[i] += blocks[i-1];
        }
        // System.out.println(Arrays.toString(blocks));
        int[] cnt = Arrays.copyOfRange(blocks, 1, n+2);
        // System.out.println(Arrays.toString(cnt));
        Arrays.sort(cnt);
        System.out.println(cnt[(n+1)/2]);

    }
}