package notes.notesystem;

import java.util.Scanner;

public class ConsoleInterface {
    private final NoteService noteService = new NoteService();
    private final Scanner scanner = new Scanner(System.in);
    private static void getUserName() {
        System.out.println("Добро пожаловать в приложение Notes!");
        System.out.print("Как вас зовут? ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        System.out.println("Приветствую, " + userName + "!");
    }

    public void start() {
        getUserName();
        int choice;
        do {
            System.out.println("1. Добавить заметку");
            System.out.println("2. Просмотреть заметки");
            System.out.println("3. Редактировать заметку");
            System.out.println("4. Удалить заметку");
            System.out.println("5. Выход");
            System.out.print("Выберите действие (введите номер): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    noteService.addNote();
                    break;
                case 2:
                    noteService.viewNotes();
                    break;
                case 3:
                    noteService.editNote();
                    break;
                case 4:
                    noteService.deleteNote();
                    break;
                case 5:
                    System.out.println("До свидания!");
                    break;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, попробуйте еще раз.");
            }
        } while (choice != 5);
    }
}
