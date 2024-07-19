import java.util.*;
/*
- 원점에서 시작하여 주어진 점을 겹치지 않게 한 번씩만 방문하고 원점으로 돌아오려한다.
- x축, y축 평행하게 이동 ; 상하좌우로 이동

1. 평행하게 이동하니까 dfs처럼 구현하기
2. x좌표나 y좌표가 겹치면 연결
    (0, 0) : (0, 1) (2, 0)
    (0, 1) : (2, 1)
    (2, 1) : (2)
3. 재귀로 구현해보기
*/
public class Main {
    // 클래스 전역변수
    private static Map<int[], List<int[]>> graph;
    private static Set<String> visited;
    private static int pathCount;

    // 현재 위치, 시작 위치, 방문한 점들, 남은 방문할 점 개수를 인자로 받습니다.
    private static void dfs(int[] current, int[] start, Set<String> path, int remaining) {
        // 현재 위치를 방문 처리합니다.
        String key = Arrays.toString(current);

        path.add(key);
        visited.add(key);

        // 모든 점을 방문하고 다시 시작점으로 돌아온 경우
        if (remaining == 1 && Arrays.equals(current, start)) {
            pathCount++;
        } else {
            // 이웃한 점들을 재귀적으로 방문합니다.
            for (int[] neighbor : graph.get(current)) {
                String neighborKey = Arrays.toString(neighbor);
                if (!visited.contains(neighborKey)) {
                    dfs(neighbor, start, path, remaining - 1);
                }
            }
        }
        // 백트래킹: 현재 위치를 방문 처리에서 해제합니다.
        path.remove(key);
        visited.remove(key);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] points = new int[N+1][2];

        graph = new HashMap<>();
        visited = new HashSet<>();
        pathCount = 0;

        for(int i = 0; i < N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new int[]{x, y};
            graph.put(points[i], new ArrayList<>());
        }

        points[N] = new int[]{0, 0};
        graph.put(points[N], new ArrayList<>());

        for(int[] key : graph.keySet()){

            for(int i = 0; i < N+1; i++){
                int[] xy = points[i];

                if((key[0] == xy[0] && key[1] != xy[1]) || (key[0] != xy[0] && key[1] == xy[1])){
                    // ArrayList<int[]> key_values = graph.get(key);
                    // key_values.add(xy);
                    // graph.put(key, key_values);   
                    graph.get(key).add(xy);

                }
            }
            System.out.print(Arrays.toString(key) + " : ");
            for(int[] v : graph.get(key)){
                System.out.print(Arrays.toString(v) + " ");
            }             
            System.out.println();
        }

        // dfs
        int[] cnt = new int[0];
        int[] visited = new int[N+1];
        dfs(points[N], points[N], new HashSet<>(), N + 1);

        System.println(cnt);
    }
}