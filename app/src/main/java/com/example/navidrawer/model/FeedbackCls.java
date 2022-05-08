package com.example.navidrawer.model;

public class FeedbackCls {
    //private String ID;
    private String Name;
    private String Email;
    private String Message;

    public FeedbackCls() {
    }

    public FeedbackCls(String name, String email, String message) {
        Name = name;
        Email = email;
        Message = message;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
