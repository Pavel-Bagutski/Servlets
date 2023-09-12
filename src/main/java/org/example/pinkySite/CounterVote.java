package org.example.pinkySite;

import java.util.ArrayList;
import java.util.List;

public class CounterVote {
    String subjectOfVote;
    int count = 1;
    CounterVote (String name){
    this.subjectOfVote = name;
    }

    CounterVote (String name, int count){
        this.subjectOfVote = name;
        this.count = count;
    }

    public String getSubjectOfVote() {
        return subjectOfVote;
    }
    public void setSubjectOfVote(String subjectOfVote) {
        this.subjectOfVote = subjectOfVote;
    }
    public int getCount() {
        return count;
    }
    public void increment() {
        this.count ++;
    }
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CounterVote)) {
            return false;
        }
        CounterVote other =(CounterVote)object;
        return subjectOfVote.equals(other.subjectOfVote);
    }
    @Override
    public String toString() {
        return "( it is  " + subjectOfVote  +
                "  vote:   " + count + ')';
    }

    public void setCount(int count) {
        this.count = count;
    }
}

