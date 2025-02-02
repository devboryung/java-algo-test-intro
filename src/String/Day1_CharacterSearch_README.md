# String(문자열)
## 문제1. 문자 찾기

- **문제**
  - 설명: 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하세요.  
        대소문자를 구분하지 않습니다.문자열의 길이는 100을 넘지 않습니다.
  - 입력: 첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.  
         문자열은 영어 알파벳으로만 구성되어 있습니다.
  - 출력: 첫 줄에 해당 문자의 개수를 출력한다.


- **풀이 과정**
    - 첫 번째로 문자열과 문자를 입력 받습니다.
    - 문자열에 특정 문자가 있는지 확인하기 위해 문자열을 문자로 바꿉니다. 
    - 대소문자를 구분하지 않기 위해 모두 대문자로 바꿔줍니다.
    - 반복문을 이용해 문자열에 입력된 문자를 하나씩 가져와서 해당 문자가 주어진 특정문자와 일치하는지 비교합니다.


- **코드**
```java
import java.util.Scanner;

public class Day1_CharacterSearch {

    public static void main(String[] args) {
        Day1_CharacterSearch m = new Day1_CharacterSearch();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.next().charAt(0);
        System.out.println(m.Solution(str, ch));
    }

    public int Solution(String str, char ch) {
        char[] chArr = str.toUpperCase().toCharArray();
        ch = Character.toUpperCase(ch);
        int count = 0;

        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] == ch) {
                count++;
            }
        }
        return count;
    }
}
