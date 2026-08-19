package Z_Tech_Coder.github.backend.user.Service;

import Z_Tech_Coder.github.backend.user.Service.Exception.EmailAlreadyInUse;
import Z_Tech_Coder.github.backend.user.Service.Exception.InvalidCredentials;
import Z_Tech_Coder.github.backend.user.Service.Exception.UserNotFound;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.LoginRequest;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.LoginResponse;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.SignupRequest;
import Z_Tech_Coder.github.backend.user.Service.serviceObj.SignupResponse;
import Z_Tech_Coder.github.backend.user.entity.User;
import Z_Tech_Coder.github.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        User user = (userRepository.findByEmail(loginRequest.email()))
                    .orElseThrow(() -> new UserNotFound("User Not Found"));

        if(user.getPassword().equals(loginRequest.password())){
            return new LoginResponse(
                    user.getName(),
                    user.getEmail(),
                    user.getUserType()
            );
        }else{
            throw new InvalidCredentials("Invalid Credentials");
        }
    }

    @Override
    public SignupResponse signup(SignupRequest signupRequest) {
        boolean status = userRepository.existsByEmail(signupRequest.email());
        if (status){
            throw new EmailAlreadyInUse("Email Already In Use");
        }
        else {
            userRepository.save(
                new User(
                    null,
                    signupRequest.name(),
                    signupRequest.email(),
                    signupRequest.password(),
                    signupRequest.userType()
                )
            );
            return new SignupResponse(true);

        }
    }
}