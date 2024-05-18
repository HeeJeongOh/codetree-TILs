import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int type = sc.nextInt();

        int k = (int)(n/2);
        switch(type){
            case 1:
                for(int i = 0; i < k; i++){
                    for(int j = 0; j < i+1; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for(int i = k; 0 <= i; i--){
                    for(int j = 0; j < i+1; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 2:                
                for(int i = 0; i < k; i++){
                    for(int j = k-i-1; 0 <= j; j--){
                        System.out.print(" ");
                    }
                    for(int j = 0; j < i+1; j++){
                        System.out.print("*");
                    }
                    System.out.println();

                }
                for(int i = k; 0 <= i; i--){
                    for(int j = k-i-1; 0 <= j; j--){
                        System.out.print(" ");
                    }
                    for(int j = 0; j < i+1; j++){
                        System.out.print("*");
                    }
                    System.out.println();

                }
                break;
            case 3:
                for(int i = 0; i < k; i++){
                    for(int j = 0; j < i; j++){
                        System.out.print(" ");
                    }
                    for(int j = 0; j < n-(i*2); j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                for(int i = k; 0 <= i; i--){
                    for(int j = 0; j < i; j++){
                        System.out.print(" ");
                    }
                    for(int j = 0; j < n-(i*2); j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 4:                
                for(int i = k; 0 <= i; i--){
                    for(int j = k-i-1; 0 <= j; j--){
                        System.out.print(" ");
                    }
                    for(int j = 0; j < i+1; j++){
                        System.out.print("*");
                    }
                    System.out.println();

                }
                
                for(int i = 1; i <= k; i++){
                    for(int j = 0; j < k; j++){
                        System.out.print(" ");
                    }
                    for(int j = 0; j < i+1; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }

                break;
        }
        // 여기에 코드를 작성해주세요.
    }
}