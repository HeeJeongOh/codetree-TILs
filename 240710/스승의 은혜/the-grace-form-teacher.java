import java.util.*;
/*
- n명의 학생에게 b만큼의 예산으로 선물하기
- 학생마다 원하는 선물가격과 배송비 존재
- 단 하나의 선물은 50% 가격 가능
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int b = sc.nextInt();

        int[][] students = new int[n][2];
        for(int i = 0; i < n; i++){
            int p = sc.nextInt();
            int s = sc.nextInt();

            students[i] = new int[]{p, s};
        }
        Arrays.sort(students, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });
        // for(int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(students[i]));
        // }

        int answer = 0;
        boolean coupon = true;
        for(int i = 0; i < n; i++){
            if(students[i][0] + students[i][1] <= b){
                b -= students[i][0] + students[i][1];
                answer += 1;
            }
            else if((students[i][0] / 2 + students[i][1]) <= b){
                b -= (students[i][0] / 2 + students[i][1]);
                answer += 1;
            }
            else{
                break;
            }
        }

        System.out.println(answer);
    }
}