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

        BigInteger base = BigInteger.valueOf(character);
        BigInteger modulo = n;
        BigInteger exponent = ZERO;
        BigInteger result = ONE;

        String iBinary = e.toString(2);

        for (int j = 0; j < iBinary.length(); j++) {
            if(iBinary.charAt(j) == '1') exponent = exponent.add(ONE);
        }


        while (exponent.compareTo(ZERO) > 0){

            System.out.println("exponent: " + exponent);
            System.out.println("result: " + result);
            System.out.println("base: " + base);
            System.out.println();

            if (exponent.testBit(0)){

                System.out.println("odd " + exponent);
                System.out.println();
                result = (result.multiply(base)).mod(modulo);
            }
            base = (base.multiply(base)).mod(modulo);

            exponent = exponent.subtract(ONE);
        }



        //  why do I have to do this????
        //result = (result.multiply(base)).mod(modulo);
        System.out.println("------------");
        System.out.println("Result: " + result);
        System.out.println("base: " + base);
        System.out.println("------------");

        return result;
    }
}
