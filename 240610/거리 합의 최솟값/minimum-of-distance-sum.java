import java.util.*;

/*
검색 : 평균값이 아닌 중앙값 찾기
1 3 5 9 12 14 
*/

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] xs = new int[n];
        int[] ys = new int[n];

        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            xs[i] = x;
            ys[i] = y;
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        // 중앙값 계산
        int xMedian = xs[n / 2];
        int yMedian = ys[n / 2];

        // 요소가 짝수 개일 경우, 두 중앙값의 평균 계산
        if (n % 2 == 0) {
            xMedian = (xs[n / 2 - 1] + xMedian) / 2;
            yMedian = (ys[n / 2 - 1] + yMedian) / 2;
        }

        // System.out.println("X 좌표들의 중앙값: " + xMedian);
        // System.out.println("Y 좌표들의 중앙값: " + yMedian);

        // 거리 합 계산
        long totalDistance = 0; 

        for(int i = 0; i < n; i++){
            totalDistance += Math.abs(xMedian - xs[i]) + Math.abs(yMedian - ys[i]);
        }

        System.out.println(totalDistance);
    }
}