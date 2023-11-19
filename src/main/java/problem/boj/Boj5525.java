package problem.boj;

import java.lang.*;
import java.util.*;
import java.io.*;

public class Boj5525 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

//        System.out.println("length : " + m);

        int pointer = 0;
        int result = 0;
        while (pointer < m) {

            for (int i = pointer; i < m; i++) {
                if (s.charAt(i) == 'I') {
//                    System.out.println("I : " + pointer);
                    break;
                }
                pointer += 1;
            }

            boolean match = false;
            for (int i = 0; i < n; i++) {
                if (pointer + 2 >= m) {
//                    System.out.println("outbound " + (pointer + (2*i) + 2));
                    bw.write(String.valueOf(result));
                    bw.flush();
                    bw.close();

                    return;
                }
                if (s.charAt(pointer + 1) == 'O' && s.charAt(pointer + 2) == 'I') {
                    pointer += 2;
                    match = true;
//                    System.out.println("match : " + i + " " + pointer);
                } else {
                    match = false;
                    if (s.charAt(pointer + 2) == 'I') {
                        pointer = pointer + 2;
                    } else if (s.charAt(pointer + 1) == 'I') {
                        pointer = pointer + 1;
                    } else {
                        pointer = pointer + 3;
                    }
                    break;
                }
            }

            if (match) {
                result += 1;
                while (true) {
                    if (pointer + 2 >= m) {
                        bw.write(String.valueOf(result));
                        bw.flush();
                        bw.close();

                        return;
                    }

                    if (s.charAt(pointer + 1) == 'O' && s.charAt(pointer + 2) == 'I') {
                        pointer += 2;
                        result += 1;
//                        System.out.println("match 2 : " + pointer);
                    } else {
                        if (s.charAt(pointer + 2) == 'I') {
                            pointer += 2;
                        } else if (s.charAt(pointer + 1) == 'I') {
                            pointer += 1;
                        } else {
                            pointer += 3;
                        }
                        break;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
