import java.util.*;
/*
[시도2] 
1. 최대최솟값이 포함된 점들만 제거해보기 - 최대 4개의 점
*/
public class Main {
    public static void main(String[] args) {   
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] xs = new int[n];
        int[] ys = new int[n];
        int[][] points = new int[n][2];
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            xs[i] = x;
            ys[i] = y;

            points[i] = new int[]{x, y};
        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        // System.out.println(xs[0]+ " " + xs[n-1] + " " + ys[0] + " " + ys[n-1]);

        Set<Integer> indexes = new HashSet<>();
        for(int i = 0; i < n; i++){
            // System.out.println(Arrays.toString(points[i]));
            if(points[i][0] == xs[0]){
                indexes.add(i);
            }
            if(points[i][0] == xs[n-1]){
                indexes.add(i);
            }
            if(points[i][1] == ys[0]){
                indexes.add(i);
            }
            if(points[i][1] == ys[n-1]){
                indexes.add(i);
            }
        }
        // System.out.println(indexes);

        long area = 1600000000;
        for(int idx : indexes){
            int[] min = new int[]{40000, 40000};
            int[] max = new int[]{0, 0};

            for(int i = 0; i < n; i++){
                if(i == idx) { continue; }

                int x = points[i][0];
                int y = points[i][1];

                if( x < min[0]) { min[0] = x; }
                if( y < min[1]) { min[1] = y; }

                if( max[0] < x) { max[0] = x; }
                if( max[1] < y) { max[1] = y; }
            }

            long tmp = (max[0]-min[0])*(max[1]-min[1]);
            if(tmp < area){ area = tmp;}

            // System.out.println(Arrays.toString(min) + " " + Arrays.toString(max) + " " + tmp);
        }
        System.out.println(area);
    }
}