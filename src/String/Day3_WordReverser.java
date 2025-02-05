package String;

import java.util.ArrayList;
import java.util.Scanner;

public class Day3_WordReverser {

    public static void main(String[] args) {
        Day3_WordReverser T = new Day3_WordReverser();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] strArr = new String[num];
        for (int i = 0; i < num; i++) {
            strArr[i] = sc.next();
        }

        for (String str : T.Solution(strArr)) {
            System.out.println(str);
        }
    }

    public ArrayList<String> Solution(String[] strArr) {
        ArrayList<String> list = new ArrayList<>();
        for (String str : strArr) {
            String reverse = String.valueOf(new StringBuilder(str).reverse());
            list.add(reverse);
        }
        return list;
    }
}
