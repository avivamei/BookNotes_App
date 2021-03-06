package model;

import exceptions.StringTooShortException;
import org.json.JSONObject;
import persistence.Writable;

// Represents notes about a book
public class Notes implements Writable {
    private String heading;
    private String notes;

    //REQUIRES: heading and notes are non-zero in length
    //EFFECTS: constructs a note with a heading and content
    public Notes(String heading, String notes) throws StringTooShortException {
        if (!heading.isEmpty() && !notes.isEmpty()) {
            this.heading = heading;
            this.notes = notes;
        } else {
            throw new StringTooShortException();
        }
    }

    //EFFECTS: sets the heading of a note
    public void setHeading(String heading) throws StringTooShortException {
        if (!heading.isEmpty()) {
            this.heading = heading;
        } else {
            throw new StringTooShortException();
        }
    }

    //EFFECTS: sets the content of a note
    public void setNotes(String notes) throws StringTooShortException {
        if (!notes.isEmpty()) {
            this.notes = notes;
        } else {
            throw new StringTooShortException();
        }
    }

    //EFFECTS: returns the heading that the note is a part of
    public String getHeading() {
        return heading;
    }

    //EFFECTS: returns the contents of a note
    public String getNotes() {
        return notes;
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("heading", heading);
        json.put("notes", notes);
        return json;
    }
}