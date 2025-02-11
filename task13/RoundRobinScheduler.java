class ProcessNode {
    int processId;
    int burstTime;
    int priority;
    ProcessNode next;

    public ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    private ProcessNode head = null;
    private ProcessNode tail = null;

    // Add a new process at the end of the circular list
    public void addProcess(int processId, int burstTime, int priority) {
        ProcessNode newNode = new ProcessNode(processId, burstTime, priority);
        if (head == null) {
            head = tail = newNode;
            tail.next = head; // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Remove a process by Process ID
    public void removeProcess(int processId) {
        if (head == null) {
            System.out.println("No processes to remove.");
            return;
        }

        ProcessNode current = head;
        ProcessNode previous = null;

        do {
            if (current.processId == processId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    previous.next = current.next;
                }

                if (current == tail) {
                    tail = previous;
                }

                System.out.println("Process " + processId + " removed.");
                return;
            }

            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Process " + processId + " not found.");
    }

    // Simulate the Round Robin Scheduling
    public void roundRobinScheduling(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = 0;

        ProcessNode current = head;

        // Remaining burst times map
        do {
            processCount++;
            current = current.next;
        } while (current != head);

        System.out.println("Round Robin Execution (Time Quantum: " + timeQuantum + " ms)");

        while (processCount > 0) {
            ProcessNode temp = head;

            do {
                if (temp.burstTime > 0) {
                    int executionTime = Math.min(temp.burstTime, timeQuantum);
                    System.out.println("Executing Process " + temp.processId + " for " + executionTime + " ms");

                    temp.burstTime -= executionTime;

                    if (temp.burstTime == 0) {
                        System.out.println("Process " + temp.processId + " completed execution.");
                        processCount--;
                    }
                }
                temp = temp.next;
            } while (temp != head);

            System.out.println("Processes after this round:");
            displayProcesses();
        }

        System.out.println("All processes completed.");
    }

    // Display the list of processes
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        ProcessNode current = head;

        System.out.println("Processes in Circular Queue:");
        do {
            System.out.println("Process ID: " + current.processId + ", Burst Time: " + current.burstTime + ", Priority: " + current.priority);
            current = current.next;
        } while (current != head);
    }

    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes to the scheduler
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 7, 3);

        scheduler.displayProcesses();

        // Simulate round-robin scheduling with a time quantum of 4 ms
        scheduler.roundRobinScheduling(4);
    }
}
