package String;

import java.util.Scanner;

public class Day7_Palindrome2 {

    public static void main(String[] args) {
        Day7_Palindrome2 T = new Day7_Palindrome2();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(T.solution(input));
    }

    public String solution(String str) {
        char[] inputArr = str.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
        int length = inputArr.length;
        for (int i = 0; i < length/2; i++) {
            if (inputArr[i] != inputArr[length - 1 - i]) return "NO";
        }
        return "YES";
    }
}
