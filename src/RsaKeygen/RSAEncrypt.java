package RsaKeygen;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by fabia on 24.03.2017.
 */
public class RSAEncrypt {

    private BigInteger e;
    private BigInteger n;


    public RSAEncrypt(BigInteger e, BigInteger n){
        this.e = e;
        this.n = n;
    }

    public int[] stringToAsciiCode(char[] textArray){
        int[] asciiArray = new int[textArray.length];

        int i = 0;
        while(i < textArray.length){
            asciiArray[i] = (int) textArray[i];
            i++;
        }

        return asciiArray;
    }

    public BigInteger[] encryptText(int[] encryptAsciiArray) {

        FastExponentiation fe = new FastExponentiation();
        BigInteger[] encryptedText = new BigInteger[encryptAsciiArray.length];


        System.out.println("Modulo: " + n);

        int j = 0;
        for(int i : encryptAsciiArray){

            encryptedText[j] = fe.calculateFE(e, n, i);
            j++;
        }

        System.out.println(Arrays.toString(encryptedText));

        return encryptedText;

    }
}
