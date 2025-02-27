package String;

import java.util.Scanner;

public class Day8_MinCharDistance {

    public static void main(String[] args) {
        Day8_MinCharDistance T = new Day8_MinCharDistance();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char t = sc.next().charAt(0);
        for ( int answer : T.solution(input, t)) {
            System.out.print(answer + " ");
        }
    }

    public int[] solution(String str, char t) {
        int[] intArr = new int[str.length()];

        int dis = 1000;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == t) dis = 0;
            intArr[i] = dis;
            dis++;
        }

        for (int i = str.length() - 1; i > -1; i--) {
            if (str.charAt(i) == t) {
                dis = 0;
                dis++;
                continue;
            }
            intArr[i] = Math.min(intArr[i], dis);
            dis++;
        }
        return intArr;
    }
}
