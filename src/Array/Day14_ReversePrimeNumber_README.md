# Array(1,2차원 배열)
## 문제6. 뒤집은 소수

- **문제**
  - **설명**  
    N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.  
    예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.  
    첫 자리부터의 연속된 0은 무시한다.  
  - **입력**  
    첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
    각 자연수의 크기는 100,000를 넘지 않는다.
  - **출력**  
    첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.



- **풀이 과정**
    - 정수를 입력받습니다.
    - 입력된 정수만큼 숫자를 입력받아 int 배열에 저장합니다.
    - 전달받은 int 배열의 값을 뒤집어서 ArrayList에 저장합니다.
      - 어떤 숫자를 10으로 나눈 결과는 항상 그 값의 1의 자리 숫자입니다.
      - 1의 자리 숫자를 얻은 후 10을 나눠 마지막 자릿수를 제거한 뒤 값이 0이 될때까지 반복합니다.
    - ArrayList에 담긴 값이 소수인지 확인합니다.
      - 소수 여부를 판단하기 위해 소수가 아닐 경우 값을 0으로 수정합니다. 
      - 2보다 작을 경우 소수가 아니기 때문에 해당 위치의 값을 0으로 수정합니다.
      - 그 외의 경우, 2부터 반복하여 나눕니다. 나머지가 0인 경우 소수가 아니기 때문에 값을 0으로 수정합니다.
    - 모든 값을 확인한 후, ArrayList에 포함된 모든 0을 모두 제거합니다.
    - 수정된 ArrayList를 반환합니다.

  
- **코드**
```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day14_ReversePrimeNumber {

  public static void main(String[] args) {
    Day14_ReversePrimeNumber T = new Day14_ReversePrimeNumber();
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] nArr = new int[num];
    for (int i = 0; i < num; i++) {
      nArr[i] = sc.nextInt();
    }

    for(int answer : T.solution(nArr)) {
      System.out.print(answer + " ");
    }
  }

  public ArrayList<Integer> solution(int[] nArr) {
    ArrayList<Integer> arrList = new ArrayList<>();

    //숫자 뒤집기
    for (int i : nArr) {
      int num = i;
      int reverNum = 0;
      while (num != 0) {
        int ex = num % 10; //마지막 자릿수 추출
        reverNum = reverNum * 10 + ex;
        num /= 10; //마지막 자릿수 제거
      }
      arrList.add(reverNum);
    }

    //소수 확인
    for (int i = 0; i < arrList.size(); i++) {
      int num = arrList.get(i);
      if (num < 2) {
        arrList.set(i, 0);
      } else {
        boolean isPrime = true;
        for (int j = 2; j < num; j++) {
          if (num % j == 0) {
            isPrime = false;
            break;
          }
        }
        //소수가 아닐 경우 0으로 설정
        if (!isPrime) arrList.set(i, 0);
      }
    }

    //모든 0 지우기
    arrList.removeAll(Arrays.asList(0));
    return arrList;
  }
}
```


- **사용한 API 정리**
  - ArrayList.removeAll();
    - ArrayList에 있는 특정 요소들을 모두 제거하는 메서드입니다.
    - 매개변수로 컬렉션을 넘겨줘야 합니다. 전달된 컬렉션에 포함된 모든 요소를 제거합니다.
  - Arrays.asList();
    - 배열을 List로 변환하는 메서드입니다.
    - Arrays.asList(0);는 0하나를 요소로 갖는 List를 생성합니다.