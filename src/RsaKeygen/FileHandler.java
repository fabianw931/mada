package RsaKeygen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fabia on 24.03.2017.
 */
public class FileHandler {


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

    public Map<String, BigInteger> getPkFromFile(String filename, String n, String key){

        return getKeyFromFile(filename, n, key);
    }


    public Map<String, BigInteger> getSkFromFile(String filename, String n, String key){

        return getKeyFromFile(filename, n, key);
    }


    public Map<String, BigInteger> getKeyFromFile(String filename, String n, String key){

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

            System.out.println(keyLine);

            String[] keySplit = keyLine.split(",");

            keyMap.put(n, new BigInteger(keySplit[0]));
            keyMap.put(key, new BigInteger(keySplit[1]));


        } catch (IOException e){
            e.printStackTrace();
        }

        return keyMap;
    }

}
