import java.util.*;
/*
- 하나의 점을 빼서, 모든 점들을 포함하는 직사각형의 넓이를 최소로 하기

1. 어떤 점을 뺄 것인가
2. 넓이 = (최대x-최소x) * (최대y-최소y)
3. 최대x,y가 같은 점이 아님
4. 

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

            // System.out.print("(" + x + " " + y + ") /");
        }
        // System.out.println();

        // 모든 경우 다 넓이 구하기
        long min_area = 1600000000;
        for(int i = 0; i < n; i++){
            int minx = 40000, miny = 40000;
            int maxx = 0, maxy = 0;

            for(int j = 0; j < n; j++){
                if(i == j) { continue; }
                
                if(xs[j] < minx){ minx = xs[j]; }
                if (maxx < xs[j]){ maxx = xs[j]; }

                if(ys[j] < miny){ miny = ys[j]; }
                if (maxy < ys[j]){ maxy = ys[j]; }
            }

            long tmp = (maxx-minx) * (maxy-miny);

            // System.out.println(i + " (" + minx + " " + miny + ") * (" + maxx + " " + maxy + ") => " + tmp);

            if(tmp < min_area){
                min_area = tmp;
            }
        }
        System.out.println(min_area);
    }
}