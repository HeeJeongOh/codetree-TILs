import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String binaryNumber = sc.next();

        // n2 -> n10 -> *17
        int decimalNumber = Integer.parseInt(binaryNumber, 2) * 17;
        // n10 -> n2
        binaryNumber = Integer.toBinaryString(decimalNumber);
        
        System.out.println(binaryNumber);

    }
}