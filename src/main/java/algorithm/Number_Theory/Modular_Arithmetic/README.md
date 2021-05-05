# 모듈러 연산

모듈러 연산이란 ?

모듈러 연산은 합동식이라고도 하며

A≡B (mod m)라고 쓰고
m｜(A-B)라는 뜻이다.

즉 A를 m으로 나누었을 경우 나머지가 B라는 소리이다.

다른 표현으로는

(A-B) = km, A = B + km (k는 정수) 등이 있다.

모듈러 연산 성질
A ≡ B (mod m) , C ≡ D (mod m)이면

1. A±C≡ B±D (mod m)이다.
2.  AC ≡ BD (mod m)이다.
3. AC ≡ BC (mod m) 이다. (C는 정수)
4. Aⁿ ≡ Bⁿ (mod m) 이다. (n은 자연수)



## 유클리드 호제법


## 모듈러 합동(Congruence Modulo)
https://www.crocus.co.kr/1231

(a mod n) = (b mod n)  -> a ≡ b(mod n)
어떤 값 A와 B가 n으로 나누었을 때 나머지가 같다면 A와 B는 모듈 C에 대한 합동 관계라고 한다.
그러한 A와 B는 A - B를 하였을 때 k*n과 같다.
즉, A - B = kn으로 나타낼 수 있다.

3. 모듈러 연산의 속성
    1. (a + b) mod n = ((a mod n) + (b mod n)) mod n
    2. (a - b) mod n = ((a mod n) - (b mod n)) mod n

** 알아두기 **
((a mod n) - (b mod n)) mod n에서 a = 3, b = 5, n = 6이면 -2 mod 6 = -2가 나온다.
이때 '-' 연산을 이용할 때 mod를 쓰는 일이 있다면 ((a mod n) - (b mod n)) mod n + n을통해 양수로 만들어 줄 수 있다.

    3. (a * b) mod n = ((a mod n) * (b mod n)) mod n

## 모듈러 역원(Modular inverse)