package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

  public boolean isValid(String s) {
    List<Character> open = new ArrayList<>(Arrays.asList('(', '[', '{'));
    List<Character> close = new ArrayList<>(Arrays.asList(')', ']', '}'));

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if (open.contains(s.charAt(i))) {
        stack.push(s.charAt(i));
      } else {
        if (stack.size() == 0) {
          return false;
        }
        if (close.indexOf(s.charAt(i)) == open.indexOf(stack.peek())) {
          stack.pop();
        } else {
          return false;
        }
      }
    }

    if (stack.size() != 0) {
      return false;
    }
    return true;
  }
}
