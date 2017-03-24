package numbertheory;


import java.math.BigInteger;

/**
 * Created by fabianwildhaber on 21.02.17.
 */
public class sheet1_exercise4 {

    public static void main(String[] args) {

        int[] list = getArray(100000);

        calcPrimes(list);

    }

    public static int[] getArray(int number){
        int[] list = new int[number];

        for (int i = 0; i < number; i++) {
            list[i] = i;
        }

        return list;
    }

    public static void calcPrimes(int[] list){
        for(int i : list){
            if(i%2==0){
                System.out.println(i);
            }
        }
    }

}

