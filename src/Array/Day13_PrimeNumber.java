package Array;

import java.util.Scanner;

public class Day13_PrimeNumber {
    public static void main(String[] args) {
        Day13_PrimeNumber T = new Day13_PrimeNumber();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(T.solution(num));
    }

    public int solution(int num) {
        int[] arr = new int[num + 1];
        int count = 0;

        for (int i = 2; i <= num; i++) {
            if (arr[i] == 0) {
                //0은 소수로 판단. count를 증가시킨다.
                count++;
                //i의 배수는 소수가 아니기 때문에 1로 셋팅한다.
                for (int j = i; j <= num; j += i) {
                    arr[j] = 1;
                }
            }
        }

        return count;
    }
}
