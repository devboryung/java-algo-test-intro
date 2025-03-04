# Array(1,2차원 배열)
## 문제5. 소수(에라토스테네스 체)

- **문제**
  - **설명**  
    자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
    만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.
  - **입력**  
    첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.
  - **출력**  
    첫 줄에 소수의 개수를 출력합니다.



- **풀이 과정**
    - 정수를 입력받습니다.
    - 아레토스테네스 체 알고리즘을 사용해 소수를 구합니다.
    - int 배열을 생성합니다. int 배열은 초기화하지 않으면 자동으로 0으로 초기화되기 때문에 0을 소수로 판단합니다.
    - 반복문을 이용해 배열에 담긴 값이 소수인지 판단합니다.
    - 1은 소수가 아니기 때문에 반복문은 2부터 시작합니다. 
    - 배열에 담긴 값이 0이면 소수이기 때문에  count 값을 증가시켜주고, 해당 값의 배수를 찾아 1로 설정합니다.
      - i의 배수는 소수가 아니기 때문에 1로 셋팅해줘서 소수가 아닌 숫자들로 구분됩니다.
    - 모든 배열을 순회한 후, count를 반환합니다.

  
- **코드**
```java
package Array;

import java.util.Scanner;

public class Day13_PrimeNumber {
  public static void main(String[] args) {
    Day13_PrimeNumber T = new Day13_PrimeNumber();
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    System.out.println(T.solution(num));
  }

  public int solution(int num) {
    int[] arr = new int[num + 1];
    int count = 0;

    for (int i = 2; i <= num; i++) {
      if (arr[i] == 0) {
        //0은 소수로 판단. count를 증가시킨다.
        count++;
        //i의 배수는 소수가 아니기 때문에 1로 셋팅한다.
        for (int j = i; j <= num; j += i) {
          arr[j] = 1;
        }
      }
    }

    return count;
  }
}
```
