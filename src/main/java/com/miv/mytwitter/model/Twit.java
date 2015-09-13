package com.miv.mytwitter.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Twits")
public class Twit extends  BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private User owner;

    public Twit() {
    }

    public Twit( User owner, String text) {

        this.owner = owner;
        this.text = text;

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return super.getId();
    }

    public void setId(String id) {
        super.setId(id);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Twit twit = (Twit) o;

        if (getId() != null ? !getId().equals(twit.getId()) : twit.getId() != null) return false;
        return !(owner != null ? !owner.equals(twit.owner) : twit.owner != null);

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        return result;
    }

    @Override
    public String toString() {
        return "Twit{" +
                ", text='" + text + '\'' +
                ", owner=" + owner +
                '}';
    }
}
