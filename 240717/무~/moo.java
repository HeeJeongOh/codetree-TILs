import java.util.*;
/*
S(t) = S(t-1) + m + o * (t+2) + S(t-1)

S(0) = moo = 3
S(1) = (moo) + mooo + (moo) = 3 + 4 + 3 = 10
S(2) = (moo + mooo + moo) + moooo + (moo + mooo + moo) = 10 + 5 + 10


[시도1] 메모리 초과 (100000000)
1. 문자열을 이어붙여서 인덱스로 접근하기
*/
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        StringBuffer sb = new StringBuffer("moo");
        StringBuffer os = new StringBuffer("mooo");
        for(int i = 1; i < N; i++){
            String current = sb.toString();

            sb.append(os);            
            sb.append(current);

            os.append("o");

            if(sb.length() > N){
                // System.out.println(sb.toString());
                System.out.println(sb.charAt(N-1));
                break;
            }
        }
    }
}