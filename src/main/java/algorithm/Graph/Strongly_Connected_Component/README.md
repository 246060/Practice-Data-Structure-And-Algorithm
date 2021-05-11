# SCC (Strongly Connected Component)

- 그래프 안에서 '강하게 결합된 정점 집합'
- 그래프내에 사이클를 이루는 정점들을 하나의 그룹으로 다룸
- 같은 SCC내의 임의 두 정점은 양방향으로 접근 가능
- 서로 다른 SCC는 단뱡항으로 연결된다.
- 그래프를 SCC로 만들면 그래프내의 사이클이 없는 것처럼 다루게 되어, 위상정렬이 가능해진다.

- 강하게 결합된 정점들의 집합 = SCC 집합
  cf. 강하게 결합되었다는 의미 : 두 노드가 서로한테 갈 수 있는 경우 서로 긴밀하게(강하게) 연결되어있다고 말함
  
- 같은 강한 결합 요소 안에 속한 노드들은 서로가 서로한테 도착할 수 있는 특징을 가짐
  
- 방향그래프이고 사이클이 존재하는 경우에 강한 결합 요소가 나타남. 
  만약, 무향 그래프라면 그래프 전체가 무조건 강한 결합 요소이므로 의미가 없음


![img](https://lh3.googleusercontent.com/proxy/wtCXbclcm2YzSXVua4AU_eWLZ29gBkmgPUXGdwVfUOH7LAHZiyYXP9X4uwEAuQX8HoCrc5To5szUh_U9s9GtWD-BCaT3YQKGhVuE6wRu33ckbgXxwmv47zBCgBRFAbnNVI48gLmJfQSSGMCdkYI5-gQsD74)

![img](https://mblogthumb-phinf.pstatic.net/MjAxODAzMjVfMTQ2/MDAxNTIxOTU3ODQzNzY4.YpjazFa4dbpvAUqzOo-f-wWdZGpOU39-yuGt1CSKRH4g.fdObC5MR0f1gKaAgQijSuBypBVlrZBiVnACOX1-DtlMg.PNG.ndb796/image.png?type=w800)



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

2번의 DFS를 통해 SCC를 구하는 알고리즘
O(V+E) 의 빠른 시간 복잡도 & 매우 쉬운 구현


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



