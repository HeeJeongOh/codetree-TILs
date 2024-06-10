import java.util.*;

/*
검색 : 평균값이 아닌 중앙값 찾기
*/

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        double[] xs = new double[n];
        double[] ys = new double[n];

        for(int i = 0; i < n; i++){
            double x = sc.nextInt();
            double y = sc.nextInt();
            
            xs[i] = x;
            ys[i] = y;
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        // 중앙값 계산
        double xMedian = xs[n / 2];
        double yMedian = ys[n / 2];

        // 요소가 짝수 개일 경우, 두 중앙값의 평균 계산
        if (n % 2 == 0) {
            xMedian = (xs[n / 2 - 1] + xs[n / 2]) / 2;
            yMedian = (ys[n / 2 - 1] + ys[n / 2]) / 2;
        }

        // System.out.println("X 좌표들의 중앙값: " + xMedian);
        // System.out.println("Y 좌표들의 중앙값: " + yMedian);

        // 거리 합 계산
        double totalDistance = 0; 

        for(int i = 0; i < n; i++){
            totalDistance += Math.abs(xMedian - xs[i]) + Math.abs(yMedian - ys[i]);
        }

        System.out.println((int)totalDistance);
    }
}