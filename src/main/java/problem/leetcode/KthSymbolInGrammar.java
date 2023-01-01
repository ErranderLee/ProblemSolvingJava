package problem.leetcode;

import java.lang.*;

public class KthSymbolInGrammar {

    public int getPowerOfTwo(int k) {
        int count = 0;
        while (k > 2) {
            k = (int) Math.ceil((double) k / 2);
            count++;
        }

        return count;
    }
    public int kthGrammar(int n, int k) {
        if (k == 1) return 0;
        else if (k == 2) return 1;
        return ((kthGrammar(n, k - (int) Math.pow(2.0, getPowerOfTwo(k))) + 1) % 2);
    }
}
/***
 * 0 0 1
 * 1 01 2
 * 2 0110 4
 * 3 01101001 8
 * 4 0110100110010110 16
 * (n + 1)st : nst + reverse nst
 */
