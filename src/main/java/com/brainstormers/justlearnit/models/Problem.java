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
    private String inputDescription;
    private String outputDescription;
    private int numberOfAcceptedSolutions;
    private String difficulty;

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
    @JoinColumn(name = "category_name")
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

    @Column(name = "input_description")
    public String getInputDescription() {
        return inputDescription;
    }

    public void setInputDescription(String inputDescription) {
        this.inputDescription = inputDescription;
    }

    @Column(name = "output_description", nullable = false)
    public String getOutputDescription() {
        return outputDescription;
    }

    public void setOutputDescription(String outputDescription) {
        this.outputDescription = outputDescription;
    }


    @Column(name = "number_of_accepted_solutions", nullable = false)
    public int getNumberOfAcceptedSolutions() {
        return numberOfAcceptedSolutions;
    }

    public void setNumberOfAcceptedSolutions(int numberOfAcceptedSolutions) {
        this.numberOfAcceptedSolutions = numberOfAcceptedSolutions;
    }


    @Column(name = "difficulty", nullable = false)
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
