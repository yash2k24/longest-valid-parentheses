import java.util.Stack;

public class LongestValidParentheses {

    public static int getLongestValid(String s) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int currentLen = i - stack.peek();
                    maxLen = Math.max(maxLen, currentLen);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {

        String input = IO.readln("Enter String input : ");

        int result = getLongestValid(input);

        IO.println("Output: " + result);
    }
}