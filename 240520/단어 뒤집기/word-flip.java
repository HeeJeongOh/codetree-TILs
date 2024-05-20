import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");

        StringBuffer result = new StringBuffer();
        StringBuffer tmp = new StringBuffer();
        boolean reverse = true;

        for(String word : input){
            // System.out.println(word);
            int n = word.length();
            tmp = new StringBuffer("");

            for(int i = 0; i < n; i++){
                char letter = word.charAt(i);
                // System.out.println(letter + " " +tmp + " " + result);

                if(letter == '<'){
                    result.append(tmp.reverse());
                    tmp = new StringBuffer("");

                    tmp.append("<");
                    reverse = false;
                }
                else if (letter == '>'){
                    result.append(tmp);
                    result.append(">");

                    tmp = new StringBuffer();
                    reverse = true;
                }
                else{
                    tmp.append(letter);
                }
            }
            if(reverse){
                result.append(tmp.reverse() + " ");
            }
            else{
                result.append(tmp + " ");
            }
        }
        System.out.println(result);
    }    
}