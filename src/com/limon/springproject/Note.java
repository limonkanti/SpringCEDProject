
package com.limon.springproject;

public class Note 
{
    
     private int id;
    private String date;
    private String month;
    private String note;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Note(int id, String date, String month, String note) {
        this.id = id;
        this.date = date;
        this.month = month;
        this.note = note;
    }
    
  
}
