package RsaKeygen;

import java.math.BigInteger;

/**
 * Created by fabia on 24.03.2017.
 */
public class RSADecrypt {

    private BigInteger d;
    private BigInteger n;

    public RSADecrypt(BigInteger d, BigInteger n){
        this.d = d;
        this.n = n;
    }


    public String decryptText(BigInteger[] encryptedText){

        FastExponentiation fe = new FastExponentiation();
        StringBuilder decryptedText = new StringBuilder();

        System.out.println("Modulo: " + n);

        int j = 0;
        for(BigInteger i : encryptedText){

            decryptedText.append((char) fe.calculateFE(d, n, i.intValue()).intValue());
            j++;
        }

        System.out.println(decryptedText.toString());

        return "";
    }


}
