# String(문자열)
## 문제8. 회문 문자열(replaceAll 정규식 이용)

- **문제**
  - **설명**  
    앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
    문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력하는 프로그램을 작성하세요.
    단 회문을 검사할 때 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
    알파벳 이외의 문자들의 무시합니다.  

  - **입력**  
    첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
  - **출력**
    첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.


- **풀이 과정**
    - 문자열을 입력받습니다.
    - 정규식을 이용해 주어진 문자열에서 알파벳만 남긴 후 대소문자를 구분하지 않기 위해 입력 값을 모두 소문자로 변경해 배열로 변환합니다.
    - 반복문이 진행될 때마다 i값이 증가하며 배열의 양 끝에서부터 하나씩 서로 다른 값을 비교합니다. 서로 같지 않다면 NO를 반환합니다.


- **코드**
```java
import java.util.Scanner;

public class Day7_Palindrome2 {

  public static void main(String[] args) {
    Day7_Palindrome2 T = new Day7_Palindrome2();
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    System.out.println(T.solution(input));
  }

  public String solution(String str) {
    char[] inputArr = str.replaceAll("[^a-zA-Z]", "").toLowerCase().toCharArray();
    int length = inputArr.length;
    for (int i = 0; i < length/2; i++) {
      if (inputArr[i] != inputArr[length - 1 - i]) return "NO";
    }
    return "YES";
  }
}

```


- **사용한 API 정리**
    - String.replaceAll();
      - 문자열을 수정할 때 사용하는 메서드로, 주어진 문자열에서 주어진 정규식과 일치하는 부분을 다른 문자열로 대체합니다.
      - String.replace();는 주어진 문자 또는 문자열과 일치하는 부분을 다른 문자열로 대체합니다.
    - 정규식
      - 사용된 정규식 [^a-zA-Z]는 소문자 및 대문자 알파벳이 아닌 문자를 찾는 패턴입니다.
        - []: 대괄호 안에 지정된 문자 집합 중 하나와 일치하는 문자를 찾습니다.
        - ^: 대괄호 내의 '^'는 부정을 의미합니다. '^'가 있다면 대괄호 안에 나열된 문자 집합에 포함되지 않은 문자를 찾습니다.
        - a-zA-Z: a-z는 소문자 알파벳을 나타내고, A-Z는 대문자 알파벳을 나타냅니다.

**! 주의** 
- inputArr 배열에 입력된 문자열이 제대로 담기지 않아 회문 문자열임에도 불구하고 계속 'NO'를 반환했다.  
  확인해보니 입력 값을 받는 부분에 sc.next()를 사용해 첫 번째 공백을 만나기 전까지의 문자열만 입력을 받았다.  
  문자열에 공백도 담길 수 있기 때문에 입력된 모든 문자열을 담기 위해 nextLine()을 사용해야 한다.
