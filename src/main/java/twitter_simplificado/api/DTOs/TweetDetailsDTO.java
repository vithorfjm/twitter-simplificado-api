package twitter_simplificado.api.DTOs;

import twitter_simplificado.api.domain.tweet.Tweet;

import java.time.LocalDateTime;

public record TweetDetailsDTO(
        Long id,
        String content,
        LocalDateTime creationTimestamp,
        Integer likesCount
) {
    public TweetDetailsDTO(Tweet tweet) {
        this(tweet.getId(), tweet.getContent(), tweet.getCreationTimestamp(), tweet.getLikesCount());
    }
}
