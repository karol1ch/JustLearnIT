package com.brainstormers.justlearnit.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "problem", schema = "public", catalog = "justlearnit")
public class Problem {
    private int id;
    private String name;
    private String content;
    private Category category;
    private String inputDescription;
    private String outputDescription;
    private int numberOfAcceptedSolutions;
    private String difficulty;
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

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "input_description")
    public String getInputDescription() {
        return inputDescription;
    }

    public void setInputDescription(String inputDescription) {
        this.inputDescription = inputDescription;
    }

    @Basic
    @Column(name = "output_description")
    public String getOutputDescription() {
        return outputDescription;
    }

    public void setOutputDescription(String outputDescription) {
        this.outputDescription = outputDescription;
    }

    @Basic
    @Column(name = "number_of_accepted_solutions")
    public int getNumberOfAcceptedSolutions() {
        return numberOfAcceptedSolutions;
    }

    public void setNumberOfAcceptedSolutions(int numberOfAcceptedSolutions) {
        this.numberOfAcceptedSolutions = numberOfAcceptedSolutions;
    }

    @Basic
    @Column(name = "difficulty")
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem that = (Problem) o;
        return id == that.id &&
                numberOfAcceptedSolutions == that.numberOfAcceptedSolutions &&
                Objects.equals(name, that.name) &&
                Objects.equals(content, that.content) &&
                Objects.equals(inputDescription, that.inputDescription) &&
                Objects.equals(outputDescription, that.outputDescription) &&
                Objects.equals(difficulty, that.difficulty);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, content, inputDescription, outputDescription, numberOfAcceptedSolutions, difficulty);
    }

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "username", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User usersByAuthor) {
        this.user = usersByAuthor;
    }

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "category_name")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
