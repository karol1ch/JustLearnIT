package com.brainstormers.justlearnit.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "submit_result", schema = "public", catalog = "justlearnit")
@IdClass(SubmitResultPK.class)
public class SubmitResult {
    private int submitId;
    private Integer executionReturnCode;
    private String executionStdout;
    private String executionStderr;
    private Integer executionTimeMs;
    private String status;
    private Test test;

    @Id
    @Column(name = "submit_id")
    public int getSubmitId() {
        return submitId;
    }

    public void setSubmitId(int submitId) {
        this.submitId = submitId;
    }

    @Basic
    @Column(name = "execution_return_code")
    public Integer getExecutionReturnCode() {
        return executionReturnCode;
    }

    public void setExecutionReturnCode(Integer executionReturnCode) {
        this.executionReturnCode = executionReturnCode;
    }

    @Basic
    @Column(name = "execution_stdout")
    public String getExecutionStdout() {
        return executionStdout;
    }

    public void setExecutionStdout(String executionStdout) {
        this.executionStdout = executionStdout;
    }

    @Basic
    @Column(name = "execution_stderr")
    public String getExecutionStderr() {
        return executionStderr;
    }

    public void setExecutionStderr(String executionStderr) {
        this.executionStderr = executionStderr;
    }

    @Basic
    @Column(name = "execution_time_ms")
    public Integer getExecutionTimeMs() {
        return executionTimeMs;
    }

    public void setExecutionTimeMs(Integer executionTimeMs) {
        this.executionTimeMs = executionTimeMs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubmitResult that = (SubmitResult) o;
        return submitId == that.submitId &&
                Objects.equals(test, that.test) &&
                Objects.equals(executionReturnCode, that.executionReturnCode) &&
                Objects.equals(executionStdout, that.executionStdout) &&
                Objects.equals(executionStderr, that.executionStderr) &&
                Objects.equals(executionTimeMs, that.executionTimeMs);
    }

    @Override
    public int hashCode() {

        return Objects.hash(submitId, test, executionReturnCode, executionStdout, executionStderr, executionTimeMs);
    }

    @Basic
    @Column(name = "status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

}
