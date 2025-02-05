# String(문자열)
## 문제4. 단어 뒤집기

- **문제**
  - **설명**  
    N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.
  - **입력**  
    첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
    두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.
  - **출력**
    N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.


- **풀이 과정**
    - 단어의 개수를 정할 수를 입력받습니다.
    - 주어진 수만큼 단어를 입력받습니다.
    - 뒤집어진 단어를 순서대로 반환받아 출력합니다.
    - 단어 뒤집기는 StringBuilder의 reverse() 메서드를 이용합니다.
      - 정해진 위치의 문자열을 뒤집을 때는 문자열을 문자 배열로 쪼개 문자의 위치를 바꾸면 되지만, 해당 문제는 문자를 통으로 뒤집는 것이기 때문에 StringBuilder가 제공하는 reverse 메서드를 사용하는 것이 좋습니다.
    - 뒤집어진 문자는 String.valueOf()를 이용해 String 타입으로 변환합니다.
      - 반환 타입이 ArrayList<String>이기 때문입니다.
      - toString()으로 타입을 변환할 수 있지만, String.valueOf()는 내부적으로 toString()을 호출하기 전에 null 체크를 해주어 값이 null일 경우 null을 반환합니다.  
        toString()을 호출했을 때 값이 null이라면 **NullPointerException**이 발생합니다.
    
- **코드**
```java
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
```


- **사용한 API 정리**
    - StringBuilder().reverse();
      - StringBuider객체에 저장된 문자열의 순서를 반대로 뒤집어서 반환하는 메서드입니다.
