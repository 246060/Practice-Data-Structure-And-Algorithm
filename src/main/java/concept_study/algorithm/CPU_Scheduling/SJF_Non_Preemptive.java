package concept_study.algorithm.CPU_Scheduling;

import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/program-for-shortest-job-first-or-sjf-cpu-scheduling-set-1-non-preemptive/?ref=rp
public class SJF_Non_Preemptive {
    public static void main(String[] args) {
        int n = 4;
        int[][] processes = {
                // { process id, arrival time, burst time, complete time, waiting time, turn around time }
                {1, 5, 3, 0, 0, 0},
                {2, 0, 4, 0, 0, 0},
                {3, 7, 4, 0, 0, 0},
                {4, 7, 2, 0, 0, 0}
        };

        arrangeArrival(n, processes);
        completionTime(n, processes);

        System.out.println("\nProcess ID \t Arrival Time \t Burst Time \t Completed Time \t Waiting Time \t TurnAround Time");
        for (int i = 0; i < n; i++) {
            System.out.printf("\t%d\t\t\t\t%d\t\t\t\t%d\t\t\t\t%d\t\t\t\t%d\t\t\t\t%d\n",
                    processes[i][0], processes[i][1], processes[i][2], processes[i][3], processes[i][4], processes[i][5]
            );
        }
    }

    private static void arrangeArrival(int n, int[][] processes) {
        Arrays.sort(processes, Comparator.comparingInt(v -> v[1]));
    }

    private static void completionTime(int n, int[][] processes) {
        // processes array element :
        // { process id, arrival time, burst time, complete time, waiting time, turn around time }

        for (int i = 0; i < n; i++) {
            int minIdx = findMinBurstTimeProcessIndexOfArrivedProcesses(processes, n, i);

            if (minIdx == -1) {

                // complete time = arrival time + burst time
                processes[i][3] = processes[i][1] + processes[i][2];

                // turn around time = complete time - arrival time
                processes[i][5] = processes[i][3] - processes[i][1];

                // waiting time = turn around time - burst time
                processes[i][4] = processes[i][5] - processes[i][2];

            } else {

                // current process complete time = complete time of previous process + current process burst time
                processes[minIdx][3] = processes[i - 1][3] + processes[minIdx][2];

                // turn around time = complete time - arrival time
                processes[minIdx][5] = processes[minIdx][3] - processes[minIdx][1];

                // waiting time = turn around time - burst time
                processes[minIdx][4] = processes[minIdx][5] - processes[minIdx][2];

                swap(processes, i, minIdx);
            }
        }
    }

    private static int findMinBurstTimeProcessIndexOfArrivedProcesses(int[][] processes, int n, int s) {
        int minBurstTimeIdx = -1;
        int minBurstTime = Integer.MAX_VALUE;

        if (s == 0)
            return minBurstTimeIdx;

        for (int j = s; j < n; j++) {
            int prevCompletedTime = processes[s - 1][3];
            int candidateArrivalTime = processes[j][1];
            int candidateBurstTime = processes[j][2];

            // Find the one with the smallest burst time among the processes
            // that arrived before the previous process was terminated

            if (prevCompletedTime >= candidateArrivalTime && minBurstTime >= candidateBurstTime) {
                minBurstTime = candidateBurstTime;
                minBurstTimeIdx = j;
            }
        }

        return minBurstTimeIdx;
    }

    private static void swap(int[][] processes, int i, int minIdx) {
        for (int j = 0; j < 6; j++) {
            int tmp = processes[minIdx][j];
            processes[minIdx][j] = processes[i][j];
            processes[i][j] = tmp;
        }
    }
}
