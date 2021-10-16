# Spanning Tree
- 스패닝 트리 = 신장트리
- 무방향 그래프 
- 그래프의 모든 정점이 간선으로 연결
  
- 그래프 내의 모든 정점을 포함하는 트리
    - 트리의 특징을 가짐
    - N 개의 정점, N-1 개의 간선
    - 사이클 x
  

- 그래프에서 일부 간선을 선택해서 만든 트리
- 하나의 그래프에 여러개의 스패닝 트리가 존재


- DFS, BFS을 이용하여 그래프에서 신장 트리를 찾을 수 있음.
  - 탐색 도중에 사용된 간선만 모아 만듬.


# 최소 신장 트리(MST, Minimum Spanning Tree)
- 여러개의 spanning tree 중 연결 최소 비용 spanning tree 
- 크루스칼 알고리즘
- 프림 알고리즘


## 응용
  1. 도로건설 : 모든 도시 연결를 위한 도로의 최소 길이
  2. 전기회로 : 모든 단자 연결하기 위한 전선의 최소 길이
  3. 통신 : 전화 케이블망 모두 연결 최소 비용
  4. 배관 : 모든 파이프 연결을 위한 최소 길이
  5. 네트워크 : 최적 통신 경로


## 크루스칼 알고리즘
- 그리디 : 매 순간 선택되지 않은 간선 중 가장 적은 비용의 간선 선택


- 구현 방법
  1. 간선 기준 오름차순 정렬
  2. 최소 비용의 간선 선택
  3. 선택된 간선에 연결된 vertex들이 서로 사이클 이루는지 확인
      - disjoint set : union-find 알고리즘
        - 서로소 집합 자료구조
        - 무방향 그래프 내에서 사이클을 판별
        - path compression 필요
  4. 사이클 이루면 해당 연결 정보 무시, 사이클을 이루지 않는다면 MST에 포함 시킴
  5. 모든 연결정보에 대해 2~4 반복
  

## Prim's Minimum Spanning Tree

- 그리디 : 매 순간 vertex의 적은 비용의 간선 선택하며 확장
  

- 종류 : 
  - Eager Prim's Minimum Spanning Tree
  - Lazy Prim's Minimum Spanning Tree


- 구현 방법
  1. 시작점을 일반 큐에 넣고, mst에도 넣음
  2. 일반 큐에서 하나를 꺼내 그 노드의 연결된 노드들을 weight 기준의 우선순위 큐에 넣음
  3. 우선순위 큐에서 최소 weight의 edge를 꺼냄
  4. 3번의 노드를 mst에 추가, cost 누적시킴
  5. 3번의 노드 방문 처리 후 일반 큐에 넣음
  6. n-1 개의 간선이 처리 될때 까지 2~5번 반복

  
- 의사코드(슈도코드, pseudocode)

![](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F99B212455A465A991C216F)


![](https://algotree.org/images/Prims_MST_Java.svg)

## 크루스칼 vs 프림
- 공통점
  1. 그리디 알고리즘

  
- 차이점
  1. 크루스칼 : 간선 위주의 알고리즘
     - 시작점을 정하지 않고, 최소 비용의 간선을 차례로 대입하면서 MST를 구성하며, 그 과정에서 사이클을 이루는지 항상 확인 
     - 전체에서 간선 중 최소 비용 선택으로 진행
     - 간선 선택 마다 사이클 확인
       - DSU(Disjoint-set union) 자료구조 > Union-Find 함수 
     - 그래프 내에 적은 숫자의 간선만을 가지는 적합
       - 희소 그래프(Sparse Graph)
    - 간선을 weight 기준으로 정렬하는 과정이 오래 걸린다.
    - Time Complexity : O(E logE)
  
  2. 프림 : 정점 위주의 알고리즘
    - 시작점을 정하고, 시작점에서 가까운 정점을 선택하면서 MST를 구성하므로 그 과정에서 사이클을 이루지 않음
    - 선택된 vertex의 간선중 최소 비용 선택
    - 점진적 확장 진행
    - 우선순위 큐
    - 그래프에 간선이 많이 존재하는 경우는 적합
      - 밀집 그래프(Dense Graph)
    - 최소 거리의 정점을 찾는 부분에서 자료구조의 성능에 영향을 받는다.
    - Time Complexity : O(V^2+E) → O(E logV)
