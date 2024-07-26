package twitter_simplificado.api.domain.tweet;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import twitter_simplificado.api.DTOs.TweetCreateDTO;

import java.time.LocalDateTime;

@Entity
@Table(name =  "tb_tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @CreatedDate
    private LocalDateTime creationTimestamp;
    private Integer likesCount;
    private Boolean active = true;

    public Tweet() {
    }

    public Tweet(TweetCreateDTO data) {
        this.content = data.content();
        this.likesCount = 0;
        this.active = true;
        this.creationTimestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(LocalDateTime creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void excluir() {
        this.active = false;
    }
}
