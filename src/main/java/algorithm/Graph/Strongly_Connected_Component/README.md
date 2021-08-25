# SCC (Strongly Connected Component)
https://www.youtube.com/watch?v=uGf7dUYCsj4

- 그래프 안에서 '강하게 결합된 정점 집합'
- 그래프내에 사이클를 이루는 정점들을 하나의 그룹으로 다룸
- 같은 SCC내의 임의 두 정점은 양방향으로 접근 가능
- 서로 다른 SCC는 단뱡항으로 연결된다.
- 그래프를 SCC로 만들면 그래프내의 사이클이 없는 것처럼 다루게 되어, 위상정렬이 가능해진다.
- 강한 연결 요소는 정점 하나를 제거해도 연결은 유지된다.
  
- 강하게 결합된 정점들의 집합 = SCC 집합   
  - cf. 강하게 결합되었다는 의미 : 두 노드가 서로한테 갈 수 있는 경우 서로 긴밀하게(강하게) 연결되어있다고 말함

- 같은 강한 결합 요소 안에 속한 노드들은 서로가 서로한테 도착할 수 있는 특징을 가짐

- 방향그래프이고 사이클이 존재하는 경우에 강한 결합 요소가 나타남.  
  - 만약, 무향 그래프라면 그래프 전체가 무조건 강한 결합 요소이므로 의미가 없음

![img](https://lh3.googleusercontent.com/proxy/wtCXbclcm2YzSXVua4AU_eWLZ29gBkmgPUXGdwVfUOH7LAHZiyYXP9X4uwEAuQX8HoCrc5To5szUh_U9s9GtWD-BCaT3YQKGhVuE6wRu33ckbgXxwmv47zBCgBRFAbnNVI48gLmJfQSSGMCdkYI5-gQsD74)

![img](https://mblogthumb-phinf.pstatic.net/MjAxODAzMjVfMTQ2/MDAxNTIxOTU3ODQzNzY4.YpjazFa4dbpvAUqzOo-f-wWdZGpOU39-yuGt1CSKRH4g.fdObC5MR0f1gKaAgQijSuBypBVlrZBiVnACOX1-DtlMg.PNG.ndb796/image.png?type=w800)


## 강한 결합 요소란?

SCC라고도 부르며, 그래프 안에서 강하게 결합된 정점 집합을 뜻한다.
같은 SCC에 속하는 두 정점은 서로 도달이 가능하다.
싸이클이 발생하는 경우 SCC이다. 즉, 방향 그래프일 때만 의미가 있다. 
무향 그래프인 경우 그래프 전체가 SCC이기 때문에 의미가 없다.

## 키워드

- 방향그래프(유향 그래프)
- 사이클
- 위상정렬

# SCC 탐색 방법

동일한 시간복잡도를 가지는 다양한 방법이 있다.

- 코사라주 알고리즘 (Kosaraju's Algorithm)
- 타잔 알고리즘 (Tarjan's Algorithm)

일반적으로 코사라주 알고리즘이 구현하기 더 쉽지만 타잔 알고리즘이 더 적용이 쉽다.

활용 방법

- 2-SAT
- Dulmage-Medelsohn decomposition

## Kosaraju's 알고리즘

2번의 DFS를 통해 SCC를 구하는 알고리즘 O(V+E) 의 빠른 시간 복잡도 & 매우 쉬운 구현

필요한 자료구조
```
List<List<Integer>> graph, reverseGraph	정방향 & 역방향 그래프
boolean[] visited	방문 여부 체크 배열
Stack<Integer> stack	DFS 호출 시작점을 찾기위한 stack
List<List<Integer>> SCC	SCC 집합 저장 그래프
```

1. graph와 reverseGraph에 그래프 연결 정보를 저장한다.
   
2. for(V, 모든 정점)으로 인접 정점에 대해 방문 체크를하고 DFS로 연결이 끝나는 지점까지 들어간다. 
   그리고 DFS 호출이 끝나는 시점에 stack에 push한다. -> LIFO 구조로 처음 호출한 노드가 가장 위로 올라오기 때문
   
3. 다시 visited 배열을 초기화 한 후, while(!stack.isEmpty())으로 reverseGraph로 reDFS 호출을 한다. 
   이때, 1번 로직에서의 DFS와 달라지는 점은 노드를 SCC에 추가하여 SCC 집합을 만드는 것



# 타잔 알고리즘 (Tarjan's Algorithm)

- 모든 정점에 대해 DFS를 수행하여 강한 결합 요소를 찾는 알고리즘
- DFS를 이용 => Stack 사용
- 부모 노드를 기준으로 강한 결합 요소(사이클 여부)를 판단함
- 시간 복잡도 : O(V+E)
- Union-Find와 비슷


- 생각 순서
  1. 모든 정점에 대해 부모 노드는 자기 자신으로 초기화
  2. 방문하지 않은 모든 정점에 대해 DFS 실행
  3. DFS 시작 노드를 방문 처리 후 Stack에 삽입
  4. 시작 노드와 연결된 정점들에 대해 부모 노드를 확인 후 연결된 정점을 기준으로 재귀적으로 DFS 수행
  5. 만약 DFS가 끝나지 않았는데 이미 방문한 노드를 재방문했을 경우, 사이클이 있는 것이므로 SCC의 원소들을 스택에서 골라냄



