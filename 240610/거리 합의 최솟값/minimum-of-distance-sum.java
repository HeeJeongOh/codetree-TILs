import java.util.*;
/*
검색 : 평균값이 아닌 중앙값 찾기
*/

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] xs = new int[n];
        int[] ys = new int[n];

        int xsum = 0, ysum = 0;
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            
            xs[i] = x;
            ys[i] = y;
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        int x1 = xs[(int)Math.floor(n/2)];
        int y1 = ys[(int)Math.floor(n/2)];

        if(n % 2 == 0){
            x1 = (xs[(int)Math.floor(n-1/2)] + x1) / 2;
            y1 = (ys[(int)Math.floor(n-1/2)] + y1) / 2;
        }

        // System.out.println(Arrays.toString(xs) + " " + x1);
        // System.out.println(Arrays.toString(ys) + " " + y1);

        int total = 0; 

        for(int i = 0; i < n; i++){
            int x2 = xs[i];
            int y2 = ys[i];

            total += Math.abs(x1-x2) + Math.abs(y1-y2);
        }

        System.out.println(total);
    }
}