package RsaKeygen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;
import java.util.Random;

/**
 * Created by fabianwildhaber on 24.03.2017.
 *
 * This class is used to generate keypairs, save them or read them from files.
 *
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

    /**
     * Whenever new instance is made it automatically generates p, q and a suitable n
     *
     */
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


    /**
     * returns public key
     * @return String pk
     */
    public String getPublicKey(){
        return sbPublic.toString();
    }

    /**
     * returns private key
     * @return String sk
     */
    public String getPrivateKey(){
        return sbPrivate.toString();
    }

    /**
     *Calculates d suitable e for the already chosen e.
     *
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

    /**
     * writes generated keys to file
     * if keys not generated, it calculates d
     */
    public void writeKeysToFile(){
        if(d == null){
            calculateKeypair();
        }
        FileHandler fh = new FileHandler();
        fh.writeFile(sbPrivate.toString(), "sk.txt");
        fh.writeFile(sbPublic.toString(), "pk.txt");
    }

    /**
     * reads public key from given file
     *
     * @param filename
     */
    public void readPublicKey(String filename){
        FileHandler fh = new FileHandler();
        Map<String, BigInteger> pkMap= fh.getKeyFromFile(filename);
        this.n = pkMap.get("n");
        this.e = pkMap.get("key");
    }

    /**
     * reads private key from given file
     *
     * @param filename
     */
    public void readPrivateKey(String filename) {
        FileHandler fh = new FileHandler();
        Map<String, BigInteger> skMap= fh.getKeyFromFile(filename);
        this.n = skMap.get("n");
        this.d = skMap.get("key");
    }
}
