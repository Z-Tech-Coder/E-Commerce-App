package Z_Tech_Coder.github.backend.user.Service.serviceObj;

import Z_Tech_Coder.github.backend.user.entity.UserType;

public record SignupRequest(
        String name,
        String email,
        String password,
        UserType userType
) {
}
