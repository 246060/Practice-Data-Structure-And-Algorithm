package concept_study.algorithm.CPU_Scheduling;


// https://www.geeksforgeeks.org/program-for-fcfs-cpu-scheduling-set-2-processes-with-different-arrival-times/
public class FCFS_Diff_Arrival_Time {
    public static void main(String[] args) {

        int[] processes = {1, 2, 3};
        int n = processes.length;

        int[] burstTime = {5, 9, 6};
        int[] arrivalTime = {0, 3, 6};

        findAvgTime(processes, n, burstTime, arrivalTime);
    }

    private static void findAvgTime(int[] processes, int n, int[] burstTime, int[] arrivalTime) {

        // Waiting Time -----------------------------------------------------------------------------------
        int[] waitTime = new int[n];
        int[] serviceTime = new int[n];

        serviceTime[0] = arrivalTime[0];
        waitTime[0] = 0;

        for (int i = 1; i < n; i++) {

            // add burst time of previous processes
            serviceTime[i] = serviceTime[i - 1] + burstTime[i - 1];

            // find waiting time for current process = sum - arrivalTime[i]
            int wasted = 0;
            waitTime[i] = serviceTime[i] - arrivalTime[i];

            if (waitTime[i] < 0) {
                wasted = Math.abs(waitTime[i]);
                waitTime[i] = 0;
            }

            serviceTime[i] = serviceTime[i] + wasted;
        }


        // Turn Around Time ------------------------------------------------------------------------------
        int[] turnAroundTime = new int[n];

        for (int i = 0; i < n; i++) {
            turnAroundTime[i] = waitTime[i] + burstTime[i];
        }


        // PRINT -----------------------------------------------------------------------------------------
        System.out.print("Processes  Burst Time  Arrival Time  Waiting Time  Turn-Around Time  Completion Time \n");

        int totalWaitTime = 0;
        int totalTurnAroundTime = 0;

        for (int i = 0; i < n; i++) {
            totalWaitTime += waitTime[i];
            totalTurnAroundTime += turnAroundTime[i];

            int completedTime = turnAroundTime[i] + arrivalTime[i];

            System.out.printf("\t%d\t\t", processes[i]);
            System.out.printf("\t%d\t\t", burstTime[i]);
            System.out.printf("\t%d\t\t", arrivalTime[i]);
            System.out.printf("\t%d\t\t", waitTime[i]);
            System.out.printf("\t\t%d\t\t", turnAroundTime[i]);
            System.out.printf("\t\t%d\t\t", completedTime);
            System.out.println();
        }
        System.out.printf("\nAverage Waiting Time=%f", totalWaitTime * 1.0 / n);
        System.out.printf("\nAverage Turn Around Time=%f", totalTurnAroundTime * 1.0 / n);
    }
}
