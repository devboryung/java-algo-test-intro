package String;

import java.util.Scanner;

public class Day9_Password {

    public static void main(String[] args) {
        Day9_Password T = new Day9_Password();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String symbol = sc.next();
        System.out.println(T.solution(num, symbol.substring(0, num * 7)));
    }

    public StringBuilder solution(int n, String str) {
        StringBuilder answer = new StringBuilder();

        int start = 0;
        for (int i = 0; i < n; i++) {
            //입력된 문자열을 7개씩 자름
            String bin = str.substring(start, start + 7).replace('#', '1').replace('*','0');
            start += 7;

            //2진수를 10진수로 변환
            int decimal = 0;
            for (int j = 0; j < bin.length(); j++) {
                if (bin.charAt(j) != '0') decimal += (int) Math.pow(2, 6 - j);
            }
            answer.append((char) decimal);
        }

        return answer;
    }
}
