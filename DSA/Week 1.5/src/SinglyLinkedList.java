public class SinglyLinkedList {
    private Node head;

    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }


    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }


    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println("ID: " + current.task.getTaskId() + ", Name: " + current.task.getTaskName() + ", Status: " + current.task.getStatus());
            current = current.next;
        }
    }


    public void deleteTask(String taskId) {
        if (head == null) {
            return;
        }

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.task.getTaskId().equals(taskId)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        Task t1 = new Task("001", "Task One", "Incomplete");
        Task t2 = new Task("002", "Task Two", "Complete");
        Task t3 = new Task("003", "Task Three", "Incomplete");

        taskList.addTask(t1);
        taskList.addTask(t2);
        taskList.addTask(t3);

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearch for Task with ID 002:");
        Task task = taskList.searchTask("002");
        if (task != null) {
            System.out.println("Found: " + task.getTaskName() + ", " + task.getStatus());
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDelete Task with ID 002:");
        taskList.deleteTask("002");

        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();
    }
}
