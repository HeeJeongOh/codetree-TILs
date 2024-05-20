import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("");

        int n = input.length;
        boolean reverse = true;

        StringBuffer result = new StringBuffer();
        StringBuffer tmp = new StringBuffer();

        for(int i = 0; i < n; i++){
            String letter = input[i];
            // System.out.print(letter + " " + tmp);
            // System.out.println("  / result:" + result);
            if(letter.equals(" ")){
                result.append(tmp.reverse());
                result.append(" ");
                tmp = new StringBuffer();
            }
            else if(letter.equals("<")){
                if(tmp.length() > 0) {
                    result.append(tmp.reverse()); 
                    tmp = new StringBuffer();
                }
                tmp.append(letter);
                reverse = false;
            }
            else if (letter.equals(">")){
                tmp.append(letter);
                reverse = true;

                result.append(tmp);
                tmp = new StringBuffer();
            }
            else{
                tmp.append(letter);
            }       
        }   
        if(tmp.length() > 0) {
            result.append(tmp.reverse()); 
        }
        System.out.println(result);            
    }    
}