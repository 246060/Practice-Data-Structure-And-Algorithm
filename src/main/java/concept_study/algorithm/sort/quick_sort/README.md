# Quick Sort

pivot를 어디를 잡고 위치 이동을 어떻게 할지에 따라 구현이 방법이 다양하다.

![](https://i.pinimg.com/564x/fe/f8/08/fef8085a6420538e38f6ccfaba04d12f.jpg)  
이미지 출처 : https://www.interviewbit.com/tutorial/quicksort-algorithm/

![](https://www.codingeek.com/wp-content/uploads/2016/06/word-image-2.png)  
이미지 출처 : https://www.codingeek.com/algorithms/quick-sort-algorithm-explanation-implementation-and-complexity/


## Pseudocode
```
QUICK-SORT(A, start, end)
    if start < end
        pIndex = PARTITION(A, start, end)
        QUICK-SORT(A, start, pIndex-1)
        QUICK-SORT(A, pIndex+1, end)
end func

/* To sort an entire array A, the initial call is QUICK-SORT(A, 0, A.length-1) */

//partitioning the array with respect to pivot.
PARTITION(A, start, end)
    pivot = A[end]
    pIndex = start
        for i = start to end-1
           if A[i] < pivot
               swap A[i] with A[pIndex]
                pIndex=pIndex+1
    swap A[pIndex] with A[end]
   return pIndex
end func
```