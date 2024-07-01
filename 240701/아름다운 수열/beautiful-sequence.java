import java.util.*;
/*
수열 B의 각 원소들에 동일한 숫자를 더하거나 빼고 순서를 바꿔나온 수열
수열 A에서 길이가 m인 연속 부붑ㄴ 수열 중 아름다운 수열의 수

1. 
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] anums = new int[n];
        for(int i = 0; i < n; i++){
            anums[i] = sc.nextInt();            
        }

        int m = sc.nextInt();
        int[] bnums = new int[m];
        for(int i = 0; i < m; i++){
            bnums[i] = sc.nextInt();            
        }
        Arrays.sort(bnums);

        int cnt = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i = 0; i < n-2; i++){
            int[] tmp = Arrays.copyOfRange(anums, i, i+3);
            Arrays.sort(tmp);

            // System.out.println(Arrays.toString(bnums));
            // System.out.println(Arrays.toString(tmp));

            int gap = bnums[0] - tmp[0];
            boolean flag = true;
            for(int j = 0; j < 3; j++){
                // System.out.println(bnums[j] + "-" + gap + " " + tmp[j]);
                if((bnums[j]-gap) != tmp[j]){
                    flag = false;
                    break;
                }
            }  
            if(flag){
                cnt += 1;
                answer.add(i+1);
            }       
        }
        System.out.println(cnt);
        for(int s : answer){
            System.out.println(s);
        }
    }
}