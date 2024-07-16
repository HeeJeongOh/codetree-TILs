import java.util.*;
/*
- 정사각형의 총 넓이 구하기
[시도1] 메모리 초과
1. 점의 범위 -10000 <= x, y <= 10000
    1.1 좌표평면 이동하기
    1.2 최댓갑 더해서 이도ㅇ시키기 (x+10000, y+10000)
2. 보드 색칠해서 cnt하기 -> 시간초과 ? 
    ㄴ 누적합 이용하면 덜하지 않을까

[시도2]
1. 최대한 보드를 핏하게 만들기
    1.1 음수가 존재하면 가장 작은 수를 기준으로 좌표이동
    1.2 음수가 없으면 그대로 찍어두댐
2. 
*/

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[][] points = new int[n][4];

        int max_num = 0;
        int min_num = 0; 

        for(int i = 0; i < n; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            if(x1 > max_num){ max_num = x1; }
            if(y1 > max_num){ max_num = y1; }
            if(x2 > max_num){ max_num = x2; }
            if(y2 > max_num){ max_num = y2; }

            if(min_num > x1){ min_num = x1; }
            if(min_num > y1){ min_num = y1; }
            if(min_num > x2){ min_num = x2; }
            if(min_num > y2){ min_num = y2; }

            points[i] = new int[]{x1, y1, x2, y2};
        }
        // for(int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(points[i]));
        // }
        
        int offset = 0;
        if(min_num < 0){
            offset = -min_num;
        }
        // System.out.println(min_num + " " + max_num);

        int L = max_num + offset + 5;
        int[][] S = new int[L][L];

        for(int i = 0; i < n; i++){
            int x1 = points[i][0] + offset + 1;
            int y1 = points[i][1] + offset + 1;
            int x2 = points[i][2] + offset + 1;
            int y2 = points[i][3] + offset + 1;

            S[y1][x1] += 1;
            S[y1][x2] -= 1;
            S[y2][x1] -= 1;		
            S[y2][x2] += 1;
        }

        // for(int i = 0; i < L; i++){
        //     for(int j = 0; j < L; j++){
        //         System.out.print(S[i][j] + " ");
        //     }
        //     System.out.println();
        // }           
        // System.out.println();

        // 가로 복원
        for(int i = 0; i < L; i++){
            for(int j = 1; j < L; j++){
                S[i][j] += S[i][j-1];
            }
        }

        // 세로 복원
        for(int j = 0; j < L; j++){
            for(int i = 1; i < L; i++){
                S[i][j] += S[i-1][j];
            }
        }

        int answer = 0;
        for(int i = 0; i < L; i++){
            for(int j = 0; j < L; j++){
                if(S[i][j] != 0){
                    answer += 1;
                }
                // System.out.print(S[i][j] + " ");
            }
            // System.out.println();
        }
        System.out.println(answer);
    }
}