import java.util.*;
/*
- 하나의 숫자를 선택하여 그 숫자를 전부 제외
- 연속하여 동일한 숫자가 나오는 횟수가 최대가 되도록

2 / 7 / 3 / 7 7 / 3 / 7 / 5 / 7
2 / 2 / 2

1. k 후보 구하기
2. k 숫자 제거해가며 연속 숫자 세기

1. 연속된 경우 미리 구분짓기
2. 

*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] numbers = new int[N];
        Set<Integer> numset = new TreeSet<>();
        for(int i = 0; i < N; i++){
            numbers[i] = sc.nextInt();
            numset.add(numbers[i]);
        }
        // System.out.println(numset);
        // System.out.println(Arrays.toString(numbers));

        int answer = 0;
        for(int k : numset){
            int cnt = 1;
            int prenum = numbers[0];
            // System.out.println("k : " + k);
            for(int i = 1; i < N; i++){
                if(numbers[i] == k){
                    continue;
                }
                if(prenum != numbers[i]){
                    // System.out.println("prenum : " + prenum + ", cnt : " + cnt);
                    if(answer < cnt) {
                        answer = cnt; 
                    }
                    prenum = numbers[i];
                    cnt = 1;                    
                }
                else{
                    cnt += 1;
                }   
            }
            // System.out.println("prenum : " + prenum + ", cnt : " + cnt);
            if(answer < cnt) {
                answer = cnt; 
            }
        }            
        System.out.println(answer);
    }
}