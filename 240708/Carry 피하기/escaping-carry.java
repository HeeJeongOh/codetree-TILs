import java.util.*;
/*
- n개의 숫자 중 일부를 골라 캐리가 발생하지 않는 최대값
    ㄴ 캐리 : 수와 수를 더했을 때 10의 자리를 넘는 것
- 각 자리수를 모두 더했을 때 10 이상이 되는 경우가 없도록 만들기

1. n개 중 n ~ 1개 선택하는 경우의 수 모두 따지기
2. (중요) 배열이나 래퍼 클래스를 사용하여 cnt 값을 저장하면, 재귀 메소드 내에서 변경된 값이 메소드 외부에서도 반영
*/
public class Main {

     static boolean isCarryFree(List<Integer> numbers) {
        int[] digitSum = new int[10];
        for (int number : numbers) {
            int place = 0;
            while (number > 0) {
                digitSum[place] += number % 10;
                if (digitSum[place] >= 10) {
                    return false; // carry detected
                }
                number /= 10;
                place++;
            }
        }
        return true;
    }

    static void get_combination(int[] arr, List<Integer> temp, int start, int r, int[] cnt) {
        if (r == 0) {
            if(isCarryFree(temp) == true){
                cnt[0] = temp.size();
                // System.out.println(temp);
                return;
            }
        }
        for (int i = start; i < arr.length; i++) {
            temp.add(arr[i]);
            get_combination(arr, temp, i + 1, r - 1, cnt);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int answer = 0;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int r = n; r > 0; r--) {
            int[] cnt = new int[1];
            get_combination(nums, new ArrayList<Integer>(), 0, r, cnt);
            if(cnt[0] != 0){
                answer = cnt[0];
                break;
            }
        }
        System.out.println(answer);
    }
}