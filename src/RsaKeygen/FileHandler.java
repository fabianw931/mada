package RsaKeygen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fabia on 24.03.2017.
 */
public class FileHandler {


    /**
     * reads text from given file to char array used by RSAEncrypt
     *
     * @param filename
     * @return
     */
    public char[] getTextToEncrypt(String filename){

        char[] textArray = null;

        try {
            InputStream is = new FileInputStream(filename);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

            String text = buffer.readLine();
            StringBuilder sb = new StringBuilder();

            while(text!= null){
                sb.append(text);
                text = buffer.readLine();
            }

            text = sb.toString();
            textArray = text.toCharArray();

        } catch (IOException e){
            e.printStackTrace();
        }

        return textArray;
    }


    /**
     * Reads key from a given file to HashMap used by RSAKeygen
     *
     * @param filename
     * @return
     */
    public Map<String, BigInteger> getKeyFromFile(String filename){

        Map<String, BigInteger> keyMap= new HashMap<>();

        try {
            InputStream is = new FileInputStream(filename);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

            String keyLine = buffer.readLine();
            StringBuilder sb = new StringBuilder();
            while(keyLine!= null){
                sb.append(keyLine);
                keyLine = buffer.readLine();
            }

            keyLine = sb.toString();
            keyLine = keyLine.replace("(","");
            keyLine = keyLine.replace(")","");

            String[] keySplit = keyLine.split(",");

            keyMap.put("n", new BigInteger(keySplit[0]));
            keyMap.put("key", new BigInteger(keySplit[1]));


        } catch (IOException e){
            e.printStackTrace();
        }

        return keyMap;
    }

    /**
     * Writes the encrypted text fo a given file. used by RSAEncrypt
     *
     * @param encryptedTextArray
     * @param filename
     */
    public void writeEncryptedTextToFile(BigInteger[] encryptedTextArray, String filename) {

        String[] stringArray = new String[encryptedTextArray.length];

        StringBuilder sb = new StringBuilder();
        String prefix = "";

        for (BigInteger bi : encryptedTextArray){
           sb.append(prefix);
           prefix = ",";
           sb.append(bi.toString());
        }

        writeFile(sb.toString(), filename);

    }


    /**
     * reads cipher from a given file. Used by RSADecrypt
     *
     * @param filename
     * @return
     */
    public BigInteger[] readCipherFromFile(String filename){
        String[] keySplit = null;

        try {
            InputStream is = new FileInputStream(filename);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(is));

            String keyLine = buffer.readLine();
            StringBuilder sb = new StringBuilder();
            while(keyLine!= null){
                sb.append(keyLine);
                keyLine = buffer.readLine();
            }
            keyLine = sb.toString();

            keySplit = keyLine.split(",");

        } catch (IOException e){
            e.printStackTrace();
        }

        BigInteger[] cipherArray = new BigInteger[keySplit.length];

        int i = 0;
        for (String s : keySplit){
            cipherArray[i] = new BigInteger(s);
            i++;
        }

        return cipherArray;
    }


    /**
     * Writes any given text to any given file.
     * In this case used to write decrypted text a file.
     *
     * @param content
     * @param filename
     */
    public void writeFile(String content, String filename){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            bw.write(content);
            bw.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
