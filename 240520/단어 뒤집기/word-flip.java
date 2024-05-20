import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int n = input.length();
        boolean reverse = true;

        StringBuffer result = new StringBuffer();
        StringBuffer tmp = new StringBuffer();

        for(int i = 0; i < n; i++){
            char letter = input.charAt(i);
            // System.out.println(letter + " " + tmp);

            if(letter == '<'){
                if(tmp.length() > 0) {
                    result.append(tmp.reverse()); 
                    // System.out.println("중간점검: " + result);
                    tmp = new StringBuffer();
                }
                tmp.append(letter);
                reverse = false;
            }
            else if (letter == '>'){
                tmp.append(letter);
                reverse = true;

                result.append(tmp);
                // System.out.println("중간점검: " + result);
                tmp = new StringBuffer();
            }     
            else{
                tmp.append(letter);
            }       
        }   
        System.out.println(result);            
    }    
}