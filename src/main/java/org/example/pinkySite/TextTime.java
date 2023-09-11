package org.example.pinkySite;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TextDataTime {
    private String text;
    private LocalDateTime time;

    public TextDataTime(String text, LocalDateTime time) {
        this.text = text;
        this.time = time;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public static TextDataTime getEarliestMessage(ArrayList<TextDataTime> messages) {
        if (messages.isEmpty()) {
            return null;
        }
        TextDataTime earliest = messages.get(0);
        for (TextDataTime message : messages) {
            if (message.getTime().isBefore(earliest.getTime())) {
                earliest = message;
            }
        }
        return earliest;
    }
}