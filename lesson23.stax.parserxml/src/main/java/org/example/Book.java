package org.example;

public class Book {
    private String firstName;
    private String lastName;
    private String title;
    private StringBuilder lines;

    public Book() {
        lines = new StringBuilder();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addLine(String line) {
        lines.append(line).append("\n");
    }

    public String getFileName() {
        return firstName + "_" + lastName + "_" + title + ".txt";
    }

    public String getLines() {
        return lines.toString();
    }
}