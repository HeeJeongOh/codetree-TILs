import java.util.*;
/*
- 5x5 격자
- a(1, 1), b(5, 5)
- 4방향 중 격자를 벗어나지 않는 곳으로 이동
- a, b가 방문했던 곳은 가지 않고, 갈 수 없는데도 가지 않음

- 최종적으로 같은 칸에 도달했을 때, 모든 이동 가능한 칸을 전부 방문하게 되는 서로 다른 가지수(?)
- 단, A, B가 이동 도중에 같은 칸을 밟게 되는 경우는 올바른 경우로 생각하지 않음


1. a, b 동시에 한 칸 씩 움직이기 
2. 이동가능한 칸을 전부 방문해야 함 - 어떻게 보장하지
3. 

*/
public class Main {
    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        int[][] map = new int[5][5];
        for(int i = 0; i < k; i++){
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r-1][c-1] = -1;
        }

        for(int i = 0; i < 5; i++){
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();


        int[] dy = {1, -1, 0, 0};
        int[] dx = {0, 0, 1, -1};

        Deque<int[]> astack = new ArrayDeque<>();
        Deque<int[]> bstack = new ArrayDeque<>();

        astack.add(new int[]{0, 0});
        bstack.add(new int[]{4, 4});
        
        map[0][0] = 1;
        map[4][4] = -1;

        while(astack.size() > 0 && bstack.size() > 0){
            int[] arc = astack.pollLast();
            int ar1 = arc[0];
            int ac1 = arc[1];

            int[] brc = bstack.pollLast();
            int br1 = brc[0];
            int bc1 = brc[1];


            if(ar1 == br1 && ac1 == bc1){
                answer = map[ar1][ac1] * map[br1][bc1];
                break;
            }

            for(int i = 0; i < 4; i++){
                int ar2 = ar1 + dy[i];
                int ac2 = ac1 + dx[i];

                if(0 <= ar2 && ar2 < 5 && 0 <= ac2 && ac2 < 5 && map[ar2][ac2] == 0){
                    map[ar2][ac2] = map[ar1][ac1] + 1;
                    astack.add(new int[]{ar2, ac2});
                }

                int br2 = br1 + dy[i];
                int bc2 = bc1 + dx[i];

                if(0 <= br2 && br2 < 5 && 0 <= bc2 && bc2 < 5 && map[br2][bc2] == 0){
                    map[br2][bc2] = map[br1][bc1] - 1;
                    bstack.add(new int[]{br2, bc2});
                }
            }

            for(int i = 0; i < 5; i++){
                System.out.println(Arrays.toString(map[i]));
            }
            System.out.println();

        }
        System.out.println(answer);
    }
}