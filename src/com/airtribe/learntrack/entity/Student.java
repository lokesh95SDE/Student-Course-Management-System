package com.airtribe.learntrack.entity;

public class Student extends Person{
    private String batch;
    private boolean active;
    // with calling Email
    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email); // inheritance
        this.batch = batch;
        this.active = true;
    }

    // Constructor Overloading --> Without calling Email
    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName, null);
        this.active = true;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    @Override
    public String getDisplayName(){
      return  super.getDisplayName();
    }
}
