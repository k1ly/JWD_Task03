package by.epamtc.lyskovkirill.task0303.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcess {
    static String WORD_CHARACTER_PATTERN = "[^\s.,!?:;'\"@#$%^&*()+=]";
    static String CONSONANT_LETTER_PATTERN = "(?ui:[^aeiouyаеёиоуыэюя])";

    public static String replaceEveryKCharInWord(String text, int k, char c) {
        StringBuilder textBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile(WORD_CHARACTER_PATTERN + "+");
        Matcher matcher = pattern.matcher(textBuilder);
        while (matcher.find()) {
            if (matcher.group().length() >= k) {
                textBuilder.setCharAt(matcher.start() + k - 1, c);
            }
        }
        return textBuilder.toString();
    }

    public static String correctLastCharacter(String text) {
        StringBuilder textBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile("РА");
        Matcher matcher = pattern.matcher(textBuilder);
        return matcher.replaceAll("РО");
    }

    public static String replaceWordWithSubstring(String text, int wordLength, String substring) {
        StringBuilder textBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile(WORD_CHARACTER_PATTERN + "+");
        Matcher matcher = pattern.matcher(textBuilder);
        int offset = 0;
        while (matcher.find()) {
            if (matcher.group().length() == wordLength) {
                textBuilder.replace(matcher.start() + offset, matcher.end() + offset, substring);
                offset += substring.length() - (matcher.end() - matcher.start());
            }
        }
        return textBuilder.toString();
    }

    public static String deleteNotLetterCharacters(String text) {
        StringBuilder textBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile("([a-zA-Zа-яА-Я ])+");
        Matcher matcher = pattern.matcher(textBuilder);
        textBuilder = new StringBuilder();
        while (matcher.find()) {
            textBuilder.append(matcher.group());
        }
        for (int i = 0; i < textBuilder.length(); i++) {
            if (i > 0 && textBuilder.charAt(i) != ' ' && textBuilder.charAt(i - 1) != ' ')
                textBuilder.insert(i, ' ');
        }
        return textBuilder.toString();
    }

    public static String deleteConsonantLetterWord(String text, int wordLength) {
        StringBuilder textBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile("(^" + CONSONANT_LETTER_PATTERN + WORD_CHARACTER_PATTERN + "{" + (wordLength - 1) + "," + (wordLength - 1) + "})");
        Matcher matcher = pattern.matcher(textBuilder);
        textBuilder = new StringBuilder();
        while (matcher.find()) {
            textBuilder.append(matcher.group());
        }
        return textBuilder.toString();
    }
}
