package twitter_simplificado.api.DTOs;

import twitter_simplificado.api.domain.tweet.Tweet;

import java.time.LocalDateTime;

public record TweetsListDTO(
        Long id,
        String content,
        LocalDateTime creationTimestamp,
        Integer likesCount) {

    public TweetsListDTO(Tweet tweet) {
        this(tweet.getId(), tweet.getContent(), tweet.getCreationTimestamp(), tweet.getLikesCount());
    }
}
