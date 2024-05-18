import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String winner = "A";
        
        sc.nextLine();
        for(int i = 0; i < 4; i++){
            String[] classInfo = sc.nextLine().split(" ");
            String className = classInfo[0].split("")[0];

            int total = 0;
            int max_total = 0;
            for(int t = 1; t < classInfo.length; t++){
                total += Integer.parseInt(classInfo[t]);
            }
            System.out.println(className + " - " + total);
            if(max_total < total){
                max_total = total;
                winner = String.valueOf(className);
            }
        }
        System.out.printf("Class %s is winner!", winner);
    }
}