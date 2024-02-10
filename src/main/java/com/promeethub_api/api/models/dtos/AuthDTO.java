package com.promeethub_api.api.models.dtos;

import com.promeethub_api.domain.enums.UserRole;
import lombok.Builder;
@Builder
public record AuthDTO(String token, String login, UserRole role) {
}
