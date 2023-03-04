package notes.controller;

import notes.model.Note;
import notes.service.NoteService;
import org.springframework.stereotype.Controller;

import java.io.PrintStream;
import java.util.Scanner;

@Controller
public class NoteController {
    private static PrintStream printStream = new PrintStream(System.out);
    public static final String COLOR_BLUE = "\u001B[34m";
    public static final String COLOR_GREEN = "\u001b[38;5;118m";

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    public void getProcess() {
        Scanner scanner = new Scanner(System.in);
        boolean cycle = true;
        while (cycle) {
            printStream.println(COLOR_BLUE + """
                            Для выбора одного из вариантов введите его число
                            1 - Написать заметку
                            2 - Показать все заметки
                            3 - Редактировать заметку
                            4 - Удалить заметку
                            5 - Завершить работу и сохранить заметки
                            6 - Информация о приложении
                            """);
            int temp = scanner.nextInt();
            switch (temp) {
                case 1 -> noteWrite();
                case 2 -> showAllNote();
                case 3 -> editNote();
                case 4 -> removeNote();
                case 5 -> {
                    noteService.saveNoteList();
                    cycle = false;
                }
                case 6 -> getInfo();
            }
        }
    }

    public void editNote(){

        Scanner scanner = new Scanner(System.in);
        printStream.println(COLOR_BLUE + "Введите название заметки для редактирования");
        String noteEdit= scanner.nextLine();
        for(Note note: noteService.getArrayListNote()){
            if(note.getNoteName().equals(noteEdit)){
                printStream.println( COLOR_BLUE + "Предыдущий текст заметки: " + note.getNoteContent()
                + "\nВведите новый текст заметки");
                String noteWrite = scanner.nextLine();
                note.setNoteContent(noteWrite);
                noteService.editNoteInList(note);
            }
        }
    }

    public void noteWrite() {
        Scanner scanner = new Scanner(System.in);
        printStream.println(COLOR_BLUE + "Введите имя заметки, не больше 40 символов");
        String name = scanner.nextLine();
        printStream.println(COLOR_BLUE + "Введите заметку");
        String noteWrite = scanner.nextLine();
        Note newNote = new Note(name, noteWrite);
        noteService.addNoteInList(newNote);
    }

    public void showAllNote() {
        for (Note note : noteService.getArrayListNote()) {
            printStream.println(COLOR_GREEN + note.getNoteName() + "\n" + note.getNoteContent() + "\n");
        }
    }

    public void removeNote() {
        Scanner scanner = new Scanner(System.in);
        printStream.println(COLOR_BLUE + "Введите название заметки для удаления");
        String noteRemove = scanner.nextLine();
        noteService.getArrayListNote().removeIf(note -> note.getNoteName().equals(noteRemove));
    }

    public void getInfo(){
        printStream.println(COLOR_GREEN + "Общее количество заметок: " + noteService.getArrayListNote().size()
        + "\nРазработчик: Юсупов Эдуард");
    }

}
