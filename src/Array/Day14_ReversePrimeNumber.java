package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day14_ReversePrimeNumber {

    public static void main(String[] args) {
            Day14_ReversePrimeNumber T = new Day14_ReversePrimeNumber();
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            int[] nArr = new int[num];
            for (int i = 0; i < num; i++) {
                nArr[i] = sc.nextInt();
            }

            for(int answer : T.solution(nArr)) {
                System.out.print(answer + " ");
            }
    }

    public ArrayList<Integer> solution(int[] nArr) {
        ArrayList<Integer> arrList = new ArrayList<>();

        //숫자 뒤집기
        for (int i : nArr) {
            int num = i;
            int reverNum = 0;
            while (num != 0) {
                int ex = num % 10; //마지막 자릿수 추출
                reverNum = reverNum * 10 + ex;
                num /= 10; //마지막 자릿수 제거
            }
            arrList.add(reverNum);
        }

        //소수 확인
        for (int i = 0; i < arrList.size(); i++) {
            int num = arrList.get(i);
            if (num < 2) {
                arrList.set(i, 0);
            } else {
                boolean isPrime = true;
                for (int j = 2; j < num; j++) {
                    if (num % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                //소수가 아닐 경우 0으로 설정
                if (!isPrime) arrList.set(i, 0);
            }
        }

        //모든 0 지우기
        arrList.removeAll(Arrays.asList(0));
        return arrList;
    }
}
