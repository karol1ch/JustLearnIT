package com.brainstormers.justlearnit.models;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "submit", schema = "public", catalog = "justlearnit")
public class Submit {
    private int id;
    private Timestamp receivedTime;
    private boolean processed;
    private String compilerOutput;
    private String codeContent;
    private Integer compilationReturnCode;
    private String compilationStdout;
    private String compilationStderr;
    private ProgrammingLanguage programmingLanguageByProgrammingLanguageName;
    private User user;
    private Problem problem;

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
    @Column(name = "received_time")
    public Timestamp getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Timestamp receivedTime) {
        this.receivedTime = receivedTime;
    }

    @Basic
    @Column(name = "processed")
    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Basic
    @Column(name = "compiler_output")
    public String getCompilerOutput() {
        return compilerOutput;
    }

    public void setCompilerOutput(String compilerOutput) {
        this.compilerOutput = compilerOutput;
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
    @Column(name = "compilation_return_code")
    public Integer getCompilationReturnCode() {
        return compilationReturnCode;
    }

    public void setCompilationReturnCode(Integer compilationReturnCode) {
        this.compilationReturnCode = compilationReturnCode;
    }

    @Basic
    @Column(name = "compilation_stdout")
    public String getCompilationStdout() {
        return compilationStdout;
    }

    public void setCompilationStdout(String compilationStdout) {
        this.compilationStdout = compilationStdout;
    }

    @Basic
    @Column(name = "compilation_stderr")
    public String getCompilationStderr() {
        return compilationStderr;
    }

    public void setCompilationStderr(String compilationStderr) {
        this.compilationStderr = compilationStderr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Submit that = (Submit) o;
        return id == that.id &&
                processed == that.processed &&
                Objects.equals(receivedTime, that.receivedTime) &&
                Objects.equals(compilerOutput, that.compilerOutput) &&
                Objects.equals(codeContent, that.codeContent) &&
                Objects.equals(compilationReturnCode, that.compilationReturnCode) &&
                Objects.equals(compilationStdout, that.compilationStdout) &&
                Objects.equals(compilationStderr, that.compilationStderr);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, receivedTime, processed, compilerOutput, codeContent, compilationReturnCode, compilationStdout, compilationStderr);
    }

    @ManyToOne
    @JoinColumn(name = "programming_language_name", referencedColumnName = "name", nullable = false)
    public ProgrammingLanguage getProgrammingLanguageByProgrammingLanguageName() {
        return programmingLanguageByProgrammingLanguageName;
    }

    public void setProgrammingLanguageByProgrammingLanguageName(ProgrammingLanguage programmingLanguageByProgrammingLanguageName) {
        this.programmingLanguageByProgrammingLanguageName = programmingLanguageByProgrammingLanguageName;
    }

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "username", nullable = false)
    public User getUser() {
        return user;
    }

    public void setUser(User usersByAuthor) {
        this.user = usersByAuthor;
    }

    @ManyToOne
    @JoinColumn(name = "problem_id", referencedColumnName = "id", nullable = false)
    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
