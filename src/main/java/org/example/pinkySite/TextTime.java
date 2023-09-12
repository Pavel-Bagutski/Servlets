package org.example.pinkySite;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TextTime {
    private String text;
    private long time;

    public TextTime(String text) {
        this.text = text;
        this.time = System.currentTimeMillis();;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public long getTime() {
        return time;
    }


    @Override
    public String toString() {
        return  "   " + text;
    }
}