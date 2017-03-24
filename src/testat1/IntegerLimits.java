package testat1;

/**
 * Created by fabianwildhaber on 08.03.17.
 */
public class IntegerLimits {

    public static void main(String[] args) {
        int i = 1;

        for (int j = 0; j < 4; j++) {
            i *= 256;
            System.out.println(i);
        }


    }

}
