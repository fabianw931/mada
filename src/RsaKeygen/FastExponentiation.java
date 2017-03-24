package RsaKeygen;

import java.math.BigInteger;

/**
 * Created by fabia on 24.03.2017.
 */
public class FastExponentiation {

    BigInteger ONE = BigInteger.ONE;
    BigInteger TWO = ONE.add(ONE);
    BigInteger ZERO = BigInteger.ZERO;

    public BigInteger calculateFE(BigInteger e, BigInteger n, int character){

        BigInteger k = BigInteger.valueOf(character);
        BigInteger m = n;
        int i = 0;
        BigInteger h = ONE;

        String iBinary = e.toString(2);

        for (int j = 0; j < iBinary.length(); j++) {
            if(iBinary.charAt(j) == '1') i++;
        }

        while (i > 0){

            System.out.println("i: " + i);
            System.out.println("h: " + h);
            System.out.println("k: " + k);
            System.out.println();

            if ((i%2) == 1){
                h = (h.multiply(k)).mod(m);
            }
            k = (k.multiply(k)).mod(m);

            i--;
        }

        System.out.println(h);
        System.out.println(k);

        return h;
    }
}
