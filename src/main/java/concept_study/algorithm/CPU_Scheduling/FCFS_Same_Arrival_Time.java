package concept_study.algorithm.CPU_Scheduling;


// https://www.geeksforgeeks.org/program-for-fcfs-cpu-scheduling-set-1/
public class FCFS_Same_Arrival_Time {
    // assumed arrival times as 0, so turn around and completion times are same.

    public static void main(String[] args) {
        int n = 3;
        int[] burstTime = {10, 5, 8};
        // int[] burstTime = {5, 8, 10};

        int[] waitingTime = new int[n];
        int[] turnAroundTime = new int[n];

        int totalWaitingTime = 0;
        int totalTurnAroundTime = 0;

        waitingTime[0] = 0;
        for (int i = 1; i < n; i++)
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];

        for (int i = 0; i < n; i++)
            turnAroundTime[i] = burstTime[i] + waitingTime[i];

        System.out.println("\nProcesses BurstTime WaitingTime TurnAroundTime");

        for (int i = 0; i < n; i++) {
            totalWaitingTime += waitingTime[i];
            totalTurnAroundTime += turnAroundTime[i];

            System.out.printf("   %d  ", (i + 1));
            System.out.printf("\t\t %d", burstTime[i]);
            System.out.printf("\t\t\t %d", waitingTime[i]);
            System.out.printf("\t\t\t\t %d\n", turnAroundTime[i]);
        }
        System.out.printf("\nAverage Waiting Time = %f\n", totalWaitingTime * 1.0 / n);
        System.out.printf("Average Turn Around Time = %f\n", totalTurnAroundTime * 1.0 / n);
    }
}
