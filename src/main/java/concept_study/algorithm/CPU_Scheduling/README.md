# CPU Scheduling

- **Completion Time**:
  - Time at which process completes its execution.
- **Turn Around Time**:
  - Time Difference between completion time and arrival time.
- **Waiting Time(W.T)**:
  - Time Difference between turn around time and burst time.
- Note: if is 0 arrival times, then 'turn around' and 'completion' times are same.

```text
Complete Time = Arrival Time + Burst Time
OR
Complete Time = Complete Time of Previous Process + Current Process Burst Time

Turn Around Time = Complete Time - Arrival Time
Waiting Time = Turn Around Time - Burst Time
```

     
## FCFS
- FCFS(First Come First Served)라고도 하는 FIFO(선입 선출)는 가장 간단한 스케줄링 알고리즘입니다. 
- FIFO는 단순히 준비 대기열에 도착한 순서대로 프로세스를 대기열에 넣습니다.
- 먼저 오는 프로세스가 먼저 실행되고 이전 프로세스가 완전히 실행된 후에야 다음 프로세스가 시작됩니다.

### Important Points:
1. Non-preemptive
2. 평균 대기 시간이 최적이 아님
3. 자원을 병렬로 사용할 수 없음 : Convoy 효과 발생 (IO 바운드 프로세스가 많고 CPU 바운드 프로세스가 하나인 상황을 고려하십시오. 
   IO 바운드 프로세스는 CPU 바운드 프로세스가 CPU를 획득할 때 CPU 바운드 프로세스를 기다려야 합니다. 
   IO 바운드 프로세스는 한동안 CPU를 사용하고 IO 장치를 사용하는 것이 좋습니다.


## Shortest Job First

### Non- preemptive
- Shortest Job First는 모든 스케줄링 알고리즘 중 평균 대기 시간이 최소라는 장점이 있습니다.
- It is a Greedy Algorithm.
- 더 짧은 프로세스가 지속되면 starvation 이 발생할 수 있습니다. 이 문제는 ageing 의 개념을 사용하여 해결할 수 있습니다.
- 운영 체제가 버스트 시간을 알지 못하여 정렬하지 못할 수 있으므로 실제로 실행 불가능합니다. 실행 시간을 예측할 수는 없지만 
  이전 실행 시간의 가중 평균과 같은 몇 가지 방법을 사용하여 작업의 실행 시간을 예측할 수 있습니다. 
- SJF는 정확한 실행 시간 추정이 가능한 특수 환경에서 사용할 수 있습니다. 

#### Algorithm: 
1. **Sort all the process according to the arrival time.** 
2. Then select that process which has minimum arrival time and minimum Burst time. 
3. After completion of process make a pool of process which after till the completion 
of previous process and select that process among the pool which is having minimum Burst time. 
