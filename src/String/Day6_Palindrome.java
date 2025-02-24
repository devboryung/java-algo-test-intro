package String;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day6_Palindrome {

    public static void main(String[] args) {
        Day6_Palindrome T = new Day6_Palindrome();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }

    public String solution1(String str) {
        String[] inputArr = str.toLowerCase().split("");
        String[] reverseArr = str.toLowerCase().split("");
        List<String> reverseList = Arrays.asList(reverseArr);
        Collections.reverse(reverseList);

        int length = inputArr.length;
        for (int i = 0; i < length; i++) {
            if (!inputArr[i].equals(reverseList.get(i))) return "NO";
        }

        return "YES";
    }

    public String solution(String str) {
        char[] array = str.toLowerCase().toCharArray();
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            if (array[i] != array[length - 1 - i]) return "NO";
        }
        return "YES";
    }
}
