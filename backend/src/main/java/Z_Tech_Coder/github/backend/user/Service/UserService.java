package Z_Tech_Coder.github.backend.user.Service;

import Z_Tech_Coder.github.backend.user.Service.serviceObj.LoginRequest;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.LoginResponse;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.SignupRequest;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.SignupResponse;
import Z_Tech_Coder.github.backend.user.entity.User;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest);
    SignupResponse signup(SignupRequest signupRequest);
}
