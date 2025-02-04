# String(문자열)
## 문제3. 문장 속 단어

- **문제**
  - **설명**  
    한 개의 문장이 주어지면 그 문장 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.  
    문장속의 각 단어는 공백으로 구분됩니다.
  - **입력**  
    첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.
  - **출력**  
    첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 답으로 합니다.


- **풀이 과정**
    - 문자열을 입력받습니다.
    - 입력된 단어를 구하기 위해 공백으로 문자열을 나눕니다. 
    - 각 단어를 비교하기 전에 비교 기준이 되는 단어를 따로 빼둡니다. (첫 번째 단어로 정함.)
    - 단어와 단어를 비교합니다. 
      - 1. 기준이 되는 첫 번째 단어의 길이와 두 번째 단어의 길이를 비교합니다.
        1. 기준 단어가 두 번째 단어보다 짧다면 기준 단어를 두 번째 단어로 교체합니다.
        2. 기준 단어가 두 번째 단어보다 길다면 기준 단어를 유지합니다.
        3. 길이가 동일한 긴 단어가 여러 개일 경우 가장 앞쪽에 위치한 단어를 답으로 하기 위해 기준 단어를 유지합니다. 
    - 마지막 단어까지 비교 후 기준 단어에 들어있는 단어를 반환합니다.
    
- **코드**
```java
import java.util.Scanner;

public class Day2_WordsInSentence {
    public static void main(String[] args) {
        Day2_WordsInSentence T = new Day2_WordsInSentence();
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();

        System.out.println(T.Solution(sentence));
    }

    public String Solution(String str) {
        String[] strArr = str.split(" ");
        String words = strArr[0];
        for (int i = 1; i < strArr.length; i++) {
            if (words.length() >= strArr[i].length()) continue;
            words = strArr[i];
        }
        return words;
    }
}
```

- **시간 복잡도**
    - 해당 코드의 시간 복잡도는 O(n)입니다.
    - for 루프에서 배열을 순차적으로 탐색합니다. 배열은 주어진 문자열의 길이와 동일합니다.  
      문자열 혹은 배열의 크기만큼 루프가 몇 번 반복하는에 따라 시간 복잡도가 정해지기 때문에 O(n)입니다.


- **사용한 API 정리**
    - String.split();
      - 문자를 자를 때 사용하는 메서드입니다.
      - split() 파라미터로 구분자를 넣으면 구분자를 기준으로 문자열을 나눕니다.

- **실수**
  - str.split(" ");으로 주어진 문자열을 공백으로 잘랐는데 배열의 길이가 1이 나오고, 첫 번째 단어만 들어가 있었다.  
    공백 구분자가 잘못된 줄 알고 split()을 중점적으로 확인했는데 알고 보니 문자열을 입력받는 코드를 sc.next();로 적어서 단어 구분자인 공백을 만나 입력이 제대로 되지 않았던 거였다.  
    너무 어이없는 실수를 했다.
    - sc.next() : 공백 혹은 엔터 전까지의 문자열을 반환받는다.
    - sc.nextLine() : 엔터 전까지의 문자열을 반환받는다.