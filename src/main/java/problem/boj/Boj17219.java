package problem.boj;

import java.util.*;

public class Boj17219 {
    static void solution(Map<String, String> passwordMap, String[] sites) {
        for (String site: sites) {
            System.out.println(passwordMap.get(site));
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> passwordMap = new HashMap<>();

        String[] nAndm = scanner.nextLine().split(" ");
        String[] temp;
        String[] sites = new String[Integer.parseInt(nAndm[1])];
        for (int i = 0; i < Integer.parseInt(nAndm[0]); i++) {
            temp = scanner.nextLine().split(" ");
            passwordMap.put(temp[0], temp[1]);
        }

        for (int i = 0; i < Integer.parseInt(nAndm[1]); i++) {
            sites[i] = scanner.nextLine();
        }

        solution(passwordMap, sites);
    }
}
