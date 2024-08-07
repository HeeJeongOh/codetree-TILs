import java.util.*;
/*
빙산들이 물에 잠기지 않은 채로 붙어있는 경우를 한 덩어리로
해수면 적절히 설정하여 가능한 빙산 덩어리의 최대 갯수

1. 0부터 최대 높이까지 line 갱신
2. 이미 line에 관계없는 애들은 -1
3. 같은 덩어리인지 파악하기 위해 flag 도입
    3.1 덩어리가 끊길 때 flag = false;
    3.2 flag == false && height[j] > line == 새로운 덩어리 시작

4. 시간초과 -> 최댓점을 찍고 감소한다면 break;
5. 해수면 그림상 네모 윗선이라고 생각
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] heights = new int[N];
        int max_height = 0;
        for(int i = 0; i < N; i++){
            heights[i] = sc.nextInt();

            if(max_height < heights[i]){
                max_height = heights[i];
            }
        }
        // System.out.println(max_height + " " + Arrays.toString(heights));

        int max_cnt = 0;
        for(int line = 1; line < max_height; line++){

            int cnt = 0;
            boolean flag = false;
            // System.out.println(line + " " + Arrays.toString(heights));

            for(int j = 0; j < N; j++){
                // System.out.println(flag + " " + heights[j] + " " + cnt);
                if(heights[j] <= line){
                    flag = false;
                    heights[j] = 0;

                }
                else if(flag == false && line < heights[j]){
                    // System.out.println("덩어리 시작 " + j);
                    
                    flag = true;                    
                    cnt += 1;
                }
            }

            if(cnt <= max_cnt){
                break;
            }

            if(max_cnt < cnt){
                max_cnt = cnt;
            }
        }
        System.out.println(max_cnt);
    }
}
/*
1 1     1 1
1 1 1 1 1 1
*/