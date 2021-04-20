# Dynamic Programming

## 개념
wiki  

복잡한 문제를 간단한 여러 개의 문제로 나누어 푸는 방법을 말한다.  
이것은 부분 문제 반복과 최적 부분 구조를 가지고 있는 알고리즘을 일반적인 방법에 비해 더욱 적은 시간 내에 풀 때 사용한다.

일반적으로 주어진 문제를 풀기 위해서, 문제를 여러 개의 하위 문제(subproblem)로 나누어 푼 다음,  
그것을 결합하여 최종적인 목적에 도달하는 것이다. 

각 하위 문제의 해결을 계산한 뒤,  
그 해결책을 저장하여 후에 같은 하위 문제가 나왔을 경우 그것을 간단하게 해결할 수 있다.  
이러한 방법으로 동적 계획법은 계산 횟수를 줄일 수 있다.  
특히 이 방법은 하위 문제의 수가 기하급수적으로 증가할 때 유용하다.


## Check List
1. Problem -> Sub Problem 쪼개짐 
2. 점화식
3. Top-Down
4. Bottom-Up
5. Memoization
  - Sub Problem 결과 저장
  - 이미 해결한 Sub Problem 은 다시 하지 않기 위해



## 참고
1. Top-Down 방식을 Recursive로 풀때, call stack overflow 주의
2. 보통 Top-Down 보다는 Bottom-Up 이 space complexity가 더 좋음.


## 대표 문제

### 피보나치

![img](https://t1.daumcdn.net/cfile/tistory/99F5AB335BDD56E332)

![img](https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F267EC74E5702798727)

