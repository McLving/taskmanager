import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Adicionar Tarefa");
            System.out.println("2. Listar Tarefas");
            System.out.println("3. Atualizar Tarefa");
            System.out.println("4. Remover Tarefa");
            System.out.println("5. Marcar Tarefa como Concluída");
            System.out.println("6. Filtrar Tarefas por Status");
            System.out.println("7. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (choice) {
                case 1:
                    System.out.println("Título:");
                    String title = scanner.nextLine();
                    System.out.println("Descrição:");
                    String description = scanner.nextLine();
                    System.out.println("Prioridade:");
                    String priority = scanner.nextLine();
                    taskManager.addTask(new Task(title, description, priority));
                    break;
                case 2:
                    for (Task task : taskManager.getAllTasks()) {
                        System.out.println(task);
                    }
                    break;
                case 3:
                    System.out.println("Índice da Tarefa:");
                    int indexToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Novo Título:");
                    String newTitle = scanner.nextLine();
                    System.out.println("Nova Descrição:");
                    String newDescription = scanner.nextLine();
                    System.out.println("Nova Prioridade:");
                    String newPriority = scanner.nextLine();
                    Task updatedTask = new Task(newTitle, newDescription, newPriority);
                    taskManager.updateTask(indexToUpdate, updatedTask);
                    break;
                case 4:
                    System.out.println("Índice da Tarefa:");
                    int indexToRemove = scanner.nextInt();
                    taskManager.removeTask(indexToRemove);
                    break;
                case 5:
                    System.out.println("Índice da Tarefa:");
                    int indexToComplete = scanner.nextInt();
                    taskManager.markTaskAsCompleted(indexToComplete);
                    break;
                case 6:
                    System.out.println("Mostrar tarefas concluídas? (true/false):");
                    boolean showCompleted = scanner.nextBoolean();
                    for (Task task : taskManager.filterTasksByStatus(showCompleted)) {
                        System.out.println(task);
                    }
                    break;
                case 7:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
