package RsaKeygen;

import java.math.BigInteger;

/**
 * Created by fabianwildhaber on 24.03.2017.
 */
public class RSAEncrypt {

    private BigInteger e;
    private BigInteger n;


    public RSAEncrypt(BigInteger e, BigInteger n){
        this.e = e;
        this.n = n;
    }


    /**
     *
     * Reads text from a file and converts it to an ascii array
     *
     * @param filename
     * @return int[] asciiArray
     */
    public int[] getAsciiArrayToEncrypt(String filename){
        FileHandler fh = new FileHandler();
        char[] textArray = fh.getTextToEncrypt(filename);

        int[] asciiArray = new int[textArray.length];

        int i = 0;
        while(i < textArray.length){
            asciiArray[i] = (int) textArray[i];
            i++;
        }

        return asciiArray;
    }

    /**
     * Encrypts the text in form of an int[] with ascii code inside.
     * Encrypts using fast exponentiation algorithm
     *
     * @param encryptAsciiArray
     * @return String encryptedText
     */
    public BigInteger[] encryptText(int[] encryptAsciiArray) {

        System.out.println("Encrypting.");

        FastExponentiation fe = new FastExponentiation();
        BigInteger[] encryptedText = new BigInteger[encryptAsciiArray.length];

        System.out.println("Fast Exponentiation");

        int j = 0;
        for(int i : encryptAsciiArray){

            encryptedText[j] = fe.calculateFE(e, n, BigInteger.valueOf(i));
            j++;
        }


        System.out.println("Encrypted");

        return encryptedText;

    }

    /**
     * Writes the encrypted Text to file
     *
     * @param encryptedTextArray
     * @param s
     */
    public void writeEncryptedTextToFile(BigInteger[] encryptedTextArray, String filename) {
        FileHandler fh = new FileHandler();
        fh.writeEncryptedTextToFile(encryptedTextArray, filename);
    }

}
