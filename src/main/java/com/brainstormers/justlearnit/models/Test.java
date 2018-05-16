package com.brainstormers.justlearnit.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "test", schema = "public", catalog = "justlearnit")
public class Test {
    private int id;
    private int number;
    private boolean isOpen;
    private String input;
    private String output;
    private Problem problemByProblemId;

    public Test() {
        input = "Sample input is not available.";
        output = "Sample output is not available.";
    }

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
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "is_open")
    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Basic
    @Column(name = "input")
    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    @Basic
    @Column(name = "output")
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test that = (Test) o;
        return id == that.id &&
                number == that.number &&
                isOpen == that.isOpen &&
                Objects.equals(input, that.input) &&
                Objects.equals(output, that.output);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, number, isOpen, input, output);
    }

    @ManyToOne
    @JoinColumn(name = "problem_id", referencedColumnName = "id", nullable = false)
    public Problem getProblemByProblemId() {
        return problemByProblemId;
    }

    public void setProblemByProblemId(Problem problemByProblemId) {
        this.problemByProblemId = problemByProblemId;
    }
}
