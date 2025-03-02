package Array;

import java.util.Scanner;

public class Day11_VisibleStudent {

    public static void main(String[] args)
    {
        Day11_VisibleStudent T = new Day11_VisibleStudent();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] heightArr = new int[num];
        for (int i = 0; i < num; i++) {
            heightArr[i] = sc.nextInt();
        }

        System.out.println(T.solution(num, heightArr));
    }

    public int solution(int n, int[] nArr) {

        //최장신 담는 변수
        int max = nArr[0];
        //첫번째 학생은 무조건 보이므로 1로 초기화.
        int count = 1;
        for (int i = 1; i < n; i++) {
            if (max < nArr[i]) {
                max = nArr[i];
                count++;
            }
        }

        return count;
    }
}
