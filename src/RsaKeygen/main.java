package RsaKeygen;

import java.math.BigInteger;

/**
 * Created by fabianwildhaber on 24.03.17.
 */
public class main {

    public static void main(String[] args) {


        RSAKeygen keygen = new RSAKeygen();
        FileHandler fh = new FileHandler();

        keygen.calculateKeypair();
        keygen.getPrivateKey();
        keygen.getPublicKey();
        keygen.writeKeysToFile();

        char[] encryptCharArray = fh.getTextToEncrypt("text.txt");


        RSAEncrypt rsae = new RSAEncrypt(keygen.e, keygen.n);

        int[] encryptAsciiArray = rsae.stringToAsciiCode(encryptCharArray);

        BigInteger[] encryptedTextArray = rsae.encryptText(encryptAsciiArray);

        RSADecrypt rsad = new RSADecrypt(keygen.d, keygen.n);

        BigInteger asdfasdf = encryptedTextArray[0];


       // rsad.decryptText(encryptedTextArray);

        /*
        FastExponentiation fe = new FastExponentiation();
        System.out.println(fe.calculateFE(BigInteger.valueOf(13), BigInteger.valueOf(11), 7));
        */


    }

}
