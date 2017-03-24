package RsaKeygen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

/**
 * Created by fabia on 24.03.2017.
 */
public class RSAKeygen {

    final BigInteger n;
    final BigInteger e = BigInteger.valueOf(65537);
    BigInteger d;
    final BigInteger p;
    final BigInteger q;

    private final StringBuilder sbPrivate = new StringBuilder();
    private final StringBuilder sbPublic = new StringBuilder();

    RSAKeygen(){
        Random rnd = new Random();
        p = BigInteger.probablePrime(1024, rnd);
        BigInteger eTmp = BigInteger.probablePrime(1024, rnd);

        while(p.equals(eTmp)){
            eTmp = BigInteger.probablePrime(1024,rnd);
        }

        q = eTmp;
        n = p.multiply(q);
    }


    public String getPublicKey(){
        return sbPublic.toString();
    }

    public String getPrivateKey(){
        return sbPrivate.toString();
    }

    /**
     *
     * e = 65537
     */
    public void calculateKeypair() {

        BigInteger nTotient = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        ExtendedEuclideanAlgorithm eea = new ExtendedEuclideanAlgorithm();
        d = eea.calculateEea(nTotient, e);

        sbPrivate.append("(");
        sbPrivate.append(n.toString());
        sbPrivate.append(",");
        sbPrivate.append(d.toString());
        sbPrivate.append(")");

        sbPublic.append("(");
        sbPublic.append(n.toString());
        sbPublic.append(",");
        sbPublic.append(e.toString());
        sbPublic.append(")");





    }

    public void writeKeysToFile(){

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("sk.txt"));

            bw.write(sbPrivate.toString());
            bw.close();

            bw = new BufferedWriter(new FileWriter("pk.txt"));
            bw.write(sbPublic.toString());
            bw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
