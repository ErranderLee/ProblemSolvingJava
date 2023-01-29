package problem.boj;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Boj11723 {

    static Scanner scanner = new Scanner(System.in);

    static void solution(int m) {
        int nums = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String args = scanner.next();
            switch(args) {
                case "add":
                    nums |= 1 << (scanner.nextInt() - 1);
                    break;
                case "remove":
                    nums &= ~(1 << (scanner.nextInt() - 1));
                    break;
                case "check":
                    if ((nums & (1 << (scanner.nextInt() - 1))) == 0) {
                        result.append("0\n");
                    } else {
                        result.append("1\n");
                    }
                    break;
                case "toggle":
                    nums ^= (1 << scanner.nextInt() - 1);
                    break;
                case "all":
                    nums = nums | ~nums;
                    break;
                default:
                    nums = 0;
            }
        }
        System.out.print(result.toString());
    }

    public static void main(String[] args) {

        int m = scanner.nextInt();
        solution(m);
    }
}
