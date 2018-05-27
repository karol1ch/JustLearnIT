package com.brainstormers.justlearnit.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_completed_topic", schema = "public", catalog = "justlearnit")
@IdClass(UserCompletedTopicPK.class)
public class UserCompletedTopic {
    private Topic topic;
    private String username;
    private int percentageScore;

    @Id
    @ManyToOne
    @JoinColumn(name = "topic_id", referencedColumnName = "id", nullable = false)
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "percentage_score")
    public int getPercentageScore() {
        return percentageScore;
    }

    public void setPercentageScore(int percentageScore) {
        this.percentageScore = percentageScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCompletedTopic that = (UserCompletedTopic) o;
        return Objects.equals(topic, that.topic) &&
                Objects.equals(username, that.username) &&
                percentageScore == that.percentageScore;
    }

    @Override
    public int hashCode() {

        return Objects.hash(topic, username, percentageScore);
    }


}
