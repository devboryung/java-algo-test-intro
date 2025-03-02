# Array(1,2차원 배열)
## 문제3. 가위 바위 보

- **문제**
  - **설명**  
    A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.  
    가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다.
    예를 들어 N=5이면
    
    | 회수    | 1 | 2 | 3 | 4 | 5 | 
    |-------|---|---|---|---|---|
    | A의 정보 | 2 | 3 | 3 | 1 | 3 |
    | B의 정보 | 1 | 1 | 2 | 2 | 3 |
    | 승자    | A | B | A | B | D |
    두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요.
  - **입력**  
    첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
    두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.  
    세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.
  - **출력**  
    각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.



- **풀이 과정**
    - 정수를 입력받습니다.
    - 입력된 정수만큼 A와 B의 게임 정보를 받습니다.
      - A와 B의 게임 정보는 각각 반복문을 두 번 사용해 입력받습니다.
    - A와 B의 게임 정보를 이용해 각 회의 결과를 String[]에 저장합니다.
      - A와 B가 같을 경우 "D"를 반환하고, B가 이기는 조건에는 "B", 모두 아닐 경우 "A"를 반환합니다.

- **코드**
```java
import java.util.Scanner;

public class Day11_RPS {
  public static void main(String[] args) {
    Day11_RPS T = new Day11_RPS();
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] gameA = new int[num];
    int[] gameB = new int[num];

    for(int i = 0; i < num; i++) {
      gameA[i] = sc.nextInt();
    }
    for(int i = 0; i < num; i++) {
      gameB[i] = sc.nextInt();
    }

    for (String s : T.solution(num, gameA, gameB)) {
      System.out.println(s);
    }

  }

  public String[] solution(int n, int[] a, int[] b) {

    String[] answer = new String[n];
    for (int i = 0; i < n; i++) {
      if (a[i] == b[i]) answer[i] = "D";
      else if (a[i] == 1 && b[i] == 2) answer[i] = "B";
      else if (a[i] == 2 && b[i] == 3) answer[i] = "B";
      else if (a[i] == 3 && b[i] == 1) answer[i] = "B";
      else answer[i] = "A";
    }
    return answer;
  }
}
```
