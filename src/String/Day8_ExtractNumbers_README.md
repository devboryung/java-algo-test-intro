# String(문자열)
## 문제9. 숫자만 추출

- **문제**
  - **설명**  
    문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.  
    만약 “tge0a1h205er”에서 숫자만 추출하면 0, 1, 2, 0, 5이고 이것을 자연수를 만들면 1205이 됩니다.  
    추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.

  - **입력**  
    첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.
  - **출력**
    첫 줄에 자연수를 출력합니다.


- **풀이 과정**
    - 문자열을 입력받습니다.
    - 정규식을 이용해 주어진 문자열에서 숫자만 남긴 후 모두 제거합니다.
    - 숫자만 남은 문자열을 parseInt()를 사용해 int 타입으로 변환해서 반환합니다.

- **코드**
```java
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Day8_ExtractNumbers {

  public static void main(String[] args) {
    Day8_ExtractNumbers T = new Day8_ExtractNumbers();
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    System.out.println(T.solution(input));
  }

  public int solution(String str) {
    String input = str.replaceAll("[^0-9]", "");
    return parseInt(input);
  }
}

```


- **사용한 API 정리**
    - Integer.parseInt();
      - 문자열을 정수로 변환할 때 사용하는 메서드입니다.
      - 숫자 앞의 0을 무시하고 올바른 숫자만 반환합니다.
