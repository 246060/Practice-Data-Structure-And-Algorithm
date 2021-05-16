

- Maximum Flow Problem(최적화 문제 유형)
- single source -> single sink가 주어졌을 때 가능한 경로들이 무수히 있고, 
  이중에서 흐름값이 최대가 되는 경로와 최대값을 찾는 문제


# Ford-Fulkerson Algorithm(포드-풀커슨 알고리즘)
- DFS
- O(V+E)F
- The path in step 2 can be found with, 
  for example, a breadth-first search (BFS) or a depth-first search in 
  {\displaystyle G_{f}(V,E_{f})}G_{f}(V,E_{f}). 
  If you use the former, the algorithm is called Edmonds–Karp.



# Edmonds-Karp Algorithm(에드몬드 카프 알고리즘)
- BFS
- O(VE^2)
- The name "Ford–Fulkerson" is often also used for the Edmonds–Karp algorithm, 
  which is a fully defined implementation of the Ford–Fulkerson method.



# Dinic's Algorithm(디닉 알고리즘)
-  O(V^2*E)
- 레벨 그래프(Level Graph)
- 차단 유량(Blocking Flow)



# Bipartite Matching(이분 매칭)
- Hopcroft-Karp Algorithm
-  O(V^(1/2)E)
- 간선의 용량이 전부 1인 이분 그래프에서의 최대 유량을 구하는 문제는 이분 그래프에서의 최대 매칭과 동치
- 네트워크 플로우의 개념중에서 이분 그래프(bipartite grape)에서의 최대 유량을 구하는 경우를 이분 매칭이라고 부릅

![img](https://www.geeksforgeeks.org/wp-content/uploads/maximum_matching1.png)





# Minimum cut
- https://reniowood.github.io/algorithm/2018/09/16/Algorithm-Network-Flow.html
- deterministic algorithm
  - 에지를 구성하는 두 노드를 하나의 노드로 수축하는 연산을 수행하는데 이를 최종 노드의 수가 2개일 때까지 반복
  - 두 수축된 노드 사이의 에지들의 집합이 이 cut에 대한 cut set이 된다.
- Contraction Algorithm
  - 그래프가 m개의 노드만 가질 때까지 random하게 edge를 contraction함으로써 mincut을 찾는 알고리즘
- Contradict(G, m) 알고리즘
- Karger’s Algorithm
- Karger–Stein algorithm

최대 유량을 구하는 여러 알고리즘(Edmond-Karp algorithm, Dinic algorithm 등)을 적용하여, 
최소 컷의 크기를 쉽게 구할 수 있습니다.

하지만 두 점 s와 t가 정해지지 않은, 전체 그래프에서의 global minimum cut을 찾는 것은 어떨까요? 
(Global Minimum Cut)
이를 찾는 대표적인 알고리즘으로 determisistic한 Stoer-Wagner Algorithm, 
그리고 randomize algorithm인 Karger’s Algorithm이 있습니다.

# minimum vertex cut

# Minimum vertex cover
- https://reniowood.github.io/algorithm/2018/09/16/Algorithm-Network-Flow.html

# Maximum independent set

# MCMF(Minimum Cost Maximum Flow)

# Capacity Scaling
- https://www.youtube.com/watch?v=1ewLrXUz4kk&list=PLDV1Zeh2NRsDj3NzHbbFIC58etjZhiGcG&index=8


- https://1ambda.github.io/algorithm/algorithm-part2-5/
- https://www.geeksforgeeks.org/minimum-cut-in-a-directed-graph/
- https://www.javatips.net/api/java-algorithms-implementation-master/src/com/jwetherell/algorithms/graph/EdmondsKarp.java
- https://www.programiz.com/dsa/ford-fulkerson-algorithm
- https://koosaga.com/71
- https://blog.naver.com/PostView.nhn?blogId=jqkt15&logNo=222046491940&redirect=Dlog&widgetTypeCall=true&topReferer=https%3A%2F%2Fblog.naver.com%2FPostView.nhn%3FblogId%3Djqkt15%26logNo%3D222070243236&directAccess=false