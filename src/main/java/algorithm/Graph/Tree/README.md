https://gmlwjd9405.github.io/2018/08/28/algorithm-mst.html

# Spanning Tree




# 최소 신장 트리(MST, Minimum Spanning Tree)

# 최단거리(Shortest path problem)

- 단일 출발 최단경로: 특정 노드에서 출발하여 다른 모든 노드에 도착하는 최단 경로 찾기
  - single-source shortest path problem

- 단일 도착 최단경로: 모든 노드들에서 출발하여 특정 노드에 도착하는 최단 경로 찾기
  - single-destination shortest path problem

- 단일 쌍 최단 경로: 특정 노드에서 출발하여 특정 노드에 도착하는 최단 경로 찾기
  - single-pair shortest path problem

- 전체 쌍 최단 경로: 모든 출발지-도착지 쌍에 대한 최단 경로 찾기
  - all-pair shortest path problem

## 다익스트라 알고리즘 (Dijkstra's Algorithm)
- 가장 유명한 알고리즘으로, 단일 정점의 최단경로를 구할 수 있다.

## 벨만 포드 알고리즘(Bellman-Ford Algorithm)
- 음의 가중치를 가진 경로에서도 최단거리를 구할 수 있다. 경로 추적이 가능하다.

## 플로이드 와샬 알고리즘(Floyd-Warshall Algorithm)
- 단일정점이 아닌 모든 정점 사이의 최단거리를 구할 수 있다.
- all-pair shortest path problem

## SPFA(Shortest Path Faster Algorithm)
- STL없이 간단하게 구현 가능하며, 평균적으로 빠른 속도를 가진다.


# Segment Tree

# Binary Indexed Tree, BIT(=Fenwick Tree)


