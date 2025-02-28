# String(문자열)
## 문제11. 문자열 압축

- **문제**
  - **설명**  
    알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.  
    단 반복횟수가 1인 경우 생략합니다.
  - **입력**  
    첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
  - **출력**
    첫 줄에 압축된 문자열을 출력한다.


- **풀이 과정**
    - 문자열을 입력받습니다.
    - 압축된 문자열을 받을 StringBuilder 객체를 생성합니다.
      - 문자열의 추가와 삭제가 빈번하게 일어나기 때문에 StringBuilder를 사용했습니다.
    - 반복 횟수를 기록할 변수와 문자를 기록할 변수를 선언합니다.
    - 입력받은 문자열에서 문자를 하나씩 가져와 비교합니다.
    - 기록된 문자와 현재 문자가 같다면, StringBuilder에 반복 횟수를 추가합니다.
      - 반복 횟수를 추가하는 이유는 입력된 문자열의 마지막 문자가 반복되는 경우 해당 문자의 반복 횟수를 StringBuilder에 추가하기 위함입니다. 
        - 만약 else 블록에서 반복 횟수를 추가한다면 마지막에 계산된 반복 횟수가 추가되지 않기 때문에 if 블록에서 처리합니다. 
      - 반복 횟수가 1이 아닌 경우(즉, 이전에 해당 문자가 반복된 경우)에는 기존 반복 횟수를 제거하고 새로 추가합니다.
    - 기록된 문자와 현재 문자가 다르다면 StringBuilder에 현재 문자를 추가합니다.
      - 문자가 다르다는 것은 반복되지 않는 문자이므로 바로 StringBuilder에 추가하고, 반복 횟수와 비교할 문자를 초기화 합니다.
    - 문자열을 끝까지 처리한 후, StringBuilder를 반환합니다.


- **코드**
```java
import java.util.Scanner;

public class Day9_StringCompress {
  public static void main(String[] args) {
    Day9_StringCompress T = new Day9_StringCompress();
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    System.out.println(T.solution(input));
  }

  public StringBuilder solution(String str) {
    StringBuilder answer = new StringBuilder();

    int cnt = 1;
    char chkC = 0;
    for (char c : str.toCharArray()) {
      if (c == chkC) {
        if (cnt != 1) answer.deleteCharAt(answer.length() - 1);
        answer.append(++cnt);
      } else {
        answer.append(c);
        cnt = 1;
        chkC = c;
      }
    }

    return answer;
  }
}

```


- **사용한 API 정리**
    - StringBuilder.deleteCharAt();
      - deleteCharAt 클래스에서 제공하는 메서드로 문자열에서 특정 인덱스에 있는 단일 문자를 삭제하는 메서드입니다. 
