package String;

import java.util.Scanner;

public class Day9_StringCompress {
    public static void main(String[] args) {
        Day9_StringCompress T = new Day9_StringCompress();
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(T.solution(input));
    }

    public StringBuilder solution(String str) {
        StringBuilder answer = new StringBuilder();

        int cnt = 1;
        char chkC = 0;
        for (char c : str.toCharArray()) {
            if (c == chkC) {
                if (cnt != 1) answer.deleteCharAt(answer.length() - 1);
                answer.append(++cnt);
            } else {
                answer.append(c);
                cnt = 1;
                chkC = c;
            }
        }

        return answer;
    }
}
