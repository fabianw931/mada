package RsaKeygen;

/**
 * Created by fabia on 24.03.2017.
 */
public class RSAEncrypt {

    public int[] stringToAsciiCode(char[] textArray){
        int[] asciiArray = new int[textArray.length];

        int i = 0;
        while(i < textArray.length){
            asciiArray[i] = (int) textArray[i];
            i++;
        }

        return asciiArray;
    }
}
