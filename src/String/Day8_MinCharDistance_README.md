# String(문자열)
## 문제10. 가장 짧은 문자거리

- **문제**
  - **설명**  
    한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

  - **입력**  
    첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
    문자열의 길이는 100을 넘지 않는다.
  - **출력**
    첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.


- **풀이 과정**
    - 문자열과 문자를 입력받습니다.
    - 문자의 처음부터 끝까지 반복문을 돌면서 문자열의 0번째 인덱스부터 값을 채워나갑니다.
      - 주어진 문자가 나오기 전까지는 임의의 숫자 (dis = 1000)을 넣어줍니다.
      - 주어진 문자가 나온 후 dis를 0으로 지정합니다.
    - 한 인덱스에 값을 넣은 뒤 dis 값을 증가시킵니다.
    - 첫 번째 반복문이 종료된 후, 문자의 끝부터 처음까지 반복문을 다시 시작합니다.
    - 이미 배열에 담겨있는 값과, 뒤에서 부터 접근했을 때 가장 가까운 문자와의 거리를 비교해 더 짧은 거리를 대입해줍니다.
    - 반복문이 종료되면 배열에는 주어진 문자와 해당 문자의 최소거리가 담겨져 있습니다.

- **코드**
```java
import java.util.Scanner;

public class Day8_MinCharDistance {

  public static void main(String[] args) {
    Day8_MinCharDistance T = new Day8_MinCharDistance();
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    char t = sc.next().charAt(0);
    for ( int answer : T.solution(input, t)) {
      System.out.print(answer + " ");
    }
  }

  public int[] solution(String str, char t) {
    int[] intArr = new int[str.length()];

    int dis = 1000;
    for (int i = 0; i < str.length(); i++) {
      if(str.charAt(i) == t) dis = 0;
      intArr[i] = dis;
      count++;
    }

    for (int i = str.length() - 1; i > -1; i--) {
      if (str.charAt(i) == t) {
        dis = 0;
        dis++;
        continue;
      }
      intArr[i] = Math.min(intArr[i], dis);
      dis++;
    }
    return intArr;
  }
}
```


- **사용한 API 정리**
    - Math.min();
      - 파라미터로 전달 된 두 숫자 중 더 작은 값을 반환하는 메서드입니다.
