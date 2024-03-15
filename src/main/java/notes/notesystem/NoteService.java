package notes.notesystem;

import notes.entity.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NoteService {
    private final List<Note> notes = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void addNote() {
        System.out.print("Введите заголовок заметки: ");
        String title = scanner.nextLine();
        System.out.println("Введите текст заметки (для завершения введите \"end\"): ");
        StringBuilder text = new StringBuilder();
        String line;
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            text.append(line).append("\n");
        }
        notes.add(new Note(title, text.toString()));
        System.out.println("Заметка успешно добавлена.");
    }

    public void viewNotes() {
        System.out.println("Список заметок: ");
        for (int i = 0; i < notes.size(); i++) {
            System.out.println((i + 1) + ". " + notes.get(i).getTitle());
        }
        if (notes.isEmpty()) {
            System.out.println("Список заметок пуст");
            return;
        }
        System.out.print("Выберите действие (введите номер): ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice > 0 && choice <= notes.size()) {
            System.out.println("Заголовок: " + notes.get(choice - 1).getTitle());
            System.out.println("Текст: \n" + notes.get(choice - 1).getText());
        } else {
            System.out.println("Неверный номер заметки.");
        }
    }

    public void editNote() {
        viewNotes();
        System.out.print("Введите номер заметки для редактирования: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice > 0 && choice <= notes.size()) {
            System.out.println("Введите текст заметки (для завершения введите \"end\"): ");
            StringBuilder newText = new StringBuilder();
            String line;
            while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
                newText.append(line).append("\n");
            }
            notes.get(choice - 1).setText(newText.toString());
            System.out.println("Заметка успешно отредактирована.");
        } else {
            System.out.println("Неверный номер заметки.");
        }
    }

    public void deleteNote() {
        viewNotes();
        System.out.print("Введите номер заметки для удаления: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice > 0 && choice <= notes.size()) {
            Note deletedNote = notes.remove(choice - 1);
            System.out.println("Заметка " + deletedNote.getTitle() + " успешно удалена.");
        } else {
            System.out.println("Неверный номер заметки.");
        }
    }
}
