package com.tommisaarnio.ostoslista;

import java.io.Serializable;

public class Stuff implements Serializable {
    private String name;
    private String note;

    protected static final long serialVersionUID = 2149215;


    public Stuff(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public String getNote() {
        return note;
    }

}