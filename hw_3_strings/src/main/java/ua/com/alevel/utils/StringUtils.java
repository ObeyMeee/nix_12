package ua.com.alevel.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {

    private StringUtils(){

    }

    public static String reverse(String str){
        char[] string = str.toCharArray();
        StringBuilder revereStr = new StringBuilder();
        for (int i = string.length - 1; i >= 0; --i) {
            revereStr.append(string[i]);
        }
        return revereStr.toString();
    }

    public static String reverseEachWord(String str) {
        String regex = "[а-яА-я\\w]+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
         str = matcher.replaceAll(matchResult ->
                 reverse(matchResult.group()));
        return str;
    }


    public static String reverse(String string, String substr){
        Pattern pattern = Pattern.compile(substr);
        Matcher matcher = pattern.matcher(string);
        string = matcher.replaceAll(matchResult -> reverse(matchResult.group()));
        return string;
    }

    public static String reverse(String string, int firstIndex, int lastIndex){
        String substr = string.substring(firstIndex, lastIndex + 1);
        Pattern pattern = Pattern.compile(substr);
        Matcher matcher = pattern.matcher(string);
        string = matcher.replaceFirst(matchResult -> reverseEachWord(matchResult.group()));
        return string;
    }
}
