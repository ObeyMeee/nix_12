package ua.com.alevel.level2.ValidateBrackets;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateString {

    // used resource: https://question-it.com/questions/559769/optimizirovannoe-reshenie-dlja-problemy-sbalansirovannyh-skobok
    public static boolean isValidate(String input) {
        char[] brackets = getBrackets(input);
        Stack<Character> bracketsStack = new Stack<>();
        for (char bracket : brackets) {
            if (bracket == '(') {
                bracketsStack.add(')');
            } else if (bracket == '{') {
                bracketsStack.add('}');
            } else if (bracket == '[') {
                bracketsStack.add(']');
            } else if (bracketsStack.isEmpty() || bracketsStack.pop() != bracket) {
                return false;
            }
        }
        return bracketsStack.isEmpty();
    }

    private static char[] getBrackets(String input) {
        Pattern pattern = Pattern.compile("[(){}\\[\\]]");
        Matcher matcher = pattern.matcher(input);
        StringBuilder brackets = new StringBuilder();
        while (matcher.find()) {
            brackets.append(matcher.group());
        }
        return brackets.toString().toCharArray();
    }
}
