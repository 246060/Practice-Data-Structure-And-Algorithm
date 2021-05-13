
# 문자열 관련 알고리즘

## 패턴 매칭
- Boyer-Moore(보이어 무어) : 보통 O(n) 보다 적음, 최악 O(nm)
  - 최우선 고려 대상
  - 성능 좋음.
- 라빈 카프 : O(n)
  - 해시함수를 이용한 알고리즘
  - 구현이 쉽다.
- KMP : O(n+m)

## 보이어-무어
- https://www.youtube.com/watch?v=mXQtunIEo0k&t=493s
- https://greatzzo.tistory.com/8
- http://www.cs.emory.edu/~cheung/Courses/253/Syllabus/Text/Matching-Boyer-Moore1.html
- http://www.cs.emory.edu/~cheung/Courses/253/Syllabus/Text/Matching-Boyer-Moore2.html
- https://www.geeksforgeeks.org/boyer-moore-algorithm-good-suffix-heuristic/
- https://iq.opengenus.org/boyer-moore-string-search-algorithm/
  
- 패턴의 오른쪽부터 비교하여 텍스트 문자를 모두 비교하지 않아도 탐색이 가능한 알고리즘
- 문자열 패턴과 문자열을 비교시 문자열의 가장 뒷부분 위치를 비교, 
다르면 일정 길이만큼 이동하여 비교를 계속하는 기법

- 착한 접미부 이동(Good Suffix Method)와 나쁜문자 이동(Bad Character Method) 활용
- 현재 대부분의 워드프로세스 "검색" 기능에서 사용되고 있음.
  
### Boyer-Moore 종류
1. (complete or original) Boyer-Moore algorithm
  - two heuristics
    - bad-character heuristic
    - good-suffix heuristic
      (good-suffix heuristic is rather complicated to implement)
2. Simplified Boyer-Moore Algorithm
  - bad-character heuristic
  - 구현이 쉽다. 이해하기 쉽다.
  - original과 성능 차이가 크지 않다.
3. Boyer-Moore-Horspool Algorithm
  - Simplified Boyer-Moore Algorithm의 부분 수정
  - 점프 배열에서 P의 마지막은 제외(-1)
  - 매 단계에서 틀린 글자가 나오면 틀린글자로 검색하는게 아니라TEXT의 비교 range 중 마지막 글자로 P에서 찾아서 진행



### Boyer-Moore 종류별 성능 비교

![](http://www.cs.emory.edu/~cheung/Courses/253/Syllabus/Text/FIGS/0/CompareAlgs.gif)


### Boyer-Moore 결론
필요할때 그냥 Boyer-Moore-Horspool 쓰자!!!
(good-suffix heuristic은 input 대비(구현 어려움) 효과가 그닥)