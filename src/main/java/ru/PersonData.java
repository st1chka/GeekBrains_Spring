package ru;



/**
 * Данный класс является моделью, чьи
 * геттеры и сеттеры связаны с html.jsp
 */
public class PersonData {

    private String name;

    private String message;

    private String mail;

    public PersonData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMessage() {
        return message;
    }

    public String getMail() {
        return mail;
    }
}
