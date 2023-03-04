package notes;

import notes.controller.NoteController;
import notes.views.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Date.getDate();
        NoteController main = context.getBean(NoteController.class);
        main.getProcess();
    }
}
