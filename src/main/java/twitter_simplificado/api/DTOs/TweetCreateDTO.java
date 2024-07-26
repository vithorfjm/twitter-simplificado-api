package twitter_simplificado.api.DTOs;

import jakarta.validation.constraints.NotBlank;

public record TweetCreateDTO(
        @NotBlank
        String content
) {
}
