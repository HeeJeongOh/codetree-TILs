import java.util.*;
/*
같은 글자끼리 쌍을 지었을 때, 위쪽으로 아치형 곡선
- 선이 겹치지 않고, 모두가 짝지어진 경우

괄호 문제랑 같음 !!
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        int answer = 0;
        for(int t = 0; t < n; t++){
            String[] input = sc.nextLine().split("");
            int len = input.length;

            Deque<String> stack = new ArrayDeque<>();
            for(int i = 0; i < len; i++){
                // System.out.println(stack);
                if(stack.size() > 0){
                    if(stack.getLast().equals(input[i])){
                        stack.pollLast();
                    }
                    else{
                        stack.add(input[i]);
                    }
                }
                else{
                    stack.add(input[i]);
                }
            }
            if(stack.size() == 0) { answer += 1; }
            // System.out.println(Arrays.toString(input) + " " + stack);
        }
        System.out.println(answer);
    }
}