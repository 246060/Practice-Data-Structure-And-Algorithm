package concept_study.algorithm.CPU_Scheduling;

// https://www.geeksforgeeks.org/program-for-shortest-job-first-sjf-scheduling-set-2-preemptive/
public class SJF_Preemptive {

    static class Process {
        int id;
        int arrivalTime;
        int burstTime;
        int waitingTime;
        int turnAroundTime;
        int completedTime;

        public Process(int id, int arrivalTime, int burstTime) {
            this.id = id;
            this.arrivalTime = arrivalTime;
            this.burstTime = burstTime;
        }
    }

    public static void main(String[] args) {

        int n = 4;

        Process[] p = {
                new Process(1, 1, 6),
                new Process(2, 1, 8),
                new Process(3, 2, 7),
                new Process(4, 3, 3),
        };

        int[][] processes = {
                {1, 1, 6, 0, 0, 0},
                {2, 1, 8, 0, 0, 0},
                {3, 2, 7, 0, 0, 0},
                {4, 3, 3, 0, 0, 0}
        };

        findAvgTime(processes, n);

        System.out.println();
        findAvgTime(p);
    }

    private static void findAvgTime(Process[] p) {
        int n = p.length;

        solution2(p);

        System.out.println("\n" +
                "Process Id \t Arrival Time \t Burst Time \t " +
                "Completed Time \t Waiting Time \t Turn Around Time"
        );

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        for (Process process : p) {
            totalWaitingTime += process.waitingTime;
            totalTurnAroundTime += process.turnAroundTime;

            System.out.printf("\t%2d%14d%15d%18d%18d%18d",
                    process.id,
                    process.arrivalTime,
                    process.burstTime,
                    process.completedTime,
                    process.waitingTime,
                    process.turnAroundTime
            );
            System.out.println();
        }

        System.out.println();
        System.out.println("Average Waiting Time = " + totalWaitingTime * 1.0 / n);
        System.out.println("Average Turn Around Time = " + totalTurnAroundTime * 1.0 / n);
        System.out.println();
    }

    private static void solution2(Process[] p) {
        findWaitingTime(p);
        findTurnAroundTime(p);
    }

    private static void findWaitingTime(Process[] p) {
        int n = p.length;
        int[] burstTime = new int[n];
        for (int i = 0; i < n; i++) {
            burstTime[i] = p[i].burstTime;
        }

        int sec = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;

        boolean check = false;
        int cnt = 0;

        while (cnt != n) {

            for (int i = 0; i < n; i++) {
                if (p[i].arrivalTime > sec) continue;
                if (burstTime[i] <= 0) continue;
                if (burstTime[i] < min) {
                    min = burstTime[i];
                    minIdx = i;
                    check = true;
                }
            }

            sec++;
            if (!check) continue;

            min = --burstTime[minIdx];
            if (min == 0) {
                min = Integer.MAX_VALUE;
                cnt++;
                check = false;

                p[minIdx].waitingTime = sec - p[minIdx].burstTime - p[minIdx].arrivalTime;
                if (p[minIdx].waitingTime < 0) {
                    p[minIdx].waitingTime = 0;
                }
            }
        }
    }

    private static void findTurnAroundTime(Process[] p) {
        for (Process process : p) {
            process.turnAroundTime = process.waitingTime + process.burstTime;
        }
    }

    private static void findAvgTime(int[][] processes, int n) {

        solution1(processes, n);

        System.out.println("\n" +
                "Process Id \t Arrival Time \t Burst Time \t " +
                "Completed Time \t Waiting Time \t Turn Around Time"
        );

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        for (int i = 0; i < n; i++) {
            totalWaitingTime += processes[i][4];
            totalTurnAroundTime += processes[i][5];

            System.out.printf("\t%2d%14d%15d%18d%18d%18d",
                    processes[i][0],
                    processes[i][1],
                    processes[i][2],
                    processes[i][3],
                    processes[i][4],
                    processes[i][5]
            );
            System.out.println();
        }

        System.out.println();
        System.out.println("Average Waiting Time = " + totalWaitingTime * 1.0 / n);
        System.out.println("Average Turn Around Time = " + totalTurnAroundTime * 1.0 / n);
        System.out.println();
    }

    private static void solution1(int[][] processes, int n) {
        findWaitingTime(processes, n);
        findTurnAroundTime(processes, n);
    }

    private static void findWaitingTime(int[][] processes, int n) {

        int[] burstTime = new int[n];
        for (int i = 0; i < n; i++)
            burstTime[i] = processes[i][2];

        int sec = 0;
        int min = Integer.MAX_VALUE;
        int minIdx = 0;

        boolean check = false;
        int cnt = 0;

        while (cnt != n) {

            for (int i = 0; i < n; i++) {
                int arrivalTime = processes[i][1];
                if (arrivalTime > sec) continue; // 도착하지 않는 거 제외
                if (burstTime[i] <= 0) continue; // 이미 완료된거 제외
                if (burstTime[i] < min) {
                    min = burstTime[i];
                    minIdx = i;
                    check = true;
                }
            }

            sec++;
            if (!check)
                continue;

            min = --burstTime[minIdx];

            if (min == 0) {
                min = Integer.MAX_VALUE;
                cnt++;
                check = false;

                // waiting time = completed time - burst time - arrival time
                processes[minIdx][4] = sec - processes[minIdx][2] - processes[minIdx][1];

                if (processes[minIdx][4] < 0)
                    processes[minIdx][4] = 0;
            }
        }
    }

    private static void findTurnAroundTime(int[][] processes, int n) {
        for (int i = 0; i < n; i++) {
            // Turn Around Time = Waiting Time + Burst Time
            processes[i][5] = processes[i][4] + processes[i][2];
        }
    }
}
