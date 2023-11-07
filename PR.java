import java.util.Scanner;

public class PR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of processes
        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int[] burstTime = new int[n];
        int[] priority = new int[n];
        int[] processOrder = new int[n];
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];

        // Input burst times and priorities for each process
        for (int i = 0; i < n; i++) {
            System.out.print("Enter burst time for Process P" + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();
            System.out.print("Enter priority for Process P" + (i + 1) + ": ");
            priority[i] = scanner.nextInt();
            processOrder[i] = i;
        }

        scanner.close();

        // Sort processes based on priority (lower value indicates higher priority)
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (priority[j] > priority[j + 1]) {
                    // Swap priority
                    int tempPriority = priority[j];
                    priority[j] = priority[j + 1];
                    priority[j + 1] = tempPriority;

                    // Swap burst time
                    int tempBurstTime = burstTime[j];
                    burstTime[j] = burstTime[j + 1];
                    burstTime[j + 1] = tempBurstTime;

                    // Swap process order
                    int tempOrder = processOrder[j];
                    processOrder[j] = processOrder[j + 1];
                    processOrder[j + 1] = tempOrder;
                }
            }
        }

        // Calculate waiting and turnaround times
        waitingTime[0] = 0;
        for (int i = 1; i < n; i++) {
            waitingTime[i] = waitingTime[i - 1] + burstTime[i - 1];
            turnaroundTime[i] = waitingTime[i] + burstTime[i];
        }

        // Display results
        System.out.println("Process\tPriority\tBurst Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < n; i++) {
            int processNumber = processOrder[i] + 1;
            System.out.println("P" + processNumber + "\t\t" + priority[i] + "\t\t\t" + burstTime[i] + "\t\t\t" + waitingTime[i] + "\t\t\t" + turnaroundTime[i]);
        }
    }
}
