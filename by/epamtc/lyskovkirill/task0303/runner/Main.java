package by.epamtc.lyskovkirill.task0303.runner;

import by.epamtc.lyskovkirill.task0303.util.TextProcess;

public class Main {

    public static void main(String[] args) {
        System.out.println("Replace every k-th character in word\nOriginal: ");
        var str1 = "owh fowehfi: hwf%oeh wile; o125ho.weifh";   //var str1 = ConsoleScanner.enterString();
        System.out.println(str1);
        System.out.println("Processed:\n" + TextProcess.replaceEveryKCharInWord(str1, 4, 'O') + "\n");

        System.out.println("Replace A with O after P\nOriginal: ");
        var str2 = "iwcjРА зщуозозАР зщ7оуаРАзоуРА ЗОРАЛЩщлу Р А РАзо";    //var str2 = ConsoleScanner.enterString();
        System.out.println(str2);
        System.out.println("Processed:\n" + TextProcess.replaceAWithOAfterP(str2) + "\n");

        System.out.println("Replace words with this length with substring\nOriginal: ");
        var str3 = "ojwdo nwkd pwkdqp( ej24:  wpodk$]";  //var str3 = ConsoleScanner.enterString();
        System.out.println(str3);
        System.out.println("Processed:\n" + TextProcess.replaceWordWithSubstring(str3, 4, "TTTTTT") + "\n");

        System.out.println("Delete non-letter characters and insert spaces\nOriginal: ");
        var str4 = "jfowefi 4893p oe oj(#4 wjefpwef";   //var str4 = ConsoleScanner.enterString();
        System.out.println(str4);
        System.out.println("Processed:\n" + TextProcess.deleteNonLetterCharacters(str4) + "\n");

        System.out.println("Delete every word starting with consonant letter\nOriginal: ");
        var str5 = "kodw udwo okopwf upwphfe(fpwf)";    //var str5 = ConsoleScanner.enterString();
        System.out.println(str5);
        System.out.println("Processed:\n" + TextProcess.deleteWordsStartingWithConsonantLetter(str5, 4) + "\n");
    }
}
