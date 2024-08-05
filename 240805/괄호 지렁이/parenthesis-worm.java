import java.util.*;
/*
- 상하좌우 인접하게 이동
- 방문 순서대로 나열했을 때 올바른 문자열이어야함
- ((((())))) 처럼 ( 이 모두 나오면 ) 가 나오고 갯수가 동일해야함.

1. DFS 재귀 구현 : stack
2. ( 가 연속되는 최대길이 먼저 찾기
3. 최대 경로 역 순으로 조건에 만족하는 경우 찾기
    3.1 )가 최대길이만큼 찾아지면 됨
    3.2 안 찾아지면 )하나 빼고 찾기

[시도2]
1. 좌측 상단에 시작해야함 (0, 0) 
(반례1) find_closed_route에서 종료 조건 위치 수정
4
((((
()()
((((
()()

(반례2) : 방향에 따라 꼬리가 달라서.. 직접 우선순위를 좌하우상으로 두는게 의미가 있으려나
4
((((
((((
))))
))))

[시도3]
1. (를 쌓은 최장경로를 고정해두면 문제 발생
2. 케이스 나누기
    2.1 ( 면 ( 찾고
    2.2 ) 면 갯수가 만족할 때까지

*/
public class Main {

    private static int N;
    private static boolean[][] grid;    
    
    private static int[] dy = {0, 1, 0, -1};
    private static int[] dx = {1, 0, -1, 0};

    private static int max_length = 0;
    private static boolean[][] visited = new boolean[N][N];

    private static boolean boarderCheck( int y, int x){
          return (0 <= y && y < N && 0 <= x && x < N);
    }

    private static void find_route(boolean status, int r1, int c1, int length, int opens){
        if(length == 0){
            if(max_length < opens){
                max_length = opens;
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int r2 = r1 + dy[i];
            int c2 = c1 + dx[i];
            
            if (boarderCheck(r2, c2) && !visited[r2][c2]) {

                if(grid[r2][c2] == true && status == true){
                    visited[r2][c2] = true;
                    find_route(true, r2, c2, length+1, length+1);
                    visited[r2][c2] = false;

                }
                else if(grid[r2][c2] == false){
                    // System.out.println(r2 + " " + c2);
                    visited[r2][c2] = true;
                    find_route(false, r2, c2, length - 1, opens);
                    visited[r2][c2] = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N][N];
        grid = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            String[] row = sc.next().split("");
            for(int j = 0; j < N; j++){
                if(row[j].equals("(")){
                    grid[i][j] = true;
                }
                else{
                    grid[i][j] = false;
                }
            }
        }
        // for(int i = 0; i < N; i++){
        //     System.out.println(Arrays.toString(grid[i]));
        // }

        if(grid[0][0] == true){
            visited[0][0] = true;
            // find_route(boolean status, int r1, int c1, int length, int opens)
            find_route(true, 0, 0, 1, 1);            
        }
        System.out.println(max_length * 2);
    }
}