class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class TaskScheduler {
    private TaskNode head;
    private TaskNode currentTask;

    // Add task at the beginning
    public void addAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself for circular structure
        } else {
            TaskNode tail = getTail();
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
    }

    // Add task at the end
    public void addAtEnd(int taskId, String taskName, int priority, String dueDate) {
        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);

        if (head == null) {
            head = newNode;
            head.next = head; // Point to itself for circular structure
        } else {
            TaskNode tail = getTail();
            tail.next = newNode;
            newNode.next = head;
        }
    }

    // Add task at a specific position
    public void addAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            addAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        TaskNode newNode = new TaskNode(taskId, taskName, priority, dueDate);
        TaskNode current = head;

        for (int i = 1; i < position - 1; i++) {
            current = current.next;
            if (current == head) {
                System.out.println("Position out of bounds!");
                return;
            }
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    // Remove a task by Task ID
    public void removeByTaskId(int taskId) {
        if (head == null) {
            System.out.println("No tasks to remove.");
            return;
        }

        TaskNode current = head;
        TaskNode previous = null;

        do {
            if (current.taskId == taskId) {
                if (current == head) {
                    TaskNode tail = getTail();
                    if (head == head.next) { // Only one node in the list
                        head = null;
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                } else {
                    previous.next = current.next;
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View current task and move to the next task
    public void viewAndMoveToNextTask() {
        if (currentTask == null) {
            currentTask = head;
        }

        if (currentTask != null) {
            System.out.println("Current Task: ID: " + currentTask.taskId + ", Name: " + currentTask.taskName +
                    ", Priority: " + currentTask.priority + ", Due Date: " + currentTask.dueDate);
            currentTask = currentTask.next;
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }

        TaskNode current = head;
        System.out.println("All Tasks:");
        do {
            System.out.println("ID: " + current.taskId + ", Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
            current = current.next;
        } while (current != head);
    }

    // Search for tasks by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }

        TaskNode current = head;
        boolean found = false;

        do {
            if (current.priority == priority) {
                System.out.println("Found Task: ID: " + current.taskId + ", Name: " + current.taskName +
                        ", Due Date: " + current.dueDate);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    // Helper method to get the tail of the circular list
    private TaskNode getTail() {
        if (head == null) {
            return null;
        }

        TaskNode current = head;
        while (current.next != head) {
            current = current.next;
        }
        return current;
    }

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Adding tasks
        scheduler.addAtBeginning(1, "Task A", 2, "2025-02-15");
        scheduler.addAtEnd(2, "Task B", 1, "2025-02-16");
        scheduler.addAtPosition(2, 3, "Task C", 3, "2025-02-17");

        // Display all tasks
        scheduler.displayAllTasks();

        // View current task and move to the next task
        scheduler.viewAndMoveToNextTask();
        scheduler.viewAndMoveToNextTask();

        // Search by priority
        scheduler.searchByPriority(1);

        // Remove a task by Task ID
        scheduler.removeByTaskId(3);

        // Display all tasks after removal
        scheduler.displayAllTasks();
    }
}
