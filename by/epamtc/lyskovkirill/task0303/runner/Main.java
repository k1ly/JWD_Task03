package by.epamtc.lyskovkirill.task0303.runner;

import by.epamtc.lyskovkirill.task0303.util.TextProcess;

public class Main {

    public static void main(String[] args) {
        var str1 = "owh fowehfi: hwf%oeh wife; ofweho.weifh";
        System.out.println(TextProcess.replaceEveryKCharInWord(str1, 4, 'O'));

        var str2 = "iwcjРА зщуозозАР зщоуаРОзоу ЗОРАЛЩщлу Р А РАзо";
        System.out.println(TextProcess.correctLastCharacter(str2));

        var str3 = "ojwdo owkdpwkdqp(3230:wpodk$";
        System.out.println(TextProcess.replaceWordWithSubstring(str3, 4, "TTTTTT"));

        var str4 = "jfowefi 4893p oe oj(#4 wjefpwef";
        System.out.println(TextProcess.deleteNotLetterCharacters(str4));

        var str5 = "kodw udwo okopwf upwphfe(fpwf)";
        System.out.println(TextProcess.deleteConsonantLetterWord(str5, 4));
    }
}
