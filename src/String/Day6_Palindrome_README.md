# String(문자열)
## 문제7. 회문 문자열

- **문제**
  - **설명**  
    앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.  
    문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력하는 프로그램을 작성하세요.  
    단 회문을 검사할 때 대소문자를 구분하지 않습니다.

  - **입력**  
    첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.
  - **출력**
    첫 번째 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.


- **풀이 과정**
    - 문자열을 입력받습니다.
    - 주어진 문자열을 배열로 변환합니다. 대소문자를 구분하지 않기 위해 입력 값을 모두 소문자로 변경합니다.
    - 새로운 배열을 만들어 동일하게 소문자로 변경하여 입력 값을 대입한 후, List의 reverse() 메서드를 이용해 쉽게 문자열을 뒤집습니다.
    - 일반 배열의 값과 뒤집힌 List의 값을 다른 값이 나올 경우 "NO"를 반환하고, 모두 같다면 "YES"를 반환합니다. 


- **코드**
```java
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day6_Palindrome {

    public static void main(String[] args) {
        Day6_Palindrome T = new Day6_Palindrome();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        String[] inputArr = str.toLowerCase().split("");
        String[] reverseArr = str.toLowerCase().split("");
        List<String> reverseList = Arrays.asList(reverseArr);
        Collections.reverse(reverseList);

        int length = inputArr.length;
        for (int i = 0; i < length; i++) {
            if (!inputArr[i].equals(reverseList.get(i))) return "NO";
        }

        return "YES";
    }
}
```


- **사용한 API 정리**
    - Arrays.asList();
      - 매개변수로 전달된 배열을 List 객체로 변환하는 메서드입니다.
      - 이때, 새로운 List 객체를 생성하는 것이 아니라 원본 배열의 주소를 참조하는 방식으로 사용되기 때문에 리스트와 원본 배열은 연결된 상태입니다.
    - Collections.reverse();
      - 리스트에 담긴 값을 반대로 뒤집어 주는 메서드입니다.
      - 원본 리스트를 직접 수정하는 것이기 때문에 변경이 가능한 리스트에만 사용할 수 있습니다.



**! 주의** 
- Array.asList();로 변횐된 List객체는 원본 배열과 연결되어 있기 때문에 해당 List를 reverse 시키면 원본 배열까지 reverse 됩니다. 그렇기 때문에 원본 배열이 아닌 제 2의 배열을 생성해 reverse 후 비교를 진행해야 합니다.


### 수업에서 배운 것
- **코드**
```java
    public String solution(String str) {
    char[] array = str.toLowerCase().toCharArray();
    int length = array.length;
    for (int i = 0; i < length / 2; i++) {
        if (array[i] != array[length - 1 - i]) return "NO";
    }
    return "YES";
}
```
- **배운점**
  - 입력된 문자열을 배열로 만들 때 String 대신 char 배열로 만드는 것이 메모리를 아낄 수 있다.  
    Split("")은 각 문자마다 새로은 String 객체를 만들어 String[]에 저장하기 때문에 메모리와 성능면에서 비효율 적이다.  
    toCharArray()는 문자열을 한 번만 순회해서 char[]로 만들기 때문에 훨씬 효율적이다.
  - 순서가 바뀐 배열을 한 쌍 더 만드는 것이 아니라 하나의 배열을 가지고 첫번째 단어와 마지막 단어를 비교해가며 해당 단어가 회문 문자열인지 확인할 수 있다.
    반복 순서도 문자의 길이만큼 비교할 필요 없이 문자 길이의 절반만 비교하면 된다.