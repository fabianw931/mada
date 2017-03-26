package RsaKeygen;

import java.math.BigInteger;

/**
 * Created by fabia on 24.03.2017.
 */
public class ExtendedEuclideanAlgorithm {


    /**
     * Calculates eed.
     *
     *
     * @param e
     * @param nTotient
     * @return
     */
    public BigInteger calculateEea(BigInteger nTotient, BigInteger e){
        System.out.println("Extended Euclidean Algorithm");
        BigInteger a = nTotient;
        BigInteger b = e;

        BigInteger x0 = BigInteger.ONE;
        BigInteger y0 = BigInteger.ZERO;
        BigInteger x1 = BigInteger.ZERO;
        BigInteger y1 = BigInteger.ONE;

        BigInteger xTemp;
        BigInteger yTemp;

        BigInteger q;
        BigInteger r;



        while(!(b.compareTo(BigInteger.ZERO) == 0)){

            q = a.divide(b);
            r = a.mod(b);

            a = b;
            b = r;

            xTemp = x0;
            yTemp = y0;

            x0 = x1;
            y0 = y1;

            x1 = xTemp.subtract(x1.multiply(q));
            y1 = yTemp.subtract(y1.multiply(q));


        }


        return y0;
    }

}
