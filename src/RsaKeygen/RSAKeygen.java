package RsaKeygen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

/**
 * Created by fabia on 24.03.2017.
 */
public class RSAKeygen {

    BigInteger n;
    BigInteger e = BigInteger.valueOf(65537);
    BigInteger d;
    BigInteger p;
    BigInteger q;

    private final int bitlength = 1024;

    private final StringBuilder sbPrivate = new StringBuilder();
    private final StringBuilder sbPublic = new StringBuilder();

    RSAKeygen(){
        Random rnd = new Random();
        p = BigInteger.probablePrime(bitlength, rnd);
        BigInteger eTmp = BigInteger.probablePrime(bitlength, rnd);

        while(p.equals(eTmp)){
            eTmp = BigInteger.probablePrime(bitlength,rnd);
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

        while(d.signum() == -1) d = d.add(nTotient);

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
        FileHandler fh = new FileHandler();
        fh.writeFile(sbPrivate.toString(), "sk.txt");
        fh.writeFile(sbPublic.toString(), "pk.txt");
    }

    public void readPK(){
        FileHandler fh = new FileHandler();
        Map<String, BigInteger> pkMap= fh.getKeyFromFile("pk.txt");
        this.n = pkMap.get("n");
        this.e = pkMap.get("key");
    }

    public void readSK() {
        FileHandler fh = new FileHandler();
        Map<String, BigInteger> skMap= fh.getKeyFromFile("sk.txt");
        this.n = skMap.get("n");
        this.d = skMap.get("key");
    }
}
