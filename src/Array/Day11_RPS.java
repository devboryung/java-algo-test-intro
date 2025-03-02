package Array;

import java.util.Scanner;

public class Day11_RPS {
    public static void main(String[] args) {
        Day11_RPS T = new Day11_RPS();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] gameA = new int[num];
        int[] gameB = new int[num];

        for(int i = 0; i < num; i++) {
            gameA[i] = sc.nextInt();
        }
        for(int i = 0; i < num; i++) {
            gameB[i] = sc.nextInt();
        }

        for (String s : T.solution(num, gameA, gameB)) {
            System.out.println(s);
        }

    }

    public String[] solution(int n, int[] a, int[] b) {

        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) answer[i] = "D";
            else if (a[i] == 1 && b[i] == 2) answer[i] = "B";
            else if (a[i] == 2 && b[i] == 3) answer[i] = "B";
            else if (a[i] == 3 && b[i] == 1) answer[i] = "B";
            else answer[i] = "A";
        }
        return answer;
    }
}
