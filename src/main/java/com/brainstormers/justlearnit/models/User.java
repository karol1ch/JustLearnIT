package com.brainstormers.justlearnit.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "justlearnit")
public class User {


    private String username;

    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;

    private int enabled;

    @Transient
    @NotEmpty
    private String oldPassword;

    @Transient
    @NotEmpty
    private String confirmPassword;

    private UserDetail userDetailByUsername;


    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "enabled")
    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username, password, enabled);
    }

    @OneToOne(mappedBy = "usersByUsername")
    public UserDetail getUserDetailByUsername() {
        return userDetailByUsername;
    }

    public void setUserDetailByUsername(UserDetail userDetailByUsername) {
        this.userDetailByUsername = userDetailByUsername;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", enabled=" + enabled +
                ", userDetailByUsername=" + userDetailByUsername +
                '}';
    }

    @Transient
    public String getOldPassword() {
        return oldPassword;
    }
    @Transient
    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }
    @Transient
    public String getConfirmPassword() {
        return confirmPassword;
    }
    @Transient
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}