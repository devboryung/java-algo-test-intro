# String(문자열)
## 문제5. 특정 문자 뒤집기

- **문제**
  - **설명**  
    영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,  
    특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

  - **입력**  
    첫 줄에 길이가 100을 넘지 않는 문자열이 주어집니다.
  - **출력**
    첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.


- **풀이 과정**
    - 단어를 입력받습니다.
    - 원하는 문자의 위치를 바꾸기 위해 문자를 배열로 바꿉니다.
    - 오른쪽과 왼쪽에서 동시에 탐색하며 알파벳이 맞는지 확인합니다.
      - 오른쪽은 해당 문자가 알파벳이 아닌 경우 인덱스를 1씩 증가시켜 오른쪽 문자를 탐색하도록 합니다.
      - 왼쪽은 해당 문자가 알파벳이 아닌 경우 인덱스를 1씩 감소시켜 왼쪽 문자를 탐색하도록 합니다.
    - 오른쪽과 왼쪽 문자를 바꾸기 위해 임시 변수인 temp를 선언해 한 문자를 담아둡니다.
    - 서로 값을 바꿔줍니다. 값을 바꾼 후 다음 문자를 비교하기 위해 오른쪽은 1 증가, 왼쪽은 1 감소를 합니다.
    - 오른쪽이 왼쪽보다 커진 경우 이미 왼쪽에서 탐색이 완료된 문자이기 때문에 비교하면 안되니 반복문을 종료합니다.
      - 오른쪽과 왼쪽이 같은 경우 동일한 문자이기 때문에 비교가 필요 없습니다.
- **코드**
```java
import java.util.Scanner;

public class Day4_TargetCharReverser {

    public static void main(String[] args) {
        Day4_TargetCharReverser T = new Day4_TargetCharReverser();
        Scanner sc = new Scanner(System.in);
        String word = sc.next();

        System.out.println(T.solution(word));
    }

    public String solution(String str) {
        char[] chArr = str.toCharArray();
        int first = 0;
        int last = str.length() - 1;
        
        while (first < last) {
            if (!Character.isLetter(chArr[first])) {
                first++;
            } else if (!Character.isLetter(chArr[last])) {
                last--;
            } else {
                char temp = chArr[first];
                chArr[first] = chArr[last];
                chArr[last] = temp;
                first++;
                last--;
            }
         }
        return String.valueOf(chArr);
    }
}
```


- **사용한 API 정리**
    - Character.isLetter();
      - Character 클래스가 제공하는 메서드로 파라미터로 전달된 문자가 알파벳인지 여부를 확인합니다. 
      - **숫자나 특수문자를 제외한 유니코드에서 문자로 정의된 대소문자 영어 알파벳 외 기타 언어의 문자도 포함해서 인정합니다.**
      - **Character.isAlphabetic()** : 유니코드에서 알파벳 문자로 정의된 문자만 포함합니다. 이 문제는 알파벳만 확인하는 것이었기 때문에 이 메서드가 더 적합한 것 같습니다.