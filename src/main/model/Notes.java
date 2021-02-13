package model;

import java.util.List;

//represents notes taken on a book
public class Notes {
    private String heading;
    private String notes;

    public Notes(String heading, String notes) {
        this.heading = heading;
        this.notes = notes;
    }

    //EFFECTS:
    public void setHeading(String heading) {
        this.heading = heading;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getHeading() {
        return heading;
    }

    public String getNotes() {
        return notes;
    }
}