package Array;

import java.util.Scanner;

public class Day12_FibonacciSequence {
    public static void main(String[] args) {
        Day12_FibonacciSequence T = new Day12_FibonacciSequence();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int answer : T.solution(num)) {
            System.out.print(answer + " ");
        }
    }

    public int[] solution(int n) {
        int[] answer = new int[n];

        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < n; i++) {
            answer[i] = answer[i - 1] + answer[i - 2];
        }

        return answer;
    }
}
