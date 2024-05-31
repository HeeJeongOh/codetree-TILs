import java.util.*;
/*

*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] switches = new int[n+1];
        for(int i = 1; i < n+1; i++){
            switches[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(switches));

        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            int type = sc.nextInt();
            int switchNum = sc.nextInt() ;
            System.out.println(type + " " + switchNum);

            if(type == 1){
                for(int pos = switchNum; pos <= n+1; i*= 2){
                    if(switches[pos] == 1) {switches[pos] = 0;}
                    else {switches[pos] = 1;}
                }
                System.out.println(Arrays.toString(switches));
            }
            else if (type == 2){

            }
        }
    }
}