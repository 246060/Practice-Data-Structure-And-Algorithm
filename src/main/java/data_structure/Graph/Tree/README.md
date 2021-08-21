# Tree 🌲

![img](https://adrianmejia.com/images/tree-parts.jpg)

- 계층형 자료구조 
- 그래프의 일종 
  <br/><br/>
- 노드 종류
    - 최상위 노드 : root
    - 부모 노드(parent node)
    - 자식 노드(child node)  
        - leaf node : 자식 노드가 없는 노드
        - internal node : 잎 노드가 아닌 노드를 내부 노드
          <br/><br/>
- 사이클이 없는 방향 그래프를 말하는 DAG(Directed Acyclic Graph)의 한 종류
  - 개별 요소들이 특정한 방향을 향하고 있으며, 서로 순환하지 않는 구조 <br/><br/>
- 여러 노드가 한 노드를 가리키지 않음
    - 각 노드의 in-degree : Max 1 

<br/><br/>

## Tree 종류

<br/> 

### Binary Tree 👩‍👦‍👦
부모 노드가 자식 노드를 최대 2개씩만 갖고 있는 트리  

![img](https://media.vlpt.us/images/qksud14/post/1712bcce-475f-460d-bce8-b59f913d8995/full-complete-perfect-binary-tree.jpg)

<br/>

  1. Full Binary Tree
     - 자식 노드 0 or 2 개
     - 자식을 하나만 가진 노드가 없음
       <br/><br/>
  2. Complete Binary Tree
     - 마지막 레벨을 제외한 모든 서브트리의 레벨이 같아야 하고, 마지막 레벨은 왼쪽부터 채워져 있어야 함.
       <br/><br/>
  3. Perfect Binary Tree  
     - 완벽한 피라미드 형태로, 빈공간 없이 모든 노드가 2개의 자식을 갖고 있는 tree
       <br/><br/>
  4. Binary Search Tree
     - 자식노드는 최대 2개
     - 왼쪽 자식노드가 루트노드보다 작고, 오른쪽 자식노드가 루트노드보다 큼
     - 중위순회(Inorder Traveral)을 적용하면 오름차순 정렬이 된다.
       - 전위순회/후위순회는 딱히 의미가 없다.
       <br/><br/>
  5. skewed binary tree
     - 노드들이 전부 한 방향으로 편향된 트리

<br/><br/>

### Ternary Tree
- 자식 노드를 2개 이상 갖고 있는 트리 
- Trie

<br/><br/><br/>


### Balanced Tree

![img](https://www.growingwiththeweb.com/images/2015/11/14/balanced-trees.svg)

- Red-Black Tree
- AVL tree

<br/>

### Unbalanced Tree
- 한쪽으로 지나치게 치우친 Tree
- Skewed Binary Tree

<br/><br/>

## Tree Traversal

- V : Visit
- L : Go Left
- R : Go right

1. Pre-Order  : VLR
2. In-Order   : LVR
3. Post-Order : LRV
4. Level-Order
    - 낮은 레벨부터 차례대로 순회
    - 너비 우선 순위(= breadth-first traversal)
    


