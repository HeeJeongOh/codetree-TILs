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
2. 시뮬레이션
    ( ( ) )
    ( ) ( ( 
    ( ( ) ( 
    ) ) ) )

    1 1 0 0
    1 0 1 1
    1 1 0 1
    0 0 0 0
[시도2]
1. 좌측 상단에 시작해야함 (0, 0) 
*/
public class Main {

    private static int N;
    private static int[][] grid;    
    
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};

    private static boolean[][] visited = new boolean[N][N];
    private static LinkedList<String> open_route = new LinkedList<>();
    private static LinkedList<String> max_open_route = new LinkedList<>();


    private static boolean boarderCheck( int y, int x){
          return (0 <= y && y < N && 0 <= x && x < N);
    }

    private static String location_to_string(int y, int x){
        return String.valueOf(y) + "," + String.valueOf(x);
    }
    private static int[] string_to_location(String yx){
        String[] tmp = yx.split(",");
        return new int[]{Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])};
    }

    private static void find_max_open_route(int r1, int c1){
        if(visited[r1][c1]){
            return;
        }
        
        visited[r1][c1] = true;
        open_route.add(location_to_string(r1, c1));

        if (open_route.size() > max_open_route.size()) {
            max_open_route = new LinkedList<>(open_route);
        }

        for (int i = 0; i < 4; i++) {
            int r2 = r1 + dy[i];
            int c2 = c1 + dx[i];

            if (boarderCheck(r2, c2) && grid[r2][c2] == 1 && !visited[r2][c2]) {
                find_max_open_route(r2, c2);
            }
        }

        open_route.pollLast();
        visited[r1][c1] = false;
    }

    private static boolean find_close_route(int length, int r, int c){
        int cnt = 0;

        Deque<int[]> stack = new ArrayDeque<>();
        stack.add(new int[]{r, c});

        while(stack.size() > 0){
            int[] rc = stack.pollLast();
            int r1 = rc[0];
            int c1 = rc[1];
            cnt += 1;

            if((r1 != 0 && c1 != 0) && length == cnt){
                return true;
            }

            visited[r1][c1] = true;

            for (int i = 0; i < 4; i++) {
                int r2 = r1 + dy[i];
                int c2 = c1 + dx[i];

                if (boarderCheck(r2, c2) && grid[r2][c2] == 2 && !visited[r2][c2]) {
                    stack.add(new int[]{r2, c2});
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N][N];
        grid = new int[N][N];
        
        for(int i = 0; i < N; i++){
            String[] row = sc.next().split("");
            for(int j = 0; j < N; j++){
                if(row[j].equals("(")){
                    grid[i][j] = 1;
                }
                else{
                    grid[i][j] = 2;
                }
            }
        }
        // for(int i = 0; i < N; i++){
        //     System.out.println(Arrays.toString(grid[i]));
        // }

        int answer = 0;
        if(grid[0][0] == 1){  
            find_max_open_route(0, 0);
            // System.out.println(max_open_route);

            Collections.reverse(max_open_route);
            int len = max_open_route.size();
            // System.out.println(len);

            for(String rc : max_open_route){
                int[] rowcol = string_to_location(rc);
                // System.out.println(Arrays.toString(rowcol));

                boolean isClosed = find_close_route(len, rowcol[0], rowcol[1]);
                // System.out.println(isClosed);
                if(isClosed){
                    answer = len * 2;
                    break;
                }
                len -= 1;
            }
            
        }
        System.out.println(answer);
    }
}