package com.brainstormers.justlearnit.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "problem")
public class Problem {
    private int id;
    private String name;
    private String content;
    private Category category;
    private User user;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "category")
    public Category getCategory() {
        return category;
    }


    @OneToOne
    @JoinColumn(name = "author")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return id == problem.id &&
                Objects.equals(name, problem.name) &&
                Objects.equals(content, problem.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, content);
    }

    @Override
    public String toString() {
        return "Problem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", user=" + user +
                '}';
    }


}
