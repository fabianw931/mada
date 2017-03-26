package RsaKeygen;

import java.math.BigInteger;

/**
 * Created by fabianwildhaber on 24.03.2017.
 */
public class FastExponentiation {

    BigInteger ONE = BigInteger.ONE;


    /**
     *
     * Algorithm calculates (x^e) mod n
     * e.bitLength() gives the number of bits in e back
     * checks whether the bit at given position i is 1 or 0.
     * When counting int i up it checks the bits from right to left
     *
     * @param e
     * @param n
     * @param character
     * @return BigInteger result
     */
    public BigInteger calculateFE(BigInteger e, BigInteger n, BigInteger character){
        BigInteger base = character;
        BigInteger modulo = n;
        BigInteger exponent = BigInteger.valueOf(e.bitLength());
        BigInteger result = ONE;

        int i = 0;
        while (exponent.compareTo(BigInteger.ZERO) >= 0) {
            if (e.testBit(i)){
                result = result.multiply(base).mod(modulo);
            }
            i++;
            base = base.multiply(base).mod(modulo);
            exponent = exponent.subtract(ONE);
        }


        /*
        while (i <= e.bitLength()){
            if (exponent.testBit(i)){
                result = result.multiply(base).mod(modulo);
            }
            base = base.multiply(base).mod(modulo);
            i++;
        }
        */


        return result;
    }
}
