package by.epamtc.lyskovkirill.task0303.util;

import java.util.regex.*;

public class TextProcess {
    static String WORD_CHARACTER_PATTERN = "[\\wа-яА-Я]+";
    static String NON_WORD_CHARACTER_PATTERN = "[^\\wа-яА-Я]+";

    public static String replaceEveryKCharInWord(String text, int k, char c) {
        StringBuilder textBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile(WORD_CHARACTER_PATTERN);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            if (matcher.group().length() >= k) {
                textBuilder.setCharAt(matcher.start() + k - 1, c);
            }
        }
        return textBuilder.toString();
    }

    public static String replaceAWithOAfterP(String text) {
        StringBuilder textBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile("РА(\\z|" + NON_WORD_CHARACTER_PATTERN + ")");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group().trim();
            String end = matcher.group().substring(matcher.group().lastIndexOf(matcher.group().charAt(word.length() - 1)) + 1);
            textBuilder.replace(matcher.start(), matcher.end(), "РО" + end);
        }
        return textBuilder.toString();
    }

    public static String replaceWordWithSubstring(String text, int wordLength, String substring) {
        StringBuilder textBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile(WORD_CHARACTER_PATTERN);
        Matcher matcher = pattern.matcher(text);
        int offset = 0;
        while (matcher.find()) {
            if (matcher.group().length() == wordLength) {
                String word = matcher.group().trim();
                String end = matcher.group().substring(matcher.group().lastIndexOf(matcher.group().charAt(word.length() - 1)) + 1);
                textBuilder.replace(matcher.start() + offset, matcher.end() + offset, substring);
                offset += substring.length() - (matcher.group().length()) + end.length();
            }
        }
        return textBuilder.toString();
    }

    public static String deleteNonLetterCharacters(String text) {
        StringBuilder textBuilder = new StringBuilder();
        Pattern pattern = Pattern.compile("[a-zA-Zа-яА-Я]+(\\z| +)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            textBuilder.append(matcher.group());
        }
        for (int i = 0; i < textBuilder.length(); i++) {
            if (i > 0 && textBuilder.charAt(i) != ' ' && textBuilder.charAt(i - 1) != ' ')
                textBuilder.insert(i, ' ');
        }
        if (textBuilder.isEmpty())
            textBuilder.append(text);
        return textBuilder.toString();
    }

    public static String deleteWordsStartingWithConsonantLetter(String text, int wordLength) {
        StringBuilder textBuilder = new StringBuilder(text);
        Pattern pattern = Pattern.compile(WORD_CHARACTER_PATTERN);
        Matcher matcher = pattern.matcher(text);
        int offset = 0;
        while (matcher.find()) {
            Pattern charPattern = Pattern.compile("(?ui:[^aeiouyаеёиоуыэюя])");
            Matcher charMatcher = charPattern.matcher("" + matcher.group().charAt(0));
            if (matcher.group().length() == wordLength && charMatcher.matches()) {
                String word = matcher.group().trim();
                String end = matcher.group().substring(matcher.group().lastIndexOf(matcher.group().charAt(word.length() - 1)) + 1);
                textBuilder.replace(matcher.start() + offset, matcher.end() + offset, "");
                offset -= matcher.group().length() - end.length();
            }
        }
        return textBuilder.toString();
    }
}
