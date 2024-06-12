import java.util.*;
/*
- 한 칸의 숫자를 변경 가능할 때
- 1로만 이루어진 집합 중 가장 많은 1의 칸으로 이루어진 집합의 크기 구하기

[시도1] 시간초과
1. 0인 점들을 1로 바꿔서 모든 경우 테스트하기? 시간초과

[시도2] 시간초과
1. 0을 기준으로 상하좌우에 1이 2개 이상 존재하는 경우 탐색하기

[시도3] 
1. 그룹화 먼저 수행
2. 각 그룹별 크기 저장
3. 시도2 기준으로 탐색하면서(*) 최대 경우 구하기
    {2: 5, 3: 3, 4: 1}
    0 * 2 2
    * 2 2 2
    3 * 0 *
    3 3 * 4
*/
public class Main {

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, 1, -1};

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

        // 1. 그룹화
        Map<Integer, Integer> group = new HashMap<>();
        int current = 2;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(table[i][j] != 1){ continue; }
                int y1 = i, x1 = j;

                Deque<int[]> deq = new ArrayDeque<>();
                int cnt = 0;
                
                deq.add(new int[]{y1, x1});
                table[y1][x1] = current;

                while(deq.size() > 0){
                    int[] yx = deq.pollLast();
                    cnt += 1;

                    for(int d = 0; d < 4; d++){
                        int y2 = yx[0] + dy[d];
                        int x2 = yx[1] + dx[d];

                        if(0 <= y2 && y2 < n && 0 <= x2 && x2 < m
                        && table[y2][x2] == 1){
                            deq.add(new int[]{y2, x2});
                            table[y2][x2] = current;
                        }
                    }
                }
                group.put(current, cnt);
                current += 1;                
            }
        }
        
        // System.out.println(group);
        // for(int a = 0; a < n; a++){
        //     for(int b = 0; b < m; b++){
        //         System.out.print(table[a][b] + " ");
        //     }
        //     System.out.println();
        // }            
        // System.out.println();


        // 2. 탐색
        int max_area = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){        
                if(table[i][j] == 0){
                    Set<Integer> group_cnt = new HashSet<>();

                    for(int d = 0; d < 4; d++){
                        int i2 = i + dy[d];
                        int j2 = j + dx[d];

                        if(0 <= i2 && i2 < n && 0 <= j2 && j2 < m
                            && table[i2][j2] > 1){
                                group_cnt.add(table[i2][j2]);
                            }
                    }
                    // System.out.println(i+ " " + j + " " + group_cnt);

                    if(group_cnt.size() > 1){
                        int tmp = 0;
                        for(int g : group_cnt){
                            tmp += group.get(g);
                        }
                        if(max_area < tmp){ max_area = tmp; }
                    }
                }
            }
        }
        System.out.println(max_area+1);
    }
}