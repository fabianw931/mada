package RsaKeygen;

import java.io.File;
import java.math.BigInteger;

/**
 * Created by fabianwildhaber on 24.03.2017.
 */
public class RSADecrypt {

    private BigInteger d;
    private BigInteger n;

    public RSADecrypt(BigInteger d, BigInteger n){
        this.d = d;
        this.n = n;
    }

    /**
     *decrypts Tesxt from given BigInteger array
     * Decrypts using the same fast exponentiation algorithm as used by the encryption function
     *
     * @param encryptedText
     * @return String decryptedText
     */
    public String decryptText(BigInteger[] encryptedText){

        System.out.println("Decrypting... Might take a while.");

        FastExponentiation fe = new FastExponentiation();
        StringBuilder decryptedText = new StringBuilder();

        System.out.println("Fast Exponentiation");

        int j = 0;
        for(BigInteger i : encryptedText){

            decryptedText.append((char) fe.calculateFE(d, n, i).intValue());
            j++;
        }

        return decryptedText.toString();
    }


    /**
     *Reads cipher from a given file and returns it in form of a BigInteger array
     *
     * @param filename
     * @return BigInteger[] cipher
     */
    public BigInteger[] readCipherFromFile(String filename) {
        FileHandler fh = new FileHandler();
        return fh.readCipherFromFile(filename);
    }

    /**
     *
     * Writes decrypted text to a file.
     *
     * @param decrypted
     * @param filename
     */
    public void writeDecryptedTextToFile(String decrypted, String filename) {
        FileHandler fh = new FileHandler();
        fh.writeFile(decrypted, filename);

    }
}
