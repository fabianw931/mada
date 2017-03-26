package RsaKeygen;

import java.math.BigInteger;

/**
 * Created by fabia on 24.03.2017.
 */
public class FastExponentiation {

    BigInteger ONE = BigInteger.ONE;


    /**
     *
     * Algorithm calculates (x^e) mod n
     * Slightly different from the one in class.
     * Counts up instead of down. THis is done because BigInteger function testBit()
     * checks whether the bit at given position i is 1 or 0.
     * When counting up it checks the bits from right to left
     *
     * @param e
     * @param n
     * @param character
     * @return BigInteger result
     */
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
}
