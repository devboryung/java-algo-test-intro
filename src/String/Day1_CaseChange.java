package String;

import java.util.Scanner;

public class Day1_CaseChange {
    public static void main(String[] args) {
        Day1_CaseChange caseChange = new Day1_CaseChange();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(caseChange.Solution(str));
    }

    public String Solution(String str) {
        char[] chArr = str.toCharArray();
        for (int i = 0; i < chArr.length; i ++) {
            if (chArr[i] >= 65 && chArr[i] <= 90) {
                chArr[i] = Character.toLowerCase(chArr[i]);
            } else if (chArr[i] >= 97 && chArr[i] <= 122) {
                chArr[i] = Character.toUpperCase(chArr[i]);
            }
        }
        return String.valueOf(chArr);
    }
}
