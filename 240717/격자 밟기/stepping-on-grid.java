import java.util.*;
/*
- 5x5 격자
- a(1, 1), b(5, 5)
- 4방향 중 격자를 벗어나지 않는 곳으로 이동
- a, b가 방문했던 곳은 가지 않고, 갈 수 없는데도 가지 않음

- 최종적으로 같은 칸에 도달했을 때, 모든 이동 가능한 칸을 전부 방문하게 되는 서로 다른 가지수(?)
- 단, A, B가 이동 도중에 같은 칸을 밟게 되는 경우는 올바른 경우로 생각하지 않음


1. a, b 동시에 한 칸 씩 움직이기 
2. 이동가능한 칸을 전부 방문해야 함 
    2.1 재귀를 활용한 BFS
    2.2 완전탐색
*/
import java.util.*;

public class Main {
    static int answer = 0;

    static void move(int[][] map, int[] aloc, int[] bloc, int left_space) {
        if (aloc[0] == bloc[0] && aloc[1] == bloc[1] && left_space == 0) {
            answer += 1;
            return;
        }

        Deque<int[]> astack = new ArrayDeque<>();
        Deque<int[]> bstack = new ArrayDeque<>();

        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        // Try all possible moves for A
        for (int i = 0; i < 4; i++) {
            int ar = aloc[0] + dy[i];
            int ac = aloc[1] + dx[i];
            if (0 <= ar && ar < 5 && 0 <= ac && ac < 5 && map[ar][ac] == 0) {
                astack.add(new int[]{ar, ac});
            }
        }
        for (int j = 0; j < 4; j++) {
            int br = bloc[0] + dy[j];
            int bc = bloc[1] + dx[j];
            if (0 <= br && br < 5 && 0 <= bc && bc < 5 && map[br][bc] == 0) {
                bstack.add(new int[]{br, bc});
            }
        }

        for(int[] arc : astack){
            for(int[] brc : bstack){
                int ar = arc[0];
                int ac = arc[1];

                int br = brc[0];
                int bc = brc[1];

                if(ar == br && ac == bc){
                    if(left_space == 1){
                        map[ar][ac] = 1;
                        move(map, new int[]{ar, ac}, new int[]{br, bc}, left_space - 1);
                        map[ar][ac] = 0;
                    }
                }
                else{
                    map[ar][ac] = 1;
                    map[br][bc] = 1;
                    move(map, new int[]{ar, ac}, new int[]{br, bc}, left_space - 2);
                    map[br][bc] = 0;
                    map[ar][ac] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();
        int[][] map = new int[5][5];

        for (int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r - 1][c - 1] = -1;
        }

        map[0][0] = 1;
        map[4][4] = 1;
        move(map, new int[]{0, 0}, new int[]{4, 4}, 25 - k - 2);
        System.out.println(answer);
    }
}