package problem;

import java.math.*;

public class Pow {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }

        double temp, answer;


        if (n > 0) {
            temp = myPow(x, (int) n / 2);
        } else {
            temp = myPow(1 / x, (int) -n / 2);
        }
        int ntemp = n < 0 ? -n : n;
        if (ntemp % 2 == 1) {
            if (n > 0) {
                answer = x * temp * temp;
            } else {
                answer = 1 / x * temp * temp;
            }
        } else {
            answer = temp * temp;
        }
        if (Double.isInfinite(answer) || Double.isNaN(answer)) {
            return 0;
        }
        return answer;
    }
}
