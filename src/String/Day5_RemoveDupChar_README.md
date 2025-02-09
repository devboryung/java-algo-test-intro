# String(문자열)
## 문제6. 중복 문자 제거

- **문제**
  - **설명**  
    소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.  
    중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.

  - **입력**  
    첫 줄에 문자열이 입력됩니다. 문자열의 길이는 100을 넘지 않는다.
  - **출력**
    첫 줄에 중복문자가 제거된 문자열을 출력합니다.


- **풀이 과정**
    - 문자열을 입력받습니다.
    - 중복되지 않을 문자를 담을 ArrayList를 만듭니다.
      - 배열을 사용하지 않은 이유는 중복되지 않는 문자가 몇 개인지 모르는 상태이기 때문에, 배열 크기를 알 수 없기 때문입니다.  
        임의로 배열의 크기를 지정했을 때 생성된 배열의 크기보다 중복되지 않은 문자가 적을 경우 메모리의 낭비가 발생하고, 많을 경우 동적으로 확장해야 됩니다.
      - ArrayList는 요소가 추가될 때 마다 자동으로 배열의 크기를 확장할 수 있기 때문에 메모리 낭비를 줄일 수 있습니다.
      - 또한, ArrayList가 제공하는 contains() 메서드를 사용하면, 쉽게 ArrayList에 담긴 문자의 중복 체크를 할 수 있습니다.
    - contains() 메서드를 통해 문자의 중복 여부를 판단합니다. 중복된다면 다른 문자를 탐색하고, 중복이 아니라면 ArrayList에 추가합니다.
    - 모든 문자를 체크한 뒤, String.join()메서드를 이용해 ArrayList에 담긴 문자를 결합하여 문자열을 반환합니다.


- **코드**
```java
import java.util.ArrayList;
import java.util.Scanner;

public class Day5_RemoveDupChar {

    public static void main(String[] args) {
        Day5_RemoveDupChar T = new Day5_RemoveDupChar();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }

    public String solution(String str) {
        ArrayList<String> strList = new ArrayList<>();
        for (String s : str.split("")) {
            if(strList.contains(s)) continue;
            strList.add(s);
        }

        return String.join("", strList);
    }
}
```


- **사용한 API 정리**
    - ArrayList.contains();
      - 파라미터로 전달된 객체가 ArrayList에 포함되었는지 확인하는 메서드입니다.
      - 객체가 포함되었을 경우 true를 반환하고, 포함되지 않을 경우 false를 반환합니다.
    - String.join();
      - 파라미터로 전달된 배열이나 컬렉션에 있는 문자열을 구분로 결합해 주는 메서드입니다.
      - 구분자를 ""로 지정하면 구분자 없이 전달된 값이 결합됩니다.