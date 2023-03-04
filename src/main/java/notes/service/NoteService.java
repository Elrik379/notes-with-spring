package notes.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import notes.model.Note;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@JsonAutoDetect
public class NoteService {

    static {
        loadNoteList();
    }

    @JsonDeserialize(as = ArrayList.class)
    private static List<Note> arrayListNote;

    public NoteService() {
    }

    public List<Note> getArrayListNote() {
        return arrayListNote;
    }

    public void addNoteInList(Note note) {
        arrayListNote.add(note);
    }

    public void editNoteInList(Note note) {
        for (Note temp : arrayListNote) {
            if (temp.getNoteName().equals(note.getNoteName())) {
                arrayListNote.set(arrayListNote.indexOf(temp), note);
            }
        }

    }

    public void saveNoteList() {
        try (FileWriter writer = new FileWriter("save.txt")) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(writer, arrayListNote);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadNoteList() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("save.txt"))) {
            String temp = bufferedReader.readLine();
            if (temp == null) {
                arrayListNote = new ArrayList<>();
                return;
            }
            ObjectMapper mapper = new ObjectMapper();
            CollectionType type = TypeFactory.defaultInstance()
                    .constructCollectionType(ArrayList.class, Note.class);
            arrayListNote = mapper.readValue(temp, type);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
