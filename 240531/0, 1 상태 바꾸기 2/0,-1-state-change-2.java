import java.util.*;
/*
1. 타입1 : for문 활용
2. 타입2 : 좌우 대칭값이면서 가장 많은 스위치를 포함하는 구간 = 대칭인 최대 구간
*/
public class Main {
    static int swap(int n){
        if(n == 1) {
            return 0;
        }
        return 1;
    }
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] switches = new int[n+1];
        for(int i = 1; i < n+1; i++){
            switches[i] = sc.nextInt();
        }
        // System.out.println(Arrays.toString(switches));

        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int type = sc.nextInt();
            int snum = sc.nextInt() ;
            // System.out.println(type + " " + snum);

            if(type == 1){
                int j = 1;
                while(snum*j < n+1){
                    switches[snum*j] = swap(switches[snum*j]);
                    j += 1;
                }
            }
            else {
                switches[snum] = swap(switches[snum]);
                int j = 1;
                while(0 < snum-j && snum+j < n+1){
                    if(switches[snum+j] != switches[snum-j]){
                         break; 
                    }
                    switches[snum-j] = swap(switches[snum-j]);
                    switches[snum+j] = swap(switches[snum+j]);
                    j+= 1;
                }
            }
            // System.out.println(Arrays.toString(switches));
        }

        for(int i = 1; i < n+1; i++){
            System.out.print(switches[i] + " ");
        }
    }
}