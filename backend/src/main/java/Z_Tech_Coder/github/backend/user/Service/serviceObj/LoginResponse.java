package Z_Tech_Coder.github.backend.user.Service.serviceObj;

import Z_Tech_Coder.github.backend.user.entity.UserType;

public record LoginResponse(
        String name,
        String email,
        UserType userType
) {
}
