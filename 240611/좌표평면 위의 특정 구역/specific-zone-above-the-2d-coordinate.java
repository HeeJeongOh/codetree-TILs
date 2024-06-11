import java.util.*;
/*
- 하나의 점을 빼서, 모든 점들을 포함하는 직사각형의 넓이를 최소로 하기


*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] locations = new int[n][];
        
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            locations[i] = new int[]{x, y};
        }

        Arrays.sort(locations, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] != o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        
        // for(int i = 0; i < n; i++){
        //     System.out.println(Arrays.toString(locations[i]));
        // }

        int total = 0;
        int minx = 40000, miny = 40000;
        int maxx = 0, maxy = 0;

        for(int i = 1; i < n; i++){
            int x = locations[i][0];
            int y = locations[i][1];

            if(x < minx) {minx = x;}
            else if (maxx < x) {maxx = x;}


            if(y < miny) {miny = y;}
            else if (maxy < y) {maxy = y;}
        }
        total = (maxx-minx)*(maxy-miny);

        // System.out.println("(" + minx + "," + miny +")");
        // System.out.println("(" + maxx + "," + maxy +")");
        // System.out.println(total);

        minx = 40000;
        miny = 40000;
        maxx = 0;
        maxy = 0;

        for(int i = 0; i < n-1; i++){
            int x = locations[i][0];
            int y = locations[i][1];

            if(x < minx) {minx = x;}
            else if (maxx < x) {maxx = x;}


            if(y < miny) {miny = y;}
            else if (maxy < y) {maxy = y;}
        }

        if(total > (maxx-minx)*(maxy-miny)){
            total = (maxx-minx)*(maxy-miny);
        }


        // System.out.println("(" + minx + "," + miny +")");
        // System.out.println("(" + maxx + "," + maxy +")");
        System.out.println(total);
    }
}