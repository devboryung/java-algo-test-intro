package String;

import java.util.Scanner;

public class Day1_CharacterSearch {

    public static void main(String[] args) {
        Day1_CharacterSearch m = new Day1_CharacterSearch();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.next().charAt(0);
        System.out.println(m.Solution(str, ch));
    }

    public int Solution(String str, char ch) {
        char[] chArr = str.toUpperCase().toCharArray();
        ch = Character.toUpperCase(ch);
        int count = 0;

        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == ch) {
                count++;
            }
        }
        return count;
    }
}
