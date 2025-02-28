# String(문자열)
## 문제12. 암호

- **문제**
  - **설명**  
    현수는 영희에게 알파벳 대문자로 구성된 비밀편지를 매일 컴퓨터를 이용해 보냅니다.  
    비밀편지는 현수와 영희가 서로 약속한 암호로 구성되어 있습니다.  
    비밀편지는 알파벳 한 문자마다 # 또는 *이 일곱 개로 구성되어 있습니다.  
    만약 현수가 “#*****#”으로 구성된 문자를 보냈다면 영희는 현수와 약속한 규칙대로 다음과 같이 해석합니다.  
    1. “#*****#”를 일곱자리의 이진수로 바꿉니다. #은 이진수의 1로, *이진수의 0으로 변환합니다. 결과는 “1000001”로 변환됩니다.  
    2. 바뀐 2진수를 10진수화 합니다. “1000001”을 10진수화 하면 65가 됩니다.  
    3. 아스키 번호가 65문자로 변환합니다. 즉 아스크번호 65는 대문자 'A'입니다.  

    참고로 대문자들의 아스키 번호는 'A'는 65번, ‘B'는 66번, ’C'는 67번 등 차례대로 1씩 증가하여 ‘Z'는 90번입니다.  
    현수가 4개의 문자를 다음과 같이 신호로 보냈다면  
    #\*\*\*\*###\*\*#####\*\*#####\*\*##\*\*  
    이 신호를 4개의 문자신호로 구분하면  
    #\*\*\*\*## --> 'C'  
    #\*\*#### --> 'O'  
    #\*\*#### --> 'O'  
    #\*\*##\*\* --> 'L'  
    최종적으로 “COOL"로 해석됩니다.  
    현수가 보낸 신호를 해석해주는 프로그램을 작성해서 영희를 도와주세요.
  - **입력**  
    첫 줄에는 보낸 문자의 개수(10을 넘지 안습니다)가 입력된다. 다음 줄에는 문자의 개수의 일곱 배 만큼의 #또는 \* 신호가 입력됩니다.  
    현수는 항상 대문자로 해석할 수 있는 신호를 보낸다고 가정합니다.
  - **출력**  
    영희가 해석한 문자열을 출력합니다.


- **풀이 과정**
    - 문자의 개수와 신호를 입력받습니다.
      - 신호는 문자의 개수의 일곱 배 만큼이기 때문에 메서드로 넘길 때 문자의 개수 * 7만 넘깁니다.
    - 입력된 문자열을 7개씩 잘라서 2진수로 바꿉니다.
      - substring을 이용해 7개씩 자릅니다.
      - 자른 문자열의 '#'는 '1'로 '*'는 '0'으로 변환합니다.
    - 2진수를 10진수로 변환합니다.
    - 변환된 10진수는 char 타입으로 바꿔 반환 문자열에 추가합니다.
    - 주어진 문자열을 모두 char 타입으로 바꾼 뒤 StringBuilder를 반환합니다.


- **코드**
```java
import java.util.Scanner;

public class Day9_Password {

    public static void main(String[] args) {
        Day9_Password T = new Day9_Password();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String symbol = sc.next();
        System.out.println(T.solution(num, symbol.substring(0, num * 7)));
    }

    public StringBuilder solution(int n, String str) {
        StringBuilder answer = new StringBuilder();

        
        int start = 0;
        for (int i = 0; i < n; i++) {
            //입력된 문자열을 7개씩 자름
            String bin = str.substring(start, start + 7).replace('#', '1').replace('*','0');
            start += 7;

            //2진수를 10진수로 변환
            int decimal = 0;
            for (int j = 0; j < bin.length(); j++) {
                if (bin.charAt(j) != '0') decimal += (int) Math.pow(2, 6 - j);
            }
            answer.append((char) decimal);
        }

        return answer;
    }
}
```


- **사용한 API 정리**
    - Math.pow();
      - 거듭제곱을 계산하는 메서드로, 첫 번째 인수를 두 번째 인수만큼 거듭제곱한 값을 반환합니다.


    
**!주의**
- 작성된 코드에서는 문자열을 7개씩 자르는 for문 안에서 잘라진 문자열을 10진수를 바꾸는 for문을 중첩으로 사용하고 있다.  
  자바 메서드인 **Integer.parseInt(bin, 2);** 를 사용하여 for문을 사용하지 않고 더 간단하게 2진수를 10진수로 바꿀 수 있다.  
  Integer.parseInt()는 주어진 문자열을 기본적으로 10진수로 파싱하여 정수로 반환하는 함수이며, Integer.parseInt(bin, 2);로 해당 문자열이 2진수라는 것을 명시할 수 있다.  


- **코드**
```java
import java.util.Scanner;

public class Day9_Password {

    public static void main(String[] args) {
        Day9_Password T = new Day9_Password();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String symbol = sc.next();
        System.out.println(T.solution(num, symbol.substring(0, num * 7)));
    }

    public StringBuilder solution(int n, String str) {
        StringBuilder answer = new StringBuilder();

        
        int start = 0;
        for (int i = 0; i < n; i++) {
            //입력된 문자열을 7개씩 자름
            String bin = str.substring(start, start + 7).replace('#', '1').replace('*','0');
            start += 7;

            //2진수를 10진수로 변환
            int decimal = Integer.parseInt(bin, 2);
            answer.append((char) decimal);
        }

        return answer;
    }
}

```