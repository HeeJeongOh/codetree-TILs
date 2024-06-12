import java.util.*;
/*
- 한 칸의 숫자를 변경 가능할 때
- 1로만 이루어진 집합 중 가장 많은 1의 칸으로 이루어진 집합의 크기 구하기

1. 0인 점들을 1로 바꿔서 모든 경우 테스트하기? 시간초과 예상

[시도1]
1. 일단 집합 구분하기 (bfs)
    1.1 각 집합의 크기 저장하기
2. 각 집합에 대해 확장 가능한 후보 찾기

*/
public class Main {

    static int getArea(int n, int m, int y1, int x1, int[][] table){

        Deque<int[]> deq = new ArrayDeque<>();
        int[][] visited = new int[n][m];


        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        int cnt = 0;

        deq.add(new int[]{y1, x1});
        visited[y1][x1] = 1;

        while(deq.size() > 0){
            int[] yx = deq.poll();
            cnt += 1;

            for(int d = 0; d < 4; d++){
                int y2 = yx[0] + dy[d];
                int x2 = yx[1] + dx[d];

                if(0 <= y2 && y2 < n && 0 <= x2 && x2 < m
                && table[y2][x2] == 1 && visited[y2][x2] == 0){
                    visited[y2][x2] = 1;
                    deq.add(new int[]{y2, x2});
                }
            }
        }

        // for(int a = 0; a < n; a++){
        //     for(int b = 0; b < m; b++){
        //         System.out.print(table[a][b] + " ");
        //     }
        //     System.out.println();
        // }            
        // System.out.println();

        return cnt;
    }

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] table = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                table[i][j] = sc.nextInt();
            }
        }

        int max_area = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){        
                if(table[i][j] == 0){
                    table[i][j] = 1;
                    int tmp = getArea(n, m, i, j, table);
                    if(max_area < tmp){ max_area = tmp; }
                    table[i][j] = 0;
                }
            }
        }
        System.out.println(max_area);
    }
}