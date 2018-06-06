package com.brainstormers.justlearnit.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_selected_category", schema = "public", catalog = "justlearnit")
@IdClass(UserSelectedCategoryPK.class)
public class UserSelectedCategory {
    private String username;
    private Category category;
    private boolean completed;

    public UserSelectedCategory() {

    }

    public UserSelectedCategory(String username, Category category) {
        this.username = username;
        this.category = category;
        this.completed = false;
    }

    @Id
    @Column(name = "username")
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

    @Basic
    @Column(name = "completed")
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSelectedCategory that = (UserSelectedCategory) o;
        return completed == that.completed &&
                Objects.equals(username, that.username) &&
                Objects.equals(category, that.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, category, completed);
    }

}
