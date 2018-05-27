package com.brainstormers.justlearnit.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "code_example", schema = "public", catalog = "justlearnit")
public class CodeExample {
    private int id;
    private String codeContent;
    private String codeExplanation;
    private Topic topicByTopicId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "code_content")
    public String getCodeContent() {
        return codeContent;
    }

    public void setCodeContent(String codeContent) {
        this.codeContent = codeContent;
    }

    @Basic
    @Column(name = "code_explanation")
    public String getCodeExplanation() {
        return codeExplanation;
    }

    public void setCodeExplanation(String codeExplanation) {
        this.codeExplanation = codeExplanation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeExample that = (CodeExample) o;
        return id == that.id &&
                Objects.equals(codeContent, that.codeContent) &&
                Objects.equals(codeExplanation, that.codeExplanation);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, codeContent, codeExplanation);
    }

    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id")
    public Topic getTopicByTopicId() {
        return topicByTopicId;
    }

    public void setTopicByTopicId(Topic topicByTopicId) {
        this.topicByTopicId = topicByTopicId;
    }
}
