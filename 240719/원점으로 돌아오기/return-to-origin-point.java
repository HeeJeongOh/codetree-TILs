import java.util.*;
/*
- 원점에서 시작하여 주어진 점을 겹치지 않게 한 번씩만 방문하고 원점으로 돌아오려한다.
- x축, y축 평행하게 이동 ; 상하좌우로 이동

[시도 X] 메모리 초과;
1. 평행하게 이동하니까 dfs처럼 구현하기
2. x좌표나 y좌표가 겹치면 연결
    (0, 0) : (0, 1) (2, 0)
    (0, 1) : (2, 1)
    (2, 1) : (2)
-- gpt개입
3. 재귀로 구현해보기
    3.1 값의 비교를 위해 string으로 변환
4. 토론 : 모든 점이 일직선 상 -> 해당 점을 방문한다면 반드시 방향을 바꾸어야한다(?)
    4.1 이전 방향과 다른 방향으로만 이동

[시도 X+1]
1. 그래프 제거 - for문 + if(x 또는 y가 같을 때)
*/
import java.util.*;

public class Main {
    private static int N;
    private static int[][] points;
    private static Set<int[]> visited;
    private static int pathCount;

    // 현재 점에서 이웃 점으로 이동할 때의 방향을 계산합니다.
    // 이동방향 : 1(상), 2(하), 3(좌), 4(우)
    private static int getDirection(int[] from, int[] to) {
        if(from[0] == to[0] && from[1] < to[1]) { return 1; }
        if(from[0] == to[0] && from[1] > to[1]) { return 2; }
        if(from[0] > to[0] && from[1] == to[1]) { return 3; }
        if(from[0] < to[0] && from[1] == to[1]) { return 4; }

        return -1;
    }

    // 현재 위치, 시작 위치, 남은 방문할 점, 지난 이동방향
    private static void dfs(int[] current, int[] start, int remaining, int lastDirection) {
        // System.out.println(Arrays.toString(current) + " " + remaining);
        if (remaining == 1 && (current[0] == 0 || current[1] == 0)) {
            int direction = getDirection(current, start);
            if(direction != lastDirection){
                pathCount += 1;
                return;
            }
        }

        // 평행하게 위치한 점들을 재귀적으로 방문합니다.
        for (int i = 0; i < N+1; i++) {
            int[] neighbor = points[i];
            if(Arrays.equals(current, neighbor)){ continue; }
            if((current[0] == neighbor[0] || current[1] ==  neighbor[1])){
                if(visited.contains(neighbor)) { continue; }              
                // 방향 전환 조건 확인
                int direction = getDirection(current, neighbor);
                if (direction != lastDirection) {
                    visited.add(neighbor);
                    dfs(neighbor, start, remaining - 1, direction);
                    visited.remove(neighbor); // 백트래킹: 방문 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        // points 배열을 초기화, graph 초기화
        points = new int[N + 1][2];
        visited = new HashSet<>();
        pathCount = 0;

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new int[]{x, y};
        }

        points[N] = new int[]{0, 0}; // 시작점(원점)

        // 재귀적 DFS
        visited.add(points[N]);
        dfs(points[N], points[N], N + 1, -1);
        System.out.println(pathCount);
    }
}