import java.util.*;
/*
- 모든 정수를 제거하기 위한 정수 k를 설정하는 최소 횟수

1. 임의의 k 설정

2. k와 동일한 숫자 발견 시 제거
    2.1 k -= 1
3. k == 0 or i == n-1
    3.1 다시 1번으로
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        Random rn = new Random();

        int n = sc.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < n; i++){
            nums.add(sc.nextInt());
        }
        // System.out.println(nums);

        int answer = 1;

        // k 설정
        int k = nums.get(0);
        int idx = 0;

        // for(int i = 0; i < 10; i++){
        while(nums.size() > 0){
            if(k == 0 || idx == nums.size()){
                idx = 0;
                k = nums.get(0);
                answer += 1;
            }

            // System.out.println(idx + " " + k + " " + nums);

            for(idx = 0; idx < nums.size(); idx++){
                if(nums.get(idx) == k){
                    nums.remove(idx);
                    k -= 1;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}