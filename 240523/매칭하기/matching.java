import java.util.*;
/*
같은 글자끼리 쌍을 지었을 때, 위쪽으로 아치형 곡선
- 선이 겹치지 않고, 모두가 짝지어진 경우
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

            boolean[] visited = new boolean[len];
            int cnt = 0;
            boolean flag = true;

            ArrayList<Integer> starts = new ArrayList<>();
            ArrayList<Integer> ends = new ArrayList<>();

            for(int i = 0; i < len; i++){
                String start = input[i];
                visited[i] = true;
                starts.add(i);

                for(int j = len-1; 0 <= j; j--){
                    String end = input[j];
                    if(start.equals(end) && visited[j] == false){
                        int min = starts.get(starts.size()-1);
                        if((ends.size() > 0) && (i < min && j < ends.get(ends.size()-1)) || (min < i && ends.get(ends.size()-1) < j)){
                            flag = false;
                        }
                        else{
                            ends.add(j);
                            visited[j] = true;
                            cnt += 1;
                        }            
                        break;
                    }
                }
                if(flag == false){
                    break;
                }
            }
            if(flag == true && cnt == (int)(len/2)){
                answer += 1;
            }
            System.out.println(Arrays.toString(input) + " " + answer);

        }
        System.out.println(answer);
    }
}