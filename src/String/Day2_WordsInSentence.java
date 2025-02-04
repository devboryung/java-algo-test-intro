package String;

import java.util.Scanner;

public class Day2_WordsInSentence {
    public static void main(String[] args) {
        Day2_WordsInSentence T = new Day2_WordsInSentence();
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        System.out.println(T.Solution(sentence));
    }

    public String Solution(String str) {
        String[] strArr = str.split(" ");
        String words = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            if (words.length() >= strArr[i].length()) continue;
            words = strArr[i];
        }
        return words;
    }
}
