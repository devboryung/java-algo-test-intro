package String;

import java.util.ArrayList;
import java.util.Scanner;

public class Day5_RemoveDupChar {

    public static void main(String[] args) {
        Day5_RemoveDupChar T = new Day5_RemoveDupChar();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        ArrayList<String> strList = new ArrayList<>();
        for (String s : str.split("")) {
            if(strList.contains(s)) continue;
            strList.add(s);
        }

        return String.join("", strList);
    }
}
