package problem.boj;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Boj10845 {

    static List<Integer> queue = new LinkedList<>();

    public static void push(Integer input) {
        queue.add(input);
    }

    public static Integer pop() {
        if (queue.size() == 0) {
            return -1;
        } else {
            return queue.remove(0);
        }
    }

    public static int size() {
        return queue.size();
    }

    public static int empty() {
        return queue.isEmpty() ? 1 : 0;
    }

    public static Integer front() {
        return queue.size() == 0 ? -1 : queue.get(0);
    }

    public static Integer back() {
        return queue.size() == 0 ? -1 : queue.get(queue.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(scanner.readLine());
        for (int i = 0; i < count; i++) {
            String[] arguments = scanner.readLine().split(" ");
            switch (arguments[0]) {
                case "push":
                    push(Integer.parseInt(arguments[1]));
                    break;
                case "pop":
                    writer.write(pop()+"\n");
                    break;
                case "size":
                    writer.write(size()+"\n");
                    break;
                case "empty":
                    writer.write(empty()+"\n");
                    break;
                case "front":
                    writer.write(front()+"\n");
                    break;
                case "back":
                    writer.write(back()+"\n");
                    break;
                default:
                    break;
            }
        }
        writer.flush();
        writer.close();
    }
}
