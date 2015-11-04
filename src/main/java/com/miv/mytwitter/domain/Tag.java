package com.miv.mytwitter.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Tags")
public class Tag extends AbstractBaseEntity {
    @Column(unique = true, nullable = false)
    private String value;

    protected Tag() {
    }

    public Tag(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        return value.equals(tag.value);

    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Tag{" +
                "value='" + value + '\'' +
                '}';
    }

}
