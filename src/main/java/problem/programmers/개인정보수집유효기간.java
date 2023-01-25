package problem.programmers;

import java.util.*;

public class 개인정보수집유효기간 {
    public int dateToInteger(String date) {
        String[] split = date.split("\\.");
        return Integer.parseInt(split[0]) * 28 * 12 +
                Integer.parseInt(split[1]) * 28 +
                Integer.parseInt(split[2]);
    }

    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answerList = new ArrayList<>();
        int todayInt = dateToInteger(today);
        Map<String, Integer> termsMap = new HashMap<>();

        for (String term: terms) {
            String[] temp = term.split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]) * 28);
        }
        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            if (
                    dateToInteger(temp[0]) + termsMap.get(temp[1]) <= todayInt
            ) {
                answerList.add(i + 1);
            }

        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
