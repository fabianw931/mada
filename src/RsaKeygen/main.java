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
        RSAEncrypt rsae = new RSAEncrypt(keygen.e, keygen.n);

        keygen.calculateKeypair();
        keygen.writeKeysToFile();

        RSADecrypt rsad = new RSADecrypt(keygen.d, keygen.n);



        int[] asciiArray = rsae.getAsciiArrayToEncrypt("text.txt");
        BigInteger[] encryptedTextArray = rsae.encryptText(asciiArray);
        rsae.writeEncryptedTextToFile(encryptedTextArray, "cipher.txt");
        String decrypted = rsad.decryptText(encryptedTextArray);
        rsad.writeDecryptedTextToFile(decrypted, "text-d.txt");
        System.out.println("\n" + "Decrypted Text: ");
        System.out.println(decrypted + "\n");



        keygen.readPrivateKey("sk_example.txt");
        RSADecrypt rsad_example = new RSADecrypt(keygen.d, keygen.n);

        BigInteger[] cipherFromText = rsad_example.readCipherFromFile("cipher_example.txt");
        String decryptedExample = rsad_example.decryptText(cipherFromText);
        rsad_example.writeDecryptedTextToFile(decryptedExample, "text-d_example.txt");

        System.out.println("\n" + "Decrypted Text Example: ");
        System.out.println(decryptedExample + "\n");

        System.out.println("Done!");

     }
}
