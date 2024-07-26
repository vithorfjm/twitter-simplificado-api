package twitter_simplificado.api.DTOs;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank
        String login,
        @NotBlank
        String password
) {
}
