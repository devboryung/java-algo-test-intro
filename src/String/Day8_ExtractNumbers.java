package String;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day8_ExtractNumbers {

    public static void main(String[] args) {
        Day8_ExtractNumbers T = new Day8_ExtractNumbers();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(T.solution(input));
    }

    public int solution(String str) {
        String input = str.replaceAll("[^0-9]", "");
        return parseInt(input);
    }
}
