# 소수

1과 자기 자신만을 약수로 갖는 수

## 소수 판별

Ref : https://myjamong.tistory.com/139

### 방법 1

해당 숫자의 √N 까지 확인하는 방법이다. 이 원리는 약수의 중심을 구하는 방법이다.  
예를들어 80의 약수는 아래와 같다.

```
1, 2, 4, 5, 8, 10, 16, 20, 40, 80
```

각 숫자들의 곱이 80이되는 쌍을 같은 색으로 표시했다.   
1:80, 2:40, 4:20, 5:16, 8:10. √80의 값은 대략 8.xxx의 값이 나온다.

즉 약수들의 곱으로 봤을때 루트를 씌운 값이 중간값이 된다.

이 원리는 이용하여 2에서부터 √N의 값까지 검색을 한다며 이후의 값은 확인할 필요가 없게 된고 시간복잡도는 O(√N)이 된다.   
코드의 가독성을 위해 루트함수는 사용하지 않고 i의 제곱값으로 확인을 한다.

```java
public class 소수_판별 {
    public boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}
```

<br/><br/><br/>

### 방법2. 에라토스테네스의 체

- 대량의 소수를 한꺼번에 판별하고자 할 때 사용  
- 찾은 소수의 배수를 지워나간다.

1. 입력 받은 수까지 수들을 나열
2. 2부터 시작하여 현재 수의 배수들을 지워나감(아래에서는 flag 변경)


![img](https://upload.wikimedia.org/wikipedia/commons/b/b9/Sieve_of_Eratosthenes_animation.gif)

[링크](https://ko.wikipedia.org/wiki/%EC%97%90%EB%9D%BC%ED%86%A0%EC%8A%A4%ED%85%8C%EB%84%A4%EC%8A%A4%EC%9D%98_%EC%B2%B4)

```java
public class Eratos {
    public static void main(String[] args) {
        
        // ArrayList로 구현
        ArrayList<Boolean> primeList;

        // 사용자로부터의 콘솔 입력
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        // n <= 1 일 때 종료
        if (n <= 1) return;

        // n+1만큼 할당
        primeList = new ArrayList<Boolean>(n + 1);
        
        // 0번째와 1번째를 소수 아님으로 처리
        primeList.add(false);
        primeList.add(false);
        
        // 2~ n 까지 소수로 설정
        for (int i = 2; i <= n; i++)
            primeList.add(i, true);

        // 2 부터  ~ i*i <= n
        // 각각의 배수들을 지워간다.
        for (int i = 2; (i * i) <= n; i++) {
            if (primeList.get(i)) {
                for (int j = i * i; j <= n; j += i) 
                    primeList.set(j, false);
                //i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
            }
        }
        
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for (int i = 0; i <= n; i++) {
            if (primeList.get(i) == true) {
                sb.append(i);
                sb.append(",");
            }
        }
        sb.setCharAt(sb.length() - 1, '}');

        System.out.println(sb.toString());
    }
}
```