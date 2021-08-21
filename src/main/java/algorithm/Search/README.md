# Binary Search : lower bound & upper bound

[참고 링크](https://hee96-story.tistory.com/80)

### Binary Search (이진 탐색)

이진 탐색은 정렬이 된 데이터에서 어떠한 특정 값이 존재하는지 검색하는 알고리즘이다.  
기준 값(보통 mid)을 구해서 그 값을 기준으로 데이터를 나눠서 검색하는 방법이다. 
특정 값을 찾을 때는 기본 이진 탐색으로 쉽게 구할 수 있다. 

하지만 중복된 데이터에서 탐색할 때는 조금 더 응용된 방법을 사용해야한다.  
(예를 들어, 중복 된 데이터에서 특정 데이터가 몇 개가 존재하는지 등) 

따라서 lower bound와 upper bound를 구해야한다.
- Lower bound는 데이터 내에서 특정 값보다 같거나 큰 값이 처음 나오는 위치를 리턴해준다. 
- High Bound는 특정 값보다 처음으로 큰 값이나 나오는 위치를 리턴해준다.


![](https://k.kakaocdn.net/dn/bMIAMA/btqwvrNzD8k/LYflC0V1UnMn2OFyHfX0U1/img.png)  

위의 그림을 보면 찾고자 하는 값이 3일 경우,  
- lowerBound(3) : 3보다 같거나 큰 값이 처음 나오는 위치인 인덱스 3 리턴  
- upperBound(3) : 3보다 처음으로 나오는 큰 값인(4)의 위치인 인덱스 6 리턴


![](http://bajamircea.github.io/assets/2018-08-09-lower-bound/02-lower_bound_samples.png)


