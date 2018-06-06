package com.brainstormers.justlearnit.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

public class UserSelectedCategoryPK implements Serializable {
    private String username;
    private Category category;

    public UserSelectedCategoryPK() {

    }

    public UserSelectedCategoryPK(String username, Category category) {
        this.username = username;
        this.category = category;
    }

    @Column(name = "username")
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "category_name", referencedColumnName = "name", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSelectedCategoryPK that = (UserSelectedCategoryPK) o;
        return Objects.equals(username, that.username) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, category);
    }
}
