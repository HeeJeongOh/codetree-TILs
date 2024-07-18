import java.util.*;
/*
S(t) = S(t-1) + m + o * (t+2) + S(t-1)

S(0) = moo = 3
S(1) = (moo) + mooo + (moo) = 3 + 4 + 3 = 10
S(2) = (moo + mooo + moo) + moooo + (moo + mooo + moo) = 3 4 3 5 3 4 3

[시도1] 메모리 초과 (10^9 메모리초과)
1. 문자열을 이어붙여서 인덱스로 접근하기

[시도2]
1. 문자열 직접 생성 X
2. 길이로 재귀적 접근
    2.1 front - mid - back으로 상황 쪼개기
    2.2 (chatGPT) 
*/
public class Main {
    static long length(int k) {
        if (k == 0) {
            return 3;  // length of "moo"
        } else {
            return 2 * length(k - 1) + (k + 3);
        }
    }
    public static void main(String[] args) {

        char answer = ' ';

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // S(t) = S(t-1) + (t+3) + S(t-1)
        int t = 0;

        // len : S(t)의 길이
        long len = length(t);
        while (len < N) {
            t++;
            len = length(t);
        }        

        while(true){
            if (t == 0) {
                answer = "moo".charAt(N - 1);
                break;
            }

            long leftLength = length(t - 1);
            long middleLength = t + 3;
            
            // System.out.println("t:"+ t + " N:" + N + " len:" + len + " left:"+ leftLength + " middle:" + middleLength);

            // front - 앞쪽에 있기 때문에 뒷 부분 버리기
            if (N <= leftLength) {
                len = leftLength;
                t -= 1;
            } 
            // middle - 첫 글자를 제외하고는 모두 o
            else if (N <= leftLength + middleLength) {
                answer = (N - leftLength == 1) ? 'm' : 'o';
                break;
            } 
            // back - N을 앞쪽 범위 숫자로 바꾸고 뒷부분 버리기
            else {
                N -= (leftLength + middleLength);
                len = leftLength;
                t -= 1;            
            }
        }

        System.out.println(answer);
        sc.close();
    }
}