package notes.entity;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Note {

    private String title;
    private String text;

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }
}
