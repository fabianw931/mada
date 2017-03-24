package RsaKeygen;

import java.math.BigInteger;

/**
 * Created by fabianwildhaber on 24.03.17.
 */
public class main {

    public static void main(String[] args) {

        /*
        RSAKeygen keygen = new RSAKeygen();
        FileHandler fh = new FileHandler();
        RSAEncrypt rsae = new RSAEncrypt();

        keygen.calculateKeypair();
        keygen.getPrivateKey();
        keygen.getPublicKey();
        keygen.writeKeysToFile();

        char[] encryptCharArray = fh.getTextToEncrypt("text.txt");

        int[] encryptAsciiArray = rsae.stringToAsciiCode(encryptCharArray);
        */


        FastExponentiation fe = new FastExponentiation();
        System.out.println(fe.calculateFE(BigInteger.valueOf(13l), BigInteger.valueOf(11l), 7));

    }

}
