# Array(1,2차원 배열)
## 문제4. 피보나치 수열

- **문제**
  - **설명**  
    1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
    2) 입력은 피보나치 수열의 총 항의 수이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
  - **입력**  
    첫 줄에 총 항수 N(3<=N<=45)이 입력된다.
  - **출력**  
    첫 줄에 피보나치 수열을 출력합니다.



- **풀이 과정**
    - 정수를 입력받습니다.
    - 입력된 정수만틈 피보나치 수열의 값을 계산합니다.
    - 피보나치 수열은 각 항이 이전 두 항의 합으로 이루어지기 때문에, 배열의 0번째와 1번째 인덱스를 1로 초기화 후 반복문을 이용해 2번째 인덱스부터 차례대로 값을 계산해 채워줍니다.

- **코드**
```java
import java.util.Scanner;

public class Day12_FibonacciSequence {
  public static void main(String[] args) {
    Day12_FibonacciSequence T = new Day12_FibonacciSequence();
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    for (int answer : T.solution(num)) {
      System.out.print(answer + " ");
    }
  }

  public int[] solution(int n) {
    int[] answer = new int[n];

    answer[0] = 1;
    answer[1] = 1;
    for (int i = 2; i < n; i++) {
      answer[i] = answer[i - 1] + answer[i - 2];
    }

    return answer;
  }
}
```
