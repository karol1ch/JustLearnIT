package com.brainstormers.justlearnit.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

public class SubmitResultPK implements Serializable {
    private int submitId;
    private Test test;

    @Id
    @Column(name = "submit_id")
    public int getSubmitId() {
        return submitId;
    }

    public void setSubmitId(int submitId) {
        this.submitId = submitId;
    }

    @Id
    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id", nullable = false)
    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmitResultPK that = (SubmitResultPK) o;
        return submitId == that.submitId &&
                Objects.equals(test, that.test);
    }

    @Override
    public int hashCode() {

        return Objects.hash(submitId, test);
    }
}
