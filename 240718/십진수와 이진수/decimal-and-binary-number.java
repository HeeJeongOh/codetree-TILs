import java.util.*;
import java.math.BigInteger;
/*
input : 10001111110001000101000001000100111100110101100011000011011001111000100110110000110101110101100001001100010111000101000100010010011000000010010

Big Integer : lon
*/

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String binaryStr = sc.next();

        // binary to decmial
        BigInteger decimalValue = new BigInteger(binaryStr, 2);
        BigInteger mulValue = new BigInteger("17");

        decimalValue = decimalValue.multiply(mulValue);
        // System.out.println("Decimal value: " + decimalValue);

        // // to binary
        String answer = decimalValue.toString(2);
        System.out.println(answer);

    }
}