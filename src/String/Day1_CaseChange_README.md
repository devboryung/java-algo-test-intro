# String(문자열)
## 문제2. 대소문자 변환

- **문제**
  - **설명**  
    대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.
  - **입력**  
    첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.  
    문자열은 영어 알파벳으로만 구성되어 있습니다.
  - **출력**  
    첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않습니다.

    
- **풀이 과정**
    - 문자열을 입력받습니다.
    - 입력된 문자의 대소문자를 구분하기 위해 문자열을 문자로 바꿉니다.
    - 반복문을 이용해 문자열에 입력된 문자를 하나씩 가져옵니다.
    - 문자 타입은 **아스키코드**를 이용해 숫자로 표현할 수 있습니다. 해당 문자가 대문자인지 소문자인지 아스키 코드를 통해 구분합니다.
      - A-Z : 65 ~ 90  
      - a-z : 97 ~ 122
      - 알파벳의 아스키코드를 모를 때는 콘솔창에 출력해서 확인할 수 있습니다. **System.out.println((int)char)**
    - 대소문자를 구분한 후 대문자는 소문자로, 소문자는 대문자로 바꾸어줍니다.
    - 마지막으로 교체된 문자를 문자열로 바꿔서 반환합니다.

    
- **코드**
```java
import java.util.Scanner;

public class Day1_CaseChange {
    public static void main(String[] args) {
        Day1_CaseChange caseChange = new Day1_CaseChange();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        System.out.println(caseChange.Solution(str));
    }

    public String Solution(String str) {
        char[] chArr = str.toCharArray();
        for (int i = 0; i < chArr.length; i ++) {
            if (chArr[i] >= 65 && chArr[i] <= 90) {
                chArr[i] = Character.toLowerCase(chArr[i]);
            } else if (chArr[i] >= 97 && chArr[i] <= 122) {
                chArr[i] = Character.toUpperCase(chArr[i]);
            }
        }
        return String.valueOf(chArr);
    }
}
```

- **시간 복잡도**
    - 해당 코드의 시간 복잡도는 O(n)입니다.
    - for 루프에서 배열을 순차적으로 탐색합니다. 배열은 주어진 문자열의 길이와 동일합니다.  
      문자열 혹은 배열의 크기만큼 루프가 몇 번 반복하는에 따라 시간 복잡도가 정해지기 때문에 O(n)입니다.


- **사용한 API 정리**
    - String.valueOf();
      - 해당 메서드는 특정 타입의 값 문자열로 바꿔주는 자바의 메서드입니다.