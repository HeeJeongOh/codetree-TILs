import java.util.*;
/*
- n개의 칸, ai부터 bi까지 각각 블럭을 1번 쌓기
- 블럭의 개수 오름차순 정렬

*/

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
        Arrays.sort(blocks);
        // System.out.println(Arrays.toString(blocks));
    
        System.out.println(blocks[n/2]);

    }
}