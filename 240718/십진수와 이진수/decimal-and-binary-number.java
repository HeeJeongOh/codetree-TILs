import java.util.*;
import java.math.BigInteger;
/*
[시도1] int 활용 - 런타임에러 
[시도2] long 활용 + for, while문으로 직접 변환 - 숫자 범위 초과

< Big Integer >
import java.math.BigInteger;
BigInteger bigInt1 = new BigInteger("123456789123456789123456789123456789");
BigInteger bigInt2 = new BigInteger("987654321987654321987654321987654321");

// Arithmetic operations
BigInteger sum = bigInt1.add(bigInt2);
BigInteger difference = bigInt1.subtract(bigInt2);
BigInteger product = bigInt1.multiply(bigInt2);
BigInteger quotient = bigInt1.divide(bigInt2);
BigInteger remainder = bigInt1.remainder(bigInt2);

// Conversion to binary string
String binaryString = bigInt1.toString(2);
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