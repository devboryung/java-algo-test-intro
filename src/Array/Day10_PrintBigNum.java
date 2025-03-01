package Array;

import java.util.ArrayList;
import java.util.Scanner;

public class Day10_PrintBigNum {
    public static void main(String[] args) {
        Day10_PrintBigNum T = new Day10_PrintBigNum();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] numArr = new int[num];
        for (int i = 0; i < num; i++) {
            numArr[i] = sc.nextInt();
        }

        //StringBuilder로 반환
        System.out.println(T.solution(numArr));

        // int[]로 반환받기
        for (int x : T.solution2(num, numArr)) {
            System.out.print(x + " ");
        }
    }

    public StringBuilder solution(int[] nArr) {
        StringBuilder answer = new StringBuilder();
        int num = nArr[0];
        answer.append(num).append(" ");
        for (int i = 1; i <= nArr.length - 1; i++ ) {
            if (num < nArr[i]) {
                answer.append(nArr[i]).append(" ");
            }
            num = nArr[i];
        }
        return answer;
    }


    public ArrayList<Integer> solution2(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) answer.add(arr[i]);
        }
        return answer;
    }
}
