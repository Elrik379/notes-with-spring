package notes.views;

import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {
    public static final String COLOR_GREEN = "\u001b[38;5;118m";

    public static void getDate() {
        PrintStream printStream = new PrintStream(System.out);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy года");
        LocalDate date = LocalDate.now();
        printStream.println(COLOR_GREEN + dateTimeFormatter.format(date));
        printStream.println(COLOR_GREEN + "С возвращением!");
    }

}