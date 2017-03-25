package RsaKeygen;

import java.math.BigInteger;

/**
 * Created by fabia on 24.03.2017.
 */
public class FastExponentiation {

    BigInteger ONE = BigInteger.ONE;

    public BigInteger calculateFE(BigInteger e, BigInteger n, BigInteger character){

        BigInteger base = character;
        BigInteger modulo = n;
        BigInteger exponent = e;
        BigInteger result = ONE;

        int i = 0;

        while (i <= e.bitLength()){
            if (exponent.testBit(i)){
                result = result.multiply(base).mod(modulo);
            }
            base = base.multiply(base).mod(modulo);
           i++;
        }

        return result;
    }

    private BigInteger fastExponentiation(BigInteger base, BigInteger exponent, BigInteger modulo) {
        System.out.println("fastExponentiation()");
        BigInteger check = BigInteger.ONE;
        BigInteger h = BigInteger.ONE;
        BigInteger k = base;
        while (check.compareTo(exponent) < 1){
            if (!exponent.and(check).equals(BigInteger.ZERO))
                h = (h.multiply(k)).mod(modulo);
            k = (k.pow(2)).mod(modulo);
            check = check.shiftLeft(1);
        }
        return h;
    }


}
