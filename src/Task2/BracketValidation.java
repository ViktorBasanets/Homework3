package Task2;

import java.util.Stack;

public class BracketValidation {

    public static void main(String[] args) {
        String str1 = validator("()[({(())})]".toCharArray());
        System.out.println(str1);

        String str2 = validator("([)]".toCharArray());
        System.out.println(str2);
    }

    static String validator(char[] string) {

        Stack<Character> stack = new Stack<>();

        boolean parentheses = check(string, stack, '(', ')');
        boolean squareBrackets = check(string, stack, '[', ']');
        boolean braces = check(string, stack, '{', '}');
        boolean result = parentheses && squareBrackets && braces;

        return (stack.isEmpty()) && result ? "is correct" : "isn't correct";
    }

    static boolean check(char[] string, Stack<Character> stack, char openBracket, char closeBracket) {

        boolean result = false;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == openBracket) {
                stack.push(string[i]);
            } else if (string[i] == closeBracket) {
                if(stack.isEmpty()) {
                    result = false;
                } else {
                    result = stack.pop() == openBracket ? true : false;
                }
            }
        }
        return result;
    }
}
