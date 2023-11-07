import java.util.Scanner;

public class fcfs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of processes
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] completionTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];

        // Input arrival times and burst times for each process
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time for Process P" + (i + 1) + ": ");
            arrivalTime[i] = scanner.nextInt();
            System.out.print("Enter burst time for Process P" + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();
        }

        scanner.close();

        // Calculate completion times
        completionTime[0] = arrivalTime[0] + burstTime[0];
        for (int i = 1; i < n; i++) {
            if (arrivalTime[i] > completionTime[i - 1]) {
                completionTime[i] = arrivalTime[i] + burstTime[i];
            } else {
                completionTime[i] = completionTime[i - 1] + burstTime[i];
            }
        }

        // Calculate turnaround times and waiting times
        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = completionTime[i] - arrivalTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
        }

        // Display results
        System.out.println("Process\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
        for (int i = 0; i < n; i++) {
            System.out.println("P" + (i + 1) + "\t\t" + arrivalTime[i] + "\t\t\t" + burstTime[i] + "\t\t\t" + completionTime[i] + "\t\t\t" + turnaroundTime[i] + "\t\t\t" + waitingTime[i]);
        }
    }
}
