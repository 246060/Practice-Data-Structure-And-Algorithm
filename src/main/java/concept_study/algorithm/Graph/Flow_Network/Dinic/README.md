# Dinic 
[출처](https://www.crocus.co.kr/1088)

## Context
1. 디닉 알고리즘(Dinic's Algorithm)이란?
2. 구현 방법
3. 시간 복잡도
4. 소스 코드
5. 관련 문제


## 마구잡이 키워드 
네트워크 플로우
애드몬드 카프 시간 복잡도 -> O(V*E^2)
디닉 시간 복잡도 -> O(V^2*E)

간선의 수가 상당히 많은 문제를 만나게 되면 O(V*E^2)으로 해결 할 수 없는 문제가 있을 수 있다.
그때를 위한 디닉 알고리즘(Dinic's Algorithm)

구현을 위해 우선 알아두어야 할 개념
- 레벨 그래프(Level Graph)
- 차단 유량(Blocking Flow)
- 유량의 대칭성 :: f(u,v) = -f(u,v)

![img](https://t1.daumcdn.net/cfile/tistory/236AF53758A120FC0A?download)

Like Edmond Karp’s concept_study.algorithm, Dinic’s concept_study.algorithm uses following concepts :
1. A flow is maximum if there is no s to t path in residual graph.
2. BFS is used in a loop. There is a difference though in the way we use BFS in both algorithms.
   
Outline of Dinic’s concept_study.algorithm :

1) Initialize residual graph G as given graph.
1) Do BFS of G to construct a level graph (or assign levels to vertices) and also check if more flow is possible.
   a) If more flow is not possible, then return.
   b) Send multiple flows in G using level graph until blocking flow is reached. Here using level graph means, 
      in every flow, levels of path nodes should be 0, 1, 2... (in order) from s to t.

A flow is Blocking Flow if no more flow can be sent using level graph, 
i.e., no more s-t path exists such that path vertices have current levels 0, 1, 2… in order. 
Blocking Flow can be seen same as maximum flow path in Greedy concept_study.algorithm discussed discussed here.

#### 레벨 그래프(Level Graph)
모든 정점에 대해 레벨을 매겨놓은 그래프

Source가 되는 정점은 레벨이 0이고, 
소스와 인접한 정점들은 레벨이 1, 
레벨 1 정점과 인접한 정점들은 레벨이 2, ..., 레벨 n - 1 정점과 인접한 마지막 Sink의 레벨은 n이 된다.

레벨 그래프를 형성하는 조건은 다음과 같다.

1) 해당 정점은 아직 레벨을 부여받지 않은 정점이어야 한다.
2) `c[here][next] - f[here][next] > 0`. 
   즉, here에서 next로 유량이 흐를 수 있는 간선만을 이용할 수 있다.


#### 차단 유량(Blocking Flow)
레벨 그래프를 형성할 때 레벨 그래프를 형성하는 조건에 맞지 않는 간선들을 제외한 것들을 의미

![](https://greeksharifa.github.io/public/img/Algorithm_and_Data_Structure/2018-07-11-algorithm-dinic/02_residual_capacity.png)
디닉 알고리즘에서는, 유량을 흘려보낼 때 레벨 차이가 딱 1이 나는 정점으로만 유량을 보낼 수 있다. 
즉 바로 위의 그림에서의 간선과 같은 곳으로만 보낼 수 있다. 레벨이 같아도 안 된다.

유량을 흘려보내는 것은 DFS로 구현
source에서 시작하여, 차단 유량 규칙을 만족하는 정점으로만 따라가면서 최종적으로 sink에 도달할 때까지 탐색하는 과정을 반복한다.

위의 레벨 그래프에서는 다음 세 경로를 DFS로 찾을 수 있다.

(s, 1, 3, t): 유량 4
(s, 1, 4, t): 유량 6
(s, 2, 4, t): 유량 4

```
디닉 알고리즘에선 유량을 보낼때, 간선(u, v)에서 level[u] + 1 = level[v]를 
만족 할때만 유량을 보낼수 있습니다. 위의 조건을 만족하면서 유량을 보낼때 해당 
레벨 그래프에서 더이상 source에서 sink로 유량을 보낼수 없을 때까지 최대한 보낸 
유량을 `차단 유량`이라고 합니다.
```

레벨 그래프 상에서 인접하면서 자신보다 레벨이 1 큰 정점으로만 흐를 수 있을때 소스에서 싱크로 흘릴 수 있는 최대 유량

### 디닉 알고리즘은 크게 두 단계로 이루어진다.

1. BFS를 써서 레벨 그래프(Level Graph)를 생성하는 것
2. DFS를 써서, 레벨 그래프에 기초한 차단 유량(Blocking Flow)의 규칙을 지키면서, 최대 유량을 흘려주는 것
3. 반복
   BFS 1번 그리고 DFS를 한번씩 해서는 최대 유량이 찾아지지 않는다. 다만 복잡한 것은 아니고, 위의 과정을 반복해주면 된다.

---

즉 디닉 알고리즘은
1. 레벨 그래프를 만든다.
2. 만들어진 레벨 그래프에서 차단 유량만큼 유량을 흘려보내준다.

위의 두 과정을 레벨 그래프에서 sink에 도달하지 못할때까지 반복해 줍니다. 
그리고 이때 흘려보낸 유량의 합이 source에서 sink로 보낼 수 있는 최대 유량이 됩니다.

---
간선의 유량이 모두 같을 경우(모두 0 또는 1), 신기하게도 O(min(V^2/3 * E, V^3/2))에 동작한다.

직접적인 flow문제는 별로 없고, 최댓값을 구하는 문제를 max flow로 환원할 수 있는 경우가 종종 있다. 
혹은 최솟값을 구하는 문제를 min cut으로 환원하기도 한다. 



---
### 구현
- https://greeksharifa.github.io/concept_study.algorithm%20&%20data%20structure/2018/07/11/concept_study.algorithm-dinic/

DFS의 구현은 조금 까다롭다.

1. 우선 sink(T)에 도달하면 종료한다.
1. 종료할 때 max_flow라는 것을 리턴한다. 이는 Network Flow에서 수송량은 경로에 포함된 파이프 최대 유량의 최솟값이기 때문이다. flow의 계산식을 잘 보면 최대 유량과 min 연산을 취하는 것을 볼 수 있다.
1. 레벨 차이가 1 나는지를 먼저 검사한다. 그리고 그 정점의 잔여 용량이 0보다 큰지 또한 검사한다.
1. 만약 그런 정점을 찾았으면, 재귀적으로 DFS를 수행한다.
1. DFS가 리턴되어 반환한 flow 값이 0보다 크면, 아직 DFS로 탐색할 수 있는 경로가 남아 있다는 뜻이다.
1. 경로를 찾았으므로, 해당 경로를 따라서(스택에 재귀 호출로 쌓인 함수에 의해 자동으로 역추적됨) 잔여 용량을 줄여준다.
1. 만약 어떤 flow도 0이라면, 경로를 찾지 못한 것이므로 종료한다.
1. next_v라는 배열(벡터)이 있다. 이는 DFS에서 다음 경로를 효율적으로 찾기 위해 존재하는 배열이다.
1. DFS로 경로를 탐색할 떄 정점 번호가 낮은 정점부터 탐색한다.
1. 만약 처음에 1번 정점으로 가는 경로를 모두 찾았다면, 더 이상 1번 정점으로는 갈 필요가 없다. 이때 next_v[u]를 1 증가시켜, 다음부터는 2번 정점부터 탐색을 시작하도록 한다.
1. 2번도 끝났으면 또 next_v[u]를 증가시킨다. 이를 반복한다.
1. 코드 상으로는 int &i로 되어 있다. i가 레퍼런스로 선언되어 있기 때문에 for loop의 i++ 구문에 따라 같이 증가한다(i는 next_v[u]와 값을 공유한다)

