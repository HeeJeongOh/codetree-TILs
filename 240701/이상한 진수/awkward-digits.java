import java.util.*;
/*
2진법 : 0, 1
3진법 : 0, 1, 2

1. 모든 경우의 수 찾기
2. 
*/
public class Main {

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        String a = sc.next();
        String b = sc.next();

        Set<Integer> as = new HashSet<Integer>();
        Set<Integer> bs = new HashSet<Integer>();

        // 가능한 실제 a 후보
        for(int i = 0; i < a.length(); i++){
            sb.append(a.substring(0, i));
            if(a.charAt(i)== '0'){sb.append("1");}
            else if (a.charAt(i)== '1'){sb.append("0");}

            sb.append(a.substring(i+1, a.length()));

            as.add(Integer.parseInt(sb.toString(), 2));
            sb.delete(0, sb.length());
        }

        // System.out.println(as);

        // // 가능한 실제 b 후보
        for(int i = 0; i < b.length(); i++){
            sb.append(b.substring(0, i));
            if(b.charAt(i)== '0'){
                sb.append("1");
                sb.append(b.substring(i+1, b.length()));
                bs.add(Integer.parseInt(sb.toString(), 3));
                sb.delete(i, sb.length()); 
                
                sb.append("2");
                sb.append(b.substring(i+1, b.length()));
                bs.add(Integer.parseInt(sb.toString(), 3));
            }
            else if (b.charAt(i)== '1'){
                sb.append("0");
                sb.append(b.substring(i+1, b.length()));
                bs.add(Integer.parseInt(sb.toString(), 3));
                sb.delete(i, sb.length()); 
                
                sb.append("2");
                sb.append(b.substring(i+1, b.length()));
                bs.add(Integer.parseInt(sb.toString(), 3));
            }
            else if (b.charAt(i)== '2'){
                sb.append("0");
                sb.append(b.substring(i+1, b.length()));
                bs.add(Integer.parseInt(sb.toString(), 3));
                sb.delete(i, sb.length()); 
                
                sb.append("1");
                sb.append(b.substring(i+1, b.length()));
                bs.add(Integer.parseInt(sb.toString(), 3));
            }
            sb.delete(0, sb.length());
        }
        // System.out.println(bs);

        as.retainAll(bs);
        for(int n : as){
            System.out.println(n);
        }

    }
}