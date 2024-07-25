import java.util.*;
import java.math.*;

/*
- L칸 위에 N개의 점
- 접은 기점을 기준으로 오른쪽에 있는 점들은 모두 왼쪽과 겹쳐지도록

1. fold_point를 옮겨가면서 확안하기
2. 10 6 4 2 0
    fp = 8
    right : 0 2 4 6
    left  : 8
3. fold_point가 실수가 될 수 있댜
    3.1 fold_point 간격 설정해야함 - 주어진 점들의 최대 소숫점자리로 설정하기
    3.2 double로 했떠니 숫자값이 막 0.1 0.2 ... 0.999999999 이런식으로 변해서 big decimal로 변환
        -> + : .add / - .substract / < bA.compareTo(bB)
*/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        
        int max_num_of_points = 0;
        BigDecimal[] points = new BigDecimal[N];
        
        for(int i = 0; i < N; i++){
            points[i] = BigDecimal.valueOf(sc.nextDouble());
            
            int num_of_points = points[i].scale();
            if(max_num_of_points < num_of_points){
                max_num_of_points = num_of_points;
            }
            
        }
        Arrays.sort(points);
        
        int answer = 0;

        BigDecimal increment = BigDecimal.valueOf(Math.pow(10, -(max_num_of_points + 1)));
        BigDecimal bigL = new BigDecimal(String.valueOf(L));
        BigDecimal fold_point = increment;

        // System.out.println("Increment: " + increment);
        
        while (fold_point.compareTo(bigL) < 0) {
            boolean flag = true;

            ArrayList<BigDecimal> right = new ArrayList<>();
            ArrayList<BigDecimal> left = new ArrayList<>();
            
            for (int i = 0; i < N; i++) {
                if (points[i].compareTo(fold_point) < 0) {
                    right.add(0, points[i]);
                } else if (points[i].compareTo(fold_point) > 0) {
                    left.add(points[i]);
                }
            }
            
            // System.out.println("Fold point: " + fold_point);
            // System.out.println("Right side: " + right);
            // System.out.println("Left side: " + left);
            
            for (int i = 0; i < right.size(); i++) {
                if (left.size() < i + 1) { 
                    break; 
                }
                
                BigDecimal rightDistance = fold_point.subtract(right.get(i));
                BigDecimal leftDistance = left.get(i).subtract(fold_point);
                
                if (!rightDistance.equals(leftDistance)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer += 1;
            }
            
            fold_point = fold_point.add(increment);
        }
        
        System.out.println(answer);
    }
}