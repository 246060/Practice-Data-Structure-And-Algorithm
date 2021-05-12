
# 문자열 관련 알고리즘

## 패턴 매칭
- 보이어-무어 : 보통 O(n) 보다 적음, 최악 O(nm)
- 라빈 카프 : O(n)
- KMP : O(n+m)


## 보이어-무어
- https://www.youtube.com/watch?v=mXQtunIEo0k&t=493s
- https://greatzzo.tistory.com/8
- 패턴의 오른쪽부터 비교하여 텍스트 문자를 모두 비교하지 않아도 탐색이 가능한 알고리즘
- 문자열 패턴과 문자열을 비교시 문자열의 가장 뒷부분 위치를 비교, 
다르면 일정 길이만큼 이동하여 비교를 계속하는 기법

- 착한 접미부 이동(Good Suffix Method)와 나쁜문자 이동(Bad Character Method) 활용
- 현재 대부분의 워드프로세스 "검색" 기능에서 사용되고 있음.


