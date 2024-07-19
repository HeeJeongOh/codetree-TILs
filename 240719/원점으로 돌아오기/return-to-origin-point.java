import java.util.*;
/*
- 원점에서 시작하여 주어진 점을 겹치지 않게 한 번씩만 방문하고 원점으로 돌아오려한다.
- x축, y축 평행하게 이동 ; 상하좌우로 이동

1. 평행하게 이동하니까 dfs처럼 구현하기
2. x좌표나 y좌표가 겹치면 연결
    (0, 0) : (0, 1) (2, 0)
    (0, 1) : (2, 1)
    (2, 1) : (2)
3. 재귀로 구현해보기(gpt 도움)
    3.1 값의 비교를 위해 string으로 변환
    3.2 
*/
import java.util.*;

public class Main {
    private static Map<String, List<String>> graph;
    private static Set<String> visited;
    private static int pathCount;

    // 현재 위치, 시작 위치, 남은 방문할 점 개수를 인자로 받습니다.
    private static void dfs(int[] current, int remaining) {
        // System.out.println(visited + " " + remaining + " " + Arrays.toString(current));
        String currentKey = Arrays.toString(current);
        visited.add(currentKey);

        // 모든 점을 방문하고 다시 시작점으로 돌아온 경우
        if (remaining == 1 && (current[0] == 0 || current[1] == 0)) {
            pathCount += 1;
        } else {
            // 이웃한 점들을 재귀적으로 방문합니다.
            for (String neighborKey : graph.get(currentKey)) {
                if (!visited.contains(neighborKey)) {
                    // [2, 3]
                    String[] parts = neighborKey.replace("[", "").replace("]", "").split(", ");
                    int[] neighbor = new int[]{Integer.parseInt(parts[0]), Integer.parseInt(parts[1])};

                    dfs(neighbor, remaining - 1);
                }
            }
        }
        // 백트래킹: 현재 위치를 방문 처리에서 해제
        visited.remove(currentKey);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        graph = new HashMap<>();
        visited = new HashSet<>();
        pathCount = 0;


        // points 배열을 초기화, graph 초기화
        int[][] points = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new int[]{x, y};
            graph.put(Arrays.toString(points[i]), new ArrayList<>());
        }

        points[N] = new int[]{0, 0}; // 시작점(원점)
        graph.put(Arrays.toString(points[N]), new ArrayList<>());

        // 그래프 구축
        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < N + 1; j++) {
                // 본인인 경우 제외
                if (i != j) {
                    int[] point1 = points[i];
                    int[] point2 = points[j];
                    if (point1[0] == point2[0] || point1[1] == point2[1]) {
                        graph.get(Arrays.toString(point1)).add(Arrays.toString(point2));
                    }
                }
            }
        }

        // 재귀적 DFS
        dfs(points[N], N + 1);

        System.out.println(pathCount);
    }
}