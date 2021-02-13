package model;

import java.util.ArrayList;
import java.util.List;

// Represents a list of notes about a book
public class NotesList {
    private Boolean isFinished;
    private List<Notes> notesList;

    public NotesList() {
        notesList = new ArrayList<>();
        isFinished = false;
    }

    public void addNoteBlocks(Notes notes) {
        this.notesList.add(notes);
    }

    //EFFECTS: update status of notes
    public void updateNotes(Boolean isFinished) {
        this.isFinished = isFinished;
    }

    public Boolean getIsFinished() {
        return isFinished;
    }
}
