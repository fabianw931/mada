package RsaKeygen;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.security.interfaces.RSAKey;

/**
 * Created by fabianwildhaber on 24.03.17.
 */
public class main {

    public static void main(String[] args) {

        System.out.println("Starting RSA");

        RSAKeygen keygen = new RSAKeygen();
        FileHandler fh = new FileHandler();

        /*
        keygen.calculateKeypair();
        keygen.writeKeysToFile();


        char[] encryptCharArray = fh.getTextToEncrypt("text.txt");

        RSAEncrypt rsae = new RSAEncrypt(keygen.e, keygen.n);
        int[] encryptAsciiArray = rsae.stringToAsciiCode(encryptCharArray);
        BigInteger[] encryptedTextArray = rsae.encryptText(encryptAsciiArray);

        fh.writeEncryptedToFile(encryptedTextArray, "cipher.txt");

        */



        keygen.readSK();
        RSADecrypt rsad = new RSADecrypt(keygen.d, keygen.n);

        //String decrypted = rsad.decryptText(encryptedTextArray);

        BigInteger[] cipherFromText = fh.readCipherFromFile("cipher.txt");
        String decrypted = rsad.decryptText(cipherFromText);

        fh.writeFile(decrypted, "text-d.txt");

        System.out.println("Done!");

     }
}
