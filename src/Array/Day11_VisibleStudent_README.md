# Array(1,2차원 배열)
## 문제2. 보이는 학생

- **문제**
  - **설명**  
    선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.  
    (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)
  - **입력**  
    첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.
  - **출력**  
    선생님이 볼 수 있는 최대학생수를 출력한다.



- **풀이 과정**
    - 정수를 입력받습니다.
    - 입력된 정수만큼 정수를 입력받아 int 배열에 담습니다.
    - 최장신을 담을 변수 max를 선언하고 첫 번째 학생의 키를 담습니다.
    - 보이는 학생의 수를 계산할 count 변수를 선언하고, 1로 초기화합니다.
      - 첫 번째 학생은 무조건 보이기 때문입니다.
    - 반복문을 이용해 학생들의 키를 순차적으로 탐색해, 각 학생의 카와 이전 학생들 중 최장신을 비교합니다.
      - 크면 최장신을 현재 학생의 키로 갱신하고, count를 1 증가시킵니다.
    - 반복문이 종료된 후 count를 반환합니다.

- **코드**
```java
import java.util.Scanner;

public class Day11_VisibleStudent {

  public static void main(String[] args)
  {
    Day11_VisibleStudent T = new Day11_VisibleStudent();
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] heightArr = new int[num];
    for (int i = 0; i < num; i++) {
      heightArr[i] = sc.nextInt();
    }

    System.out.println(T.solution(num, heightArr));
  }

  public int solution(int n, int[] nArr) {

    //최장신 담는 변수
    int max = nArr[0];
    //첫번째 학생은 무조건 보이므로 1로 초기화.
    int count = 1;
    for (int i = 1; i < n; i++) {
      if (max < nArr[i]) {
        max = nArr[i];
        count++;
      }
    }

    return count;
  }
}

```
