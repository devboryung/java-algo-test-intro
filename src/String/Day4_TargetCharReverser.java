package String;

import java.util.Scanner;

public class Day4_TargetCharReverser {

    public static void main(String[] args) {
        Day4_TargetCharReverser T = new Day4_TargetCharReverser();
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        System.out.println(T.solution(word));
    }

    public String solution(String str) {
        char[] chArr = str.toCharArray();
        int first = 0;
        int last = str.length() - 1;

        while (first < last) {
            if (!Character.isLetter(chArr[first])) {
                first++;
            } else if (!Character.isLetter(chArr[last])) {
                last--;
            } else {
                char temp = chArr[first];
                chArr[first] = chArr[last];
                chArr[last] = temp;
                first++;
                last--;
            }
        }

        return String.valueOf(chArr);
    }
}
