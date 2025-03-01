# Array(1,2차원 배열)
## 문제1. 큰 수 출력하기

- **문제**
  - **설명**  
    N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
    (첫 번째 수는 무조건 출력한다)
  - **입력**  
    첫 줄에 자연수 N(1<=N<=100)이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.
  - **출력**  
    첫 줄에 압축된 문자열을 출력한다.



- **풀이 과정**
    - 정수를 입력받습니다.
    - 입력된 정수만큼 정수를 입력받아 int 배열에 담습니다.
    - StringBuilder 객체를 생성 해 int 배열의 첫 번째 값을 담습니다. (첫 번째 수는 무조건 출력하는 조건.)
      - 출력 시 값 사이에 공백을 넣어주기 위해 " "를 추가합니다.
    - 앞의 수를 확인하기 위한 변수 num을 선언 후, 비교할 값을 넣습니다.
    - 반복문을 돌며 비교할 숫자(앞의 값)와 int의 1번째 값을 비교 후 배열에 담긴 값이 더 크면 StringBuilder 객체에 추가합니다.
    - 반복문을 종료한 후 StringBuilder를 반환합니다.


- **코드**
```java
import java.util.ArrayList;
import java.util.Scanner;

public class Day10_PrintBigNum {
    public static void main(String[] args) {
        Day10_PrintBigNum T = new Day10_PrintBigNum();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] numArr = new int[num];
        for (int i = 0; i < num; i++) {
            numArr[i] = sc.nextInt();
        }
        System.out.println(T.solution(numArr));
    }

    public StringBuilder solution(int[] nArr) {
        StringBuilder answer = new StringBuilder();
        int num = nArr[0];
        answer.append(num).append(" ");
        for (int i = 1; i <= nArr.length - 1; i++) {
            if (num < nArr[i]) {
                answer.append(nArr[i]).append(" ");
            }
            num = nArr[i];
        }
        return answer;
    }
}
```

<br><br>


- **강의 코드**
```java
import java.util.ArrayList;
import java.util.Scanner;

public class Day10_PrintBigNum {
    public static void main(String[] args) {
        Day10_PrintBigNum T = new Day10_PrintBigNum();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] numArr = new int[num];
        for (int i = 0; i < num; i++) {
            numArr[i] = sc.nextInt();
        }
        for (int x : T.solution(num, numArr)) {
            System.out.print(x + " ");
        }
    }

    public ArrayList<Integer> solution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) answer.add(arr[i]);
        }
        return answer;
    }
}
```

- **!실수**
  1. 이제 String 챕터가 끝나고 Array 챕터가 시작되었는데, 반환값을 String으로만 생각했다.
  2. 반환값이 정수형이기 때문에 굳이 문자열로 출력할 필요가 없다.
  2. int[]를 넘겨받았고, 앞의 값과 뒤의 값을 비교할 때 굳이 변수에 담을 필요 없이 int[i]와 int[i-1]를 비교하는 것이 훨씬 효율적이다.