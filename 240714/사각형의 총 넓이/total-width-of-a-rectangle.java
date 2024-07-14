import java.util.*;
/*
- 정사각형의 총 넓이 구하기
[시도1] 
1. 점의 범위 -10000 <= x, y <= 10000
    1.1 좌표평면 이동하기 (x+10000, y+10000)
2. 보드 색칠해서 cnt하기 -> 시간초과 ? 
    ㄴ 누적합 이용하면 덜하지 않을까
*/

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();

        int[][] points = new int[n][4];
        int max_size = 0;
        for(int i = 0; i < n; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();


            if(Math.abs(x1) > max_size){ max_size = Math.abs(x1); }
            if(Math.abs(y1) > max_size){ max_size = Math.abs(y1); }
            if(Math.abs(x2) > max_size){ max_size = Math.abs(x2); }
            if(Math.abs(y2) > max_size){ max_size = Math.abs(y2); }

            points[i] = new int[]{x1, y1, x2, y2};
        }
        // System.out.println(max_size);
        // for(int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(points[i]));
        // }

        int L = (max_size * 2 + 2);
        int[][] S = new int[L][L];

        for(int i = 0; i < n; i++){
            int x1 = points[i][0] + 1 + max_size;
            int y1 = points[i][1] + 1 + max_size;
            int x2 = points[i][2] + 1 + max_size;
            int y2 = points[i][3] + 1 + max_size;

            S[y1][x1] += 1;
            S[y1][x2] -= 1;
            S[y2][x1] -= 1;		
            S[y2][x2] += 1;
        }

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