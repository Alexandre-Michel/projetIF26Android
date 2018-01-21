package fr.utt.if26.todoist;

import java.util.Date;

/**
 * Created by Alexandre on 21/01/2018.
 */

public class ToDo {
    private String nom;
    private String detail;
    private Date date;

    public ToDo(String nom, String detail, Date date) {
        this.nom = nom;
        this.detail = detail;
        this.date = date;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
