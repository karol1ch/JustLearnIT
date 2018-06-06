package com.brainstormers.justlearnit.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Topic {
    private int id;
    private String name;
    private String theory;
    private Category category;
    private String codeExample;
    private String codeExplanation;

    @Id
    @Column(name = "id")
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
    @Column(name = "theory")
    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return id == topic.id &&
                Objects.equals(name, topic.name) &&
                Objects.equals(theory, topic.theory) &&
                Objects.equals(codeExample, topic.codeExample) &&
                Objects.equals(codeExplanation, topic.codeExplanation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, theory, codeExample, codeExplanation);
    }

    @ManyToOne
    @JoinColumn(name = "category_name", referencedColumnName = "name", nullable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Basic
    @Column(name = "code_example")
    public String getCodeExample() {
        return codeExample;
    }

    public void setCodeExample(String codeExample) {
        this.codeExample = codeExample;
    }

    @Basic
    @Column(name = "code_explanation")
    public String getCodeExplanation() {
        return codeExplanation;
    }

    public void setCodeExplanation(String codeExplanation) {
        this.codeExplanation = codeExplanation;
    }
}
